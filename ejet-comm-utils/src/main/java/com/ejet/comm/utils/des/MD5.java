package com.ejet.comm.utils.des;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * MD5工具类
 */
public final class MD5 {
	/**
	 * 对输入字符进行MD5编码
	 * @param s 输入字符
	 * @return 编码后的字符
	 */
	public final static String getMD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 对md5加密后的结果进行反转,因为目前有很多md5在线解码工具,页面中md5.js文件中也提供了相同的函数
	 * @param s 需加密的字符串
	 * @return 处理后的md5加密字符串
	 */
	public final static String convertMD5(String s) {
		return new StringBuffer(getMD5(s)).reverse().toString();
	}
	
	/**
	 * 获取文件md5加密串
	 * @param file 文件路径
	 * @return 加密后的md5字符串
	 */
	public final static String getFileMD5(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return bytesToString(md.digest());
        } catch (Exception e) {
            return null;
        } finally {
        	if(null!=fis){
        		try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}	
        }
    }

	public static String bytesToString(byte[] data) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f'};
        char[] temp = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            temp[i * 2] = hexDigits[b >>> 4 & 0x0f];
            temp[i * 2 + 1] = hexDigits[b & 0x0f];
        }
        return new String(temp);
    }


}
