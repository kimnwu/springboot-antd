package com.ucsmy.commons.utils;

import org.apache.logging.log4j.LogManager;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * StringAndNumberTool 封装了一些数值和字符串常用方法
 * @author xjw
 * @version 1.0
 */
public class StringAndNumberUtil{

	private final static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	public final static short BYTE = 0;
	public final static short SHORT = 1;
	public final static short INT = 2;
	public final static short LONG = 3;
	public final static short FLOAT = 4;
	public final static short DOUBLE = 5;
	public final static short BOOLEAN = 6;
	public final static short CHAR = 7;
	public final static short UPPER = 0;
	public final static short LOWER = 1;
	/**
	 * 将指定字符串转换为指定类型的数据
	 * @param str 指定字符串
	 * @param type 类型（该类中指定常量类型BYTE，SHORT，INT，LONG，FLOAT，DOUBLE，BOOLEAN，指定CHAR返回null）
	 * @param radix 基数，转换为数值类型时的进制数，范围为2<=radix<=36
	 * @return 转换后的对象
	 */
	public static Object changeToBaseType(String str, short type, int radix) throws NumberFormatException{
		try{
			if (str == null || StringUtils.isEmpty(str.trim())){
				return null;
			}
			Object obj;
			switch(type){
				case BYTE :
					obj = Byte.parseByte(str.trim(),radix);
					break;
				case SHORT :
					obj = Short.parseShort(str.trim(),radix);
					break;
				case INT :
					obj = Integer.parseInt(str.trim(),radix);
					break;
				case LONG :
					obj = Long.parseLong(str.trim(),radix);
					break;
				case FLOAT :
					obj = Float.parseFloat(str.trim());
					break;
				case DOUBLE :
					obj = Double.parseDouble(str.trim());
					break;
				case BOOLEAN :
					obj = Boolean.parseBoolean(str.trim());
					break;
				default:
					return null;
			}
			return obj;
		}catch (Exception e){
			log.error(e);
			throw e;
		}
	}
	
	/**
	 * 将指定字符串转换为指定类型的数据,数值为10进制
	 * @param str 指定字符串
	 * @param type 类型（该类中指定常量类型BYTE，SHORT，INT，LONG，FLOAT，DOUBLE，BOOLEAN，指定CHAR返回null）
	 * @return 转换后的对象
	 */
	public static Object changeToBaseType(String str, short type){
		try{
			return changeToBaseType(str,type,10);
		}catch(Exception e){
			log.error(e);
			throw e;
		}
	}
	
	/**
	 * 获得指定格式的double或float
	 * @param val 指定数值，可以为double或float
	 * @param format 格式字符串,为null时不改变返回val
	 * @return
	 */
	public static double toDecimalDouble(double val, String format) throws NumberFormatException{
		try{
			if(format == null){
				return val;
			}
			DecimalFormat df = new DecimalFormat(format);
			String str = df.format(val);
			return Double.parseDouble(str);
		}catch (Exception e){
			log.error(e);
			throw e;
		}
	}

	/**
	 * 将传入的字符串转为指定编码
	 * @param str 传入字符串
	 * @param ecode 当前编码类型，为null时用平台默认编码
	 * @param dcode 解码编码类型，为null时用平台默认编码
	 * @return 转换后的字符串
	 */
	public static String toString(String str, String ecode, String dcode) throws UnsupportedEncodingException{
		try{
			if (isNullAfterTrim(str)){
				return str;
			}
			if (isNullAfterTrim(ecode) && isNullAfterTrim(dcode)){		//编码都为空
				return str;
			}
			if(isNullAfterTrim(ecode)){
				return new String(str.getBytes(),dcode.trim());
			}
			if(isNullAfterTrim(dcode)){
				return new String(str.getBytes(ecode.trim()));
			}
			return new String(str.getBytes(ecode.trim()),dcode.trim());
		} catch(Exception e){
			log.error(e);
			throw e;
		}
	}

	/**
	 * 将传入的字符串转为utf-8编码
	 * @param str 传入字符串
	 * @param ecode 当前编码类型，为null时用平台默认编码
	 * @return 转换后的字符串
	 */
	public static String toUTF8String(String str, String ecode) throws UnsupportedEncodingException{
		try{
			return toString(str,ecode,"UTF-8");
		}
		catch(Exception e){
			log.error(e);
			throw e;
		}
	}

