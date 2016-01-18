package com.natixis.cco.upconnect.converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class UPRequestConverter<T, V> implements InputConverter<T, V> {
	private static final BigDecimal CENT = new BigDecimal("100");
	
	private static final String ONE_ZERO = "0";
	private static final String TWO_ZERO = "00";
	private static final String THREE_ZERO = "000";
	private static final String FOUR_ZERO = "0000";
	private static final String FIVE_ZERO = "00000";
	private static final String SIX_ZERO = "000000";
	private static final String SEVEN_ZERO = "0000000";
	private static final String EIGHT_ZERO = "00000000";

	/**
	 * Retourne un format en centime préfixé de 0.
	 * Exemple : 154.69 EUROS donne 00015469 pour un format 9(8)
	 * @param value
	 * @param sizeTotal
	 * @return
	 */
	protected static String getStringValueFromBigDec(BigDecimal value, int sizeTotal){
		if(null == value){
			return null;
		}
		value = value.multiply(CENT);
		String result = ""+value.intValue();
		
		return prefillWithZeros(result, sizeTotal);
	}
	
	/**
	 * Retourne une chaine pour un 9(3)
	 * @param value
	 * @return
	 */
	protected static String getString3ValueFromInt(int value){
		if(value < 0){
			throw new IllegalArgumentException("Un numérique 9(3) ne doit pas être négatif");
		}
		String result = ""+value;
		return prefillWithZeros(result, 3);
	}
	/**
	 * Retourne une chaine pour un 9(N)
	 * @param value
	 * @param longueur
	 * @return
	 */
	protected static String getStringNValueFromInt(int value,int longueur){
		if(value < 0){
			throw new IllegalArgumentException("Un numérique 9("+longueur+") ne doit pas être négatif");
		}
		String result = ""+value;
		return prefillWithZeros(result, longueur);
	}
	protected static String getTauxFromBigDec(BigDecimal value) throws IllegalArgumentException {
		if(null == value){
			return null;
		}
		if(value.compareTo(CENT) > 0 ){
			throw new IllegalArgumentException("Taux supérieur à 100");
		}
		int intval = value.intValue();
		String intvalstr = ""+value.intValue();
		String res = prefillWithZeros(intvalstr,2);
		BigDecimal decim = value.subtract(new BigDecimal(intval));
		value=decim.multiply(new BigDecimal(1000000));
		
		return res+prefillWithZeros(String.valueOf(value.intValue()), 6);
	}
	
	protected static String dateToString(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
		return sdf.format(date);
	}
	protected static String dateToTimesTamp(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		return sdf.format(date);
	}
	protected static String dateToTimesTampID(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS",Locale.getDefault());
		String sdate= sdf.format(date);
		return sdate.replace('T', '-')+"000";
	}
	private static String prefillWithZeros(String val, int sizeTotal){
		return getFillerZeros(sizeTotal - val.length()) + val;
	}
	
	
	private static String getFillerZeros(int nb){
		switch(nb){
		case 1 : return ONE_ZERO; 
		case 2 : return TWO_ZERO;
		case 3 : return THREE_ZERO;
		case 4 : return FOUR_ZERO;
		case 5 : return FIVE_ZERO;
		case 6 : return SIX_ZERO;
		case 7 : return SEVEN_ZERO;
		case 8 : return EIGHT_ZERO;
		default : return "";
		}
	}
}
