package com.whyixiu.erp.until;

import java.security.MessageDigest;
import java.util.Random;

/**
 * 对重要数据加密工具类
 * @author majiaqi
 */
public class EncUtil {
	
	//十六进制下数字到字符的映射数组
	private final static String[][] hexDigits = {
		{"2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "h", "n", "o"}, //0
		{"1", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "g", "m", "o"}, //1
		{"2", "3", "4", "5", "6", "7", "8", "a", "b", "c", "d", "e", "h", "i", "n", "o"}, //2
		{"2", "3", "4", "5", "6", "7", "a", "b", "c", "d", "e", "g", "h", "n", "o", "p"}, //3
		{"2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "h", "n", "o"}, //4
		{"1", "2", "3", "5", "6", "7", "8", "a", "b", "c", "d", "e", "f", "g", "h", "o"}, //5
		{"2", "6", "7", "8", "9", "c", "d", "e", "f", "g", "h", "i", "k", "n", "o", "q"}, //6
		{"2", "3", "7", "8", "9", "c", "d", "e", "g", "h", "i", "j", "l", "n", "o", "p"}, //7
		{"1", "4", "5", "7", "9", "a", "c", "e", "f", "h", "i", "n", "o", "q", "s", "u"}, //8
		{"1", "3", "5", "6", "8", "9", "a", "b", "c", "d", "e", "h", "n", "o", "t", "v"}, //9
		{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"}, //10
	};
	
	/**
	 * 使用MD5加密数据返回32位长度的字符串
	 * @param originString	需要加密的数据
	 * @return
	 */
	public static String[] compMD5Encry(String originString){
    	if (originString != null){
        	try{
            	//创建具有指定算法名称的信息摘要
            	MessageDigest md = MessageDigest.getInstance("MD5");
            	//使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            	byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
            	StringBuffer sb = new StringBuffer();
            	int key = new Random().nextInt(9);
               	for (int i = 0; i < results.length; i++){
               		int n = results[i];
                	if (n < 0)
                		n = 256 + n;
                	int d1 = n / 16;
                	int d2 = n % 16;
                	sb.append(hexDigits[key][d1] + hexDigits[key][d2]);
                }
                return new String[]{sb.toString(), key+""};
            } catch(Exception ex){
            	 ex.printStackTrace();
            }
        }
        return null;
	}
	
	/**
	 * 使用MD5加密数据返回32位长度的字符串
	 * @param originString	需要加密的数据
	 * @param key	
	 * @return
	 */
	public static String compMD5Encry(String originString, int key){
    	if (originString != null){
        	try{
            	//创建具有指定算法名称的信息摘要
            	MessageDigest md = MessageDigest.getInstance("MD5");
            	//使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            	byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回
            	StringBuffer sb = new StringBuffer();
               	for (int i = 0; i < results.length; i++){
               		int n = results[i];
                	if (n < 0)
                		n = 256 + n;
                	int d1 = n / 16;
                	int d2 = n % 16;
                	sb.append(hexDigits[key][d1] + hexDigits[key][d2]);
                }
                return sb.toString();
            } catch(Exception ex){
            	 ex.printStackTrace();
            }
        }
        return null;
	}
	
	/**
	 * 验证微信开发者时对请求参数的加密方式
	 * @param str
	 * @return
	 */
	public static String simpMD5Encry(String str) {
		if (str == null){
			return "";
        }
		try{
			//创建具有指定算法名称的信息摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			//使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
			byte[] results = md.digest(str.getBytes());
			//将得到的字节数组变成字符串返回
			int len = results.length;
			StringBuilder buf = new StringBuilder(len * 2);
			for (int i = 0; i < results.length; i++){
				buf.append(hexDigits[10][(results[i] >> 4) & 0x0f]);
				buf.append(hexDigits[10][results[i] & 0x0f]);
			}
			return buf.toString();
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 验证微信开发者时对请求参数的加密方式
	 * @param str
	 * @return
	 */
	public static String simpSHA1Encry(String str) {
		if (str == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(str.getBytes());
			byte[] bytes = messageDigest.digest();
			int len = bytes.length;
			StringBuilder buf = new StringBuilder(len * 2);
			// 把密文转换成十六进制的字符串形式
			for (int i = 0; i < len; i++) {
				buf.append(hexDigits[10][(bytes[i] >> 4) & 0x0f]);
				buf.append(hexDigits[10][bytes[i] & 0x0f]);
			}
			return buf.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(EncUtil.compMD5Encry("123", 6));
	}
}

