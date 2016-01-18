package com.natixis.cco.upconnect;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

public class TestBigDec {
	
	static BigDecimal CENT = new BigDecimal("100");
	
	private static final String ONE_ZERO = "0";
	private static final String TWO_ZERO = "00";
	private static final String THREE_ZERO = "000";
	private static final String FOUR_ZERO = "00000";
	private static final String FIVE_ZERO = "00000";
	private static final String SIX_ZERO = "000000";
	private static final String SEVEN_ZERO = "0000000";
	private static final String EIGHT_ZERO = "00000000";


	protected static String getMontantFromBigDec(BigDecimal value, int sizeTotal){
		if(null == value){
			return null;
		}
		value = value.multiply(CENT);
		String result = ""+value.intValue();
		
		return prefillWithZeros(result, sizeTotal);
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
		System.out.println("res="+res);
		BigDecimal decim = value.subtract(new BigDecimal(intval));
		System.out.println(decim.toString());
		value=decim.multiply(new BigDecimal(1000000));
		System.out.println(String.valueOf(value.intValue()));
		String result=res+prefillWithZeros(String.valueOf(value.intValue()), 6);
		return result;
	}
	
	protected static BigDecimal getBigDecFromString(String value, int factor) {
		if(null == value){
			return null;
		}
		if(factor <= 0){
			throw new IllegalStateException("factor doit etre strictement positif.");
		}
		
		BigDecimal res = new BigDecimal(value);
		res= res.divide(new BigDecimal(factor));
		
		System.out.println("RES="+res.toString());
		return res;
	}

	@Test
	public void testBigDec(){
		BigDecimal bd = new BigDecimal("156.23");
		String res = getMontantFromBigDec(bd,8);
		Assert.assertEquals("00015623",res);
	}
	
	@Test
	public void testBigDecMaxi(){
		BigDecimal bd = new BigDecimal("999999.9");
		String res = getMontantFromBigDec(bd,8);
		System.out.println("____"+res);
		Assert.assertEquals("99999990",res);
	}
	@Test
	public void testBigDecMini(){
		BigDecimal bd = new BigDecimal("0.5");
		String res = getMontantFromBigDec(bd,8);
		System.out.println("____"+res);
		Assert.assertEquals("00000050",res);
	}
	
	@Test
	public void testTaux1(){
		BigDecimal bd = new BigDecimal("0.0001");
		Assert.assertEquals("00000100", getTauxFromBigDec(bd));
	}
	
	@Test
	public void testTaux2(){
		BigDecimal bd = new BigDecimal("4.26300000000000");
		Assert.assertEquals("04263000", getTauxFromBigDec(bd));
	}
	
	@Test
	public void testTaux3(){
		BigDecimal bd = new BigDecimal("99.0000010");
		Assert.assertEquals("99000001", getTauxFromBigDec(bd));
	}
	
	@Test
	public void testString1(){
		Assert.assertEquals(new BigDecimal(154), getBigDecFromString("00015400", 100));
	}
	
	@Test
	public void testStringMaxi(){
		Assert.assertEquals(new BigDecimal("999999.99"), getBigDecFromString("99999999", 100));
	}
	@Test
	public void testStringTaux1(){
		Assert.assertEquals(new BigDecimal("5.3265"), getBigDecFromString("05326500", 1000000));
	}	
}
