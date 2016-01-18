package com.natixis.cco.upconnect.converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;


public abstract class UPResponseConverter<U,S> implements OutputConverter<U, S>{
	
	private static int positiveDiff = 'A' - '1';
	private static int negativeDiff = 'J' - '1';
	
	/**
     * Les entiers signés sont restitués au format EBCDIC dans la COMMAREA.
     * Le signe et la décimale sont encodés dans le dernier octet.
     *   - le premier demi-octet de gauche contient le signe (positif / négatif)
     *   - le second demi octet contient la dernière décimale
     * Ex: 000000006477I correspond à +64779
	 * @param value au format ESCBIC
	 * @return
	 */
	protected static String getEscbicValue( final String value ) {
		if (StringUtils.isNotBlank(value)){
	    	String ret;
			String sign = "";
			char lastChar;
	
			ret = value.trim();
			lastChar = ret.substring(ret.length() - 1).toUpperCase().charAt(0);
	
			switch (lastChar) {
				case 'È' : sign = "-";
				case 'É' :
					lastChar = '0';
				break;
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
					lastChar = (char) (lastChar - positiveDiff);
				break;
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
					sign = "-";
					lastChar = (char) (lastChar - negativeDiff);
				default:
			}
			ret = sign + ret.substring(0, ret.length() - 1) + lastChar;
	        return ret;						
		} else {
			return null;
		}
    }

	protected static String applyS9V9Format(String value, String format) {
		// Get S9 & V9 values from regexp
   		if (format != null) {
			String regex = "^S9\\(([0-9]*)\\)V9\\(([0-9]*)\\)$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(format);
			int s9 = 0;
			int v9 = 0;
			
			if (m.find()){
				if (m.group(1) != null) s9 = Integer.parseInt(m.group(1));
				if (m.group(2) != null) v9 = Integer.parseInt(m.group(2));
			} else {
				throw new SavTechnicalException("Le format :" + format +" est incorrect ou n'est pas pris en charge pour la valeur " + value);
			}
			if (s9 != 0 && v9 != 0){
				value = applyS9V9(value, s9 , v9);
			}
		} else {
			throw new SavTechnicalException("Le format " + format +" n'est pas renseigne pour la valeur " + value);
		}
   		return value;
	}
	
	/**
	 * Applique le format COBOL S9(x)V9(y) au String contenant la valeur a traiter
	 * Le choix de l'utilisation de String pour positionner la virgule permet d'eviter 
	 * les erreurs de precisions avec l'utilisation de division sur des double ou float
	 * @param value
	 * @param s9
	 * @param v9
	 * @return
	 */
	private static String applyS9V9(String value, int s9, int v9) {
		if(StringUtils.isNotBlank(value)){
			if (s9 + v9 > 18) {
				throw new SavTechnicalException("Le format S9("+ s9 + ")V9("+ v9 +") depasse le limites COBOL (18 Digits)");
			}else if (value.startsWith("-") && value.length() == s9+v9+1) {
				value = value.substring(0, s9+1) + "." + value.substring(s9+1);
			} else if (value.length() == s9+v9){
				value = value.substring(0, s9) + "." + value.substring(s9);
			} else {
				throw new SavTechnicalException("Le format S9("+ s9 + ")V9("+v9+") ne correspond pas a la longueur des donnees:"+value);
			}
		}
		return value;
	}
	
	
	protected static BigDecimal getBigDec(String value, COBOLDecimal format) throws ConverterException {
		if(null == value){
			return null;
		}
		try{
			return new BigDecimal(applyS9V9(getEscbicValue(value),
					format.getS9(), format.getV9()));
		}catch (Throwable t){
			throw new ConverterException(t);
		}
	}
	
	/**
	 * Retourne un BigDecimal à partir d'une chaine.
	 * 
	 * Exemple : 00034599 doit retourner un chiffre de 354.99 
	 * @param value le montant au format 9(8).
	 * @param factor le nombre de décimal à retrouver.
	 * @return
	 * @throws ConverterException
	 */
	protected static BigDecimal getBigDecFromString(String value, int factor) throws ConverterException {
		if(null == value){
			return null;
		}
		if(factor <= 0){
			throw new IllegalStateException("factor doit etre strictement positif.");
		}
		try{
			BigDecimal res = new BigDecimal(value);
			if(res.intValue() > 999999){
				throw new ConverterException("Montant doit être inférieur à 1 000 000");
			}
			return res.divide(new BigDecimal(factor));
		}catch(Throwable t){
			throw new ConverterException(t);
		}
	}
	
	protected static Integer getInteger(String value) throws ConverterException {
		if(null == value){
			return null;
		}
		try{
			return Integer.parseInt(value);
		}catch (Throwable t){
			throw new ConverterException(t);
		}
	}
	
	protected static Long getLong(String value) throws ConverterException {
		if(null == value){
			return null;
		}
		try{
			return Long.parseLong(value);
		}catch (Throwable t){
			throw new ConverterException(t);
		}
	}
		
	protected static BigDecimal getBigDecFromTaux(String taux,int factor){
		if(null == taux){
			return null;
		}
		BigDecimal bd = new BigDecimal(taux);
		
		return bd.divide(new BigDecimal(factor));
	}
	protected static Date getDateFromString(String timesTamp) throws ConverterException{
		if(StringUtils.isNotEmpty(timesTamp)){
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
				return sdf.parse(timesTamp);
			}catch(Throwable t){
				throw new ConverterException(t);
			}
		}
		return null;
	}
	
	protected static Date getTimesTampIDFromString(String timesTamp) throws ConverterException{
		if(StringUtils.isNotEmpty(timesTamp)){
			try{
				
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS", Locale.getDefault());
					return sdf.parse(timesTamp.substring(0, timesTamp.length()-3));
		
			}catch(Throwable t){
				throw new ConverterException(t);
			}
		}else return null;
	}
	
}