	/**
	 * 获取 lenght位数的随机数值
	 * @param length 随机数字位数
	 * @param nozero 开头不为0的位数
	 * @return
	 */
	public static String getRandomNumber(int length, int nozero){
		try {
			if(length <= 0){
				return "";
			}
			if(nozero < 0){
				nozero = 0;
			}
			else if(nozero > length){
				nozero = length;
			}
			String charlist = "0123456789";
			Random random = new Random();
			StringBuffer str = new StringBuffer();
			for(int i = 0; i < nozero; i++){
				String charlist1 = "123456789";
				str.append(charlist1.charAt(random.nextInt(charlist1.length())));
			}
			for (int i = nozero; i < length; i++){
				str.append(charlist.charAt(random.nextInt(charlist.length())));
			}
			return str.toString();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	

	/**
	 * 获取 lenght位数的随机数值和大小写字母组合字符串
	 * @param length 随机位数
	 * @return
	 */
	public static String getRandom(int length){
		try {
			if(length <= 0){
				return "";
			}
			String charlist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			Random random = new Random();
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < length; i++){
				str.append(charlist.charAt(random.nextInt(charlist.length())));
			}
			return str.toString();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断字符串是否可以转换成整数,前后有空格的返回结果为false
	 * @param str 传入的字符串
	 * @return boolean
	 */
	public static boolean isInteger(String str){
		try {
			if (isNullAfterTrim(str)){
				return false;
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[-\\+]?[\\d]*$");
			return pattern.matcher(str).matches();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * @param str 传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str){
		try {
			if (isNullAfterTrim(str)){
				return false;
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[-\\+]?[.\\d]*$");
			return pattern.matcher(str).matches();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return ""或null都返回true
	 */
	public static boolean isNull(String str){
		try {
			if (str == null || "".equals(str)){
				return true;
			}
			return false;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断去除前后空的字符串是否为空
	 * @param str
	 * @return ""或null都返回true
	 */
	public static boolean isNullAfterTrim(String str){
		try {
			if (str == null || "".equals(str.trim())){
				return true;
			}
			return false;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断去除前后空的字符串是否为空，若为空返回“”，若不空，返回原来str
	 * @param str
	 * @return ""或str
	 */
	public static String returnNotNullStr(String str){
		try {
			if (str == null || "".equals(str.trim())){
				return "";
			}
			return str;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 字符串的前后去除指定的字符串
	 * @param str 原字符串
	 * @param indexStr 要去除的字符串,若为null，去除前后空格（等同于trim）
	 * @return 去除后的字符串
	 */
	public static String trimStr(String str, String indexStr){
		try {
			if (str == null){
				return null;
			}
			if(indexStr == null){
				return str.trim();
			}
			StringBuffer newStr = new StringBuffer(str);
			if(newStr.indexOf(indexStr) == 0){
				newStr = new StringBuffer(newStr.substring(indexStr.length()));
			}
			if (newStr.lastIndexOf(indexStr) == newStr.length() - indexStr.length() && newStr.lastIndexOf(indexStr) != -1){
				newStr = new StringBuffer(newStr.substring(0, newStr.lastIndexOf(indexStr)));
			}
			if(newStr.indexOf(indexStr) !=0 && (newStr.lastIndexOf(indexStr) == -1 
					|| newStr.lastIndexOf(indexStr) != newStr.length() - indexStr.length())){
				return newStr.toString();
			}
			else{
				return trimStr(newStr.toString(),indexStr);
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/**
	 * 字符串首字母改为大写或小写
	 * @param str 原字符串 
	 * @param type 该类常量UPPER为大写，LOWER为小写
	 * @return
	 */
	public static String firstUpOrLow(String str, short type){
		try {
			if (isNullAfterTrim(str)){
				return str;
			}
			if (type == UPPER){
				String newStr = str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
				return newStr;
			}
			else{
				String newStr = str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toLowerCase());
				return newStr;
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 判断是否超过长度
	 * @param str 字符串，null时返回false
	 * @param size	长度,为负数时返回false
	 * @return true超过给定size，false未超过给定size
	 */
	public static boolean isBeyondSize(String str, int size){
		try {
			if(isNull(str) || size < 0){
				return false;
			}
			int length = str.length();
			return length > size;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 将字符串数组按指定的分隔符转为字符串
	 * @param strArr 字符串数组，若为空，返回null，若length为0，返回""
	 * @param split 分隔符,若为空，默认为“,”
	 * @return
	 */
	public static String strArrToString(String[] strArr, String split){
		try {
			if(strArr == null){
				return null;
			}
			if(strArr.length == 0){
				return "";
			}
			StringBuilder strBuf = new StringBuilder();
			if(split == null){
				split = ",";	//若为空，默认为“,”
			}
			for(int i = 0; i < strArr.length; i++){
				strBuf.append(strArr[i] + split);
			} 
			String str = strBuf.toString();
			return str.substring(0, str.length() - split.length());
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	public static Map convertObjToMap(Object obj){
		Map<String,Object> reMap = new HashMap<String,Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for(int i=0;i<fields.length;i++){
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					reMap.put(fields[i].getName(), o);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reMap;
	}
}
