package com.ejet.comm.utils.hex;

import java.io.UnsupportedEncodingException;

public class HexUtils {

	/**
	 * 将字符串转成 asc编码10进制字符串，并用，分割。
	 * @param src
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String string2HexString(String src) throws UnsupportedEncodingException {
		StringBuffer hex = new StringBuffer();
		byte[] utf8Decode = src.getBytes("utf-8");
		for (byte c : utf8Decode) {
			hex.append(Integer.toString(c, 10)).append(",");
		}
		return hex.toString();
	}

    /**
     * 将十六进制字符串转字节数组
     * @param src
     * @return
     * @throws UnsupportedEncodingException
     */
	public static byte[] hexString2ByteArray(String src) throws UnsupportedEncodingException {
		StringBuffer hex = new StringBuffer();
		byte[] utf8Decode = src.getBytes("utf-8");
		for (byte c : utf8Decode) {
			hex.append(Integer.toString(c, 10));
		}
		return utf8Decode;
	}

	// 整数转换成byte数组
	public static byte[] intToByteArray(int i) {
		byte[] result = new byte[2];
		result[0] = (byte) ((i & 0xFF00) >> 8);
		result[1] = (byte) (i & 0xFF);
		return result;
	}

	/**
	 * 16进制字符数组转成String
	 * @param data
	 *            16进制字符数组
	 * @return String 转换后的字符串
	 */
	public static String hexStr(byte[] data) {
		StringBuffer logmes = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String temp = Integer.toHexString(data[i] & 0xff);
			if (temp.length() == 1) {
				logmes.append("0");
			}
			logmes.append(temp);
		}
		return logmes.toString();
	}

	/**
	 * 记录日志（16进制）
	 * @param data
	 *            16进制的字符数组
	 * @return String 转换后的字符串
	 */
	public static String hexlog(byte[] data) {
		/**
		 * 记录日志
		 */
		StringBuffer logmes = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			String temp = Integer.toHexString(data[i] & 0xff);
			logmes.append("0x");
			if (temp.length() == 1) {
				logmes.append("0");
			}
			logmes.append(temp).append(", ");
		}
		return logmes.toString();
	}

	/**
	 * @函数功能: 压缩的BCD码转为10进制串(阿拉伯数据)
	 * @输入参数: bytes 压缩的BCD码
	 * @输出结果: String 10进制
	 */
	public static String bcd2Dec(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString();
	}

	/**
	 * BCD转十进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bcdToString(byte[] bytes) {

		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString();
	}

	/**
	 * 十进制转BCD码
	 * 
	 * @return
	 */
	public static byte intToBcd(int y) {
		byte bcd = 0x00;
		bcd = (byte) (y + (y / 10) * 6);
		return bcd;
	}

	/**
	 * 字符串转bcd码
	 * 
	 * @param time
	 * @return
	 */
	public static byte[] stringToBcdBytes(String time) {
		// 转换后的长度
		int declen = time.length() / 2;
		if (time.length() % 2 == 1) {
			declen++;
			time = time + "0";
		}
		byte[] bcd = new byte[declen];
		for (int i = 0; i < declen; i++) {
			Integer y = Integer.parseInt(time.substring(2 * i, 2 * i + 2));
			bcd[i] = intToBcd(y);
		}
		return bcd;
	}

	/**
	 * @函数功能: 10进制串(阿拉伯数据)转为压缩的BCD码
	 * @输入参数: dec 10进制
	 * @输出结果: byte[] 压缩的BCD码
	 */
	public static byte[] stringToBcd(String dec) {
		// 转换后的长度
		int declen = dec.length() / 2;
		if (dec.length() % 2 == 1) {
			declen++;
			dec = "0" + dec;
		}
		byte[] bcd = new byte[declen];
		// 赋值
		for (int i = 0; i < declen; i++) {
			int f = Integer.parseInt(dec.substring(2 * i, 2 * i + 1));
			int s = Integer.parseInt(dec.substring(2 * i + 1, 2 * i + 2));
			bcd[i] = (byte) (f * 16 + s);
		}
		return bcd;
	}

	/**
	 * 将带符号的byte转换为不带符号的int类型数据
	 * 
	 * @param bt
	 * @return
	 */
	public static int byteToInt(byte bt) {// bt 转换为无符号的int
		if (bt < 0) {
			return (bt + 256);
		} else {
			return bt;
		}
	}

	// 从字节转换为 long型数据, 最大长度为8字节 低位在前, 高位在后...
	// bytlen (1--8), 不在此范围则返回 -1
	/**
	 * 从字节转换为 long型数据, 最大长度为8字节 低位在前, 高位在后...
	 * 
	 * @param data
	 * @param startIndex
	 * @param bytlen
	 * @return
	 */
	public static long byteToLong(byte[] data, int startIndex, int bytlen) {
		long ret = -1;
		if ((bytlen >= 1) && (bytlen <= 8)) {
			ret = byteToInt(data[startIndex + bytlen - 1]);
			for (int i = 1; i < bytlen; i++) {
				ret <<= 8;
				ret += byteToInt(data[startIndex + bytlen - 1 - i]);
			}
		}
		return ret;
	}

	/**
	 * long转为byte，占用8字节
	 * 
	 * @param number
	 * @return
	 */
	public static byte[] longToByte(long number) {
		byte[] b = new byte[8];
		for (int i = 0; i < 8; i++) {
			b[i] = (byte) (number % 256);
			number >>= 8;
		}
		return b;
	}

	/**
	 * long转为byte，占用4字节
	 * 
	 * @param number
	 * @return
	 */
	public static byte[] longToByte4(long number) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (number % 256);
			number >>= 8;
		}
		return b;
	}

	/**
	 * 字节转十六进制
	 * 
	 * @return
	 */
	public static String byteToHex(byte hex) {
		return String.format("%02X", byteToInt(hex));
	}

	/**
	 * 字节转十六进制
	 * 
	 * @return
	 */
	public static String bytesToHex(byte[] hexs) {
		StringBuilder hexStr = new StringBuilder();
		for (int i = 0; i < hexs.length; i++) {
			hexStr.append(String.format("%02X", hexs[i]));
		}
		return hexStr.toString();
	}

	/**
	 * 十六进制字符串转十六进制字节数组
	 * 
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexStr) {
		String str = "0123456789ABCDEF";
		byte[] hexs = new byte[hexStr.length() / 2];
		char[] strArr = hexStr.toCharArray();
		int n;
		for (int i = 0; i < hexs.length; i++) {
			n = str.indexOf(strArr[2 * i]) * 16;
			n += str.indexOf(strArr[2 * i + 1]);
			hexs[i] = (byte) (n & 0xff);
		}
		return hexs;
	}

}
