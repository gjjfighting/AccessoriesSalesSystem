package kehaofei.com.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class ByteUtils {
	
	/**
	 * @parameter log 日志类定义
	 */
	static Logger log = Logger.getLogger(ByteUtils.class.getSimpleName());
	
	/**
	 * 格式化日期串：yyyy/MM/dd hh:mm:ss
	 * @author XCCD
	 * @return
	 */
	public static String dateFormat(Timestamp time){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String  str = null;
		if(time != null){
			str = format.format(time);
		}else{
			str = "";
		}
		return str;
		
	}
	
	/**
	 * 格式化日期串：yyyy/MM/dd hh:mm:ss
	 * @author XCCD
	 * @return
	 */
	public static String dateFormat(Long time){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String  str = null;
		if(time != null){
			str = format.format(time);
		}else{
			str = "";
		}
		return str;
		
	}
	/**
	 * 格式化日期串：yyyy-MM-dd
	 * @author XCCD
	 * @return
	 */
	public static String dateFormat_LOG(){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String  str = format.format(System.currentTimeMillis());
		return str;
		
	}	
	
	
	/**
	 * 获取当前系统时间
	 * @param formatStr
	 * @return
	 */
	public static String getNowTimeStr(String formatStr){

		try {
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			String str = format.format(new Date());
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	
	/**
	 * 格式化日期串：yyyy/MM/dd hh:mm:ss.S
	 * @author XCCD
	 * @return
	 */
	public static String dateFormat(String dateStr,String formatStr){
		
		try {
			String date_str = dateStr.substring(0, 6) + dateStr.substring(8, dateStr.length());			
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			SimpleDateFormat format1 = new SimpleDateFormat("yyMMddHHmmss");
			Date date = format1.parse(date_str);
			String week = getWeek(date);
			String str = format.format(date);
			return str+"  "+ week;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			return dateStr;
		}
		
	}
	
	public static String dateFormat(String dateStr,String dateFormat, String formatStr){
		
		try {			
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			SimpleDateFormat format1 = new SimpleDateFormat(dateFormat);
			Date date = format1.parse(dateStr);
			String str = format.format(date);
			return str;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			return dateStr;
		}
		
	}
	
	/**
	 * 计算对应日期的星期
	 */
	public static String getWeek(Date date){
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		} 
		return weeks[week_index];
	}
	
	public static int getWeekInt(Date date){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		} 
		return week_index;
	}
	
	
	/**
	 * 格式化日期串：yyyy-MM-dd hh:mm:ss.S
	 * @author XCCD
	 * @param dateStr 日期串
	 * @param formatStr 格式
	 * @return
	 */
	public static boolean checkDateFormat(String dateStr,String formatStr){
		
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			format.setLenient(false);
			format.parse(dateStr);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	
	/**
	 * 格式化日期串：yyyy-MM-dd hh:mm:ss.S
	 * @author XCCD
	 * @return
	 */
	public static String dateFormat(){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String  str = format.format(System.currentTimeMillis());
		return str.substring(0, str.length()-2);
		
	}
	
	
	/**
	 * byte数组打印输出，原数组十六进制数据
	 * @author XCCD
	 * @param Data
	 * @return
	 */
	public static String ByteToString(byte[] Data){
		String br = "";
		for(byte b : Data){
			String hex = Integer.toHexString(b & 0xFF);
			if(hex.length()==1){
				hex = "0"+hex;
			}
			br += hex.toUpperCase() + " ";
		}
		return br;
	}
	
	public static void main(String[] args) {
//		byte[] b = String2ACSIIByte("01.01.00.f0.05.ff");
//		for(byte b1: b){
//			System.out.println("字符转成byte::\t"+Integer.toHexString(b1));
//		}
//		System.out.println("实际异或结果十六进制：：："+ (0x01^0x01^0x01));
//		System.out.println("实际异或结果十进制：：："+ (48^49^50));
//		byte[]  bu= CreateBCC(StringToByteArr("01 52 31 02 00 00 62 01 05 FF 28 2A 29 03"));
//		
//		System.out.println(bu[0] +"\t"+ bu[0]);
//		
//		byte bt = 0x35; // 0011 0101  
//        // 输出 [0, 0, 1, 1, 0, 1, 0, 1]
//        System.out.println(Arrays.toString(getBooleanArray(bt)));  
//        // 输出 00110101  
//        System.out.println(byteToBit(bt));  
//        // JDK自带的方法，会忽略前面的 0  
//        System.out.println(Integer.toBinaryString(0x35));  
		
		String str = ByteUtils.dateFormat(System.currentTimeMillis());
		System.out.println(str);
		
	}

}
