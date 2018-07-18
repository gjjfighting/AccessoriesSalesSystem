package kehaofei.com.utils;


import java.math.BigDecimal;

public class MathUtil {

	/**
	 * 提供精确的加法运算。
	 *
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
	
	public static BigDecimal add_BigDecimal(Object v1, Object v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(0.00));
		BigDecimal b2 = new BigDecimal(Double.toString(0.00));
		if(v1 instanceof BigDecimal){
			b1 = (BigDecimal)v1;
		}
		if(v1 instanceof Double){
			b1 = new BigDecimal(Double.toString((Double)v1));
		}
		if(v1 instanceof Integer){
			b1 = new BigDecimal(Integer.toString((Integer)v1));
		}
		if(v1 instanceof String){
			b1 = new BigDecimal((String)v1);
		}
		
		if(v2 instanceof BigDecimal){
			b2 = (BigDecimal)v2;
		}
		if(v2 instanceof Double){
			b2 = new BigDecimal(Double.toString((Double)v2));
		}
		if(v2 instanceof Integer){
			b2 = new BigDecimal(Integer.toString((Integer)v2));
		}
		if(v2 instanceof String){
			b2 = new BigDecimal((String)v2);
		}
		
		return b1.add(b2);
	}

	/**
	 * 提供精确的减法运算。
	 *
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	public static BigDecimal sub_BigDecimal(Object v1, Object v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		try {
			if(v1 instanceof BigDecimal){
				b1 = (BigDecimal)v1;
			}
			if(v1 instanceof Double){
				b1 = new BigDecimal(Double.toString((Double)v1));
			}
			if(v1 instanceof Integer){
				b1 = new BigDecimal(Integer.toString((Integer)v1));
			}
			if(v1 instanceof String ){
				b1 = new BigDecimal(((String)v1).trim().equals("")?"0":((String)v1).trim());
			}
			
			if(v2 instanceof BigDecimal){
				b2 = (BigDecimal)v2;
			}
			if(v2 instanceof Double){
				b2 = new BigDecimal(Double.toString((Double)v2));
			}
			if(v2 instanceof Integer){
				b2 = new BigDecimal(Integer.toString((Integer)v2));
			}
			if(v2 instanceof String){
				b2 = new BigDecimal(((String)v2).trim().equals("")?"0":((String)v1).trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		return b1.subtract(b2);
	}

	/**
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	public static float mul_float(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).floatValue();
	}
	
	public static BigDecimal mul_BigDecimal(Object v1, Object v2) {
		BigDecimal b1 = null;
		BigDecimal b2 = null;
		try {
			if(v1 instanceof BigDecimal){
				b1 = (BigDecimal)v1;
			}
			if(v1 instanceof Double){
				b1 = new BigDecimal(Double.toString((Double)v1));
			}
			if(v1 instanceof Integer){
				b1 = new BigDecimal(Integer.toString((Integer)v1));
			}
			if(v1 instanceof String ){
				b1 = new BigDecimal(((String)v1).trim().equals("")?"0":((String)v1).trim());
			}
			
			if(v2 instanceof BigDecimal){
				b2 = (BigDecimal)v2;
			}
			if(v2 instanceof Double){
				b2 = new BigDecimal(Double.toString((Double)v2));
			}
			if(v2 instanceof Integer){
				b2 = new BigDecimal(Integer.toString((Integer)v2));
			}
			if(v2 instanceof String){
				b2 = new BigDecimal(((String)v2).trim().equals("")?"0":((String)v2).trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		return b1.multiply(b2);
	}


	public static int mul_int(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).intValue();
	}

	/**
	 * 提供精确的除法运算。
	 *
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的除法结果
	 */
	public static double div(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2).doubleValue();
	}


	/**
	 * 数据运算（每个字节加上0x33）
	 * @author XCCD
	 * @param bt
	 * @return
	 */
	public static byte[] DataSum33(byte[] bt){
		byte[] returnBt = new byte[bt.length];
		for(int i=0; i<bt.length; i++){
			returnBt[i] = (byte) ((bt[i]+0x33) & 0xff);
		}
		return returnBt;
	}

	/**
	 * 接收数据运算还原（每个字节减去0x33）
	 * @author XCCD
	 * @param bt
	 * @return
	 */
	public static byte[] DataSub33(byte[] bt){
		byte[] returnBt = new byte[bt.length];
		for(int i=0; i<bt.length; i++){
			returnBt[i] = (byte) ((bt[i]-0x33) & 0xff);
		}
		return returnBt;
	}

	/**
	 * @author XCCD
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(div(123456,1243));
	}

}
