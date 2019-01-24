package com.ejet.comm.utils.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtil {

	private static String encode = "UTF-8";// "ISO-8859-1"

	public String getEncode() {
		return encode;
	}

	/**
	 * 设置 编码，默认编码：UTF-8
	 */
	public void setEncode(String encode) {
		GZipUtil.encode = encode;
	}

	/**
	 * 字符串压缩为字节数组
	 */
	public static byte[] compressToByte(String str) {
		return compressToByte(str, encode);
	}

	/**
	 * 字符串压缩为字节数组
	 */
	public static byte[] compressToByte(String src, String srcEncoding) {
		if (src == null || src.length() == 0) {
			return null;
		}
		try {
			byte[] temp = src.getBytes(srcEncoding);
			return compressToByte(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串压缩
	 */
	public static String compressToString(String str) {
		try {
			return new String(compressToByte(str), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串压缩为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] compressToByte(byte[] str) {
		if (str == null || str.length == 0) {
			return null;
		}
		ByteArrayOutputStream out = null;
		GZIPOutputStream gzip = null;
		try {
			out = new ByteArrayOutputStream();
			gzip = new GZIPOutputStream(out);
			gzip.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(gzip);
		}
		return out.toByteArray();
	}

	/**
	 * 字符串解压后返回字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String uncompressToString(String src, String srcEncoding) {
		if (src == null || src.length() == 0) {
			return null;
		}
		try {
			byte[] temp = src.getBytes(srcEncoding);
			return uncompressToString(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String uncompressToString(String src) {
		return uncompressToString(src, "ISO-8859-1");
	}

	/**
	 * 字节数组解压缩后返回字符串
	 */
	public static String uncompressToString(byte[] b) {
		if (b == null || b.length == 0) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		GZIPInputStream gunzip = null;
		try {
			gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(gunzip);
		}
		return out.toString();
	}

	/**
	 * 
	 * @param is
	 * @param os
	 * @throws Exception
	 */
	public static void decompress(InputStream is, OutputStream os) throws Exception {
		GZIPInputStream gis = new GZIPInputStream(is);
		int count;
		byte data[] = new byte[1024];
		while ((count = gis.read(data, 0, 1024)) != -1) {
			os.write(data, 0, count);
		}
		gis.close();
	}

	/**
	 * 文件解压缩
	 * 
	 * @param path
	 * @throws Exception
	 */
	public static void decompress(String path, String outpath) throws Exception {
		decompress(path, outpath, true);
	}

	/**
	 * 文件解压缩
	 * 
	 * @param path
	 * @param delete
	 *            是否删除原始文件
	 * @throws Exception
	 */
	public static void decompress(String path, String outpath, boolean delete)
			throws Exception {
		decompress(new File(path), new File(outpath), delete);
	}

	/**
	 * 文件解压缩
	 * 
	 * @param srcZiped
	 * @param delete
	 *            是否删除原始文件
	 * @throws Exception
	 */
	public static void decompress(File srcZiped, File outUnzip, boolean delete)	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcZiped);
			fos = new FileOutputStream(outUnzip.getAbsolutePath());
			decompress(fis, fos);
			fos.flush();
			if (delete) {
				srcZiped.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(fos);
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		String t = "08809或者色";

		byte[] combyte = compressToByte(t);
		String uncombyte = uncompressToString(combyte);
		System.out.println("combyte: " + combyte);
		System.out.println("uncombyte: " + uncombyte);

		String cop = compressToString(t);
		String dec = uncompressToString(cop);
		System.out.println("zip: " + cop);
		System.out.println("dec: " + dec);

		// System.out.print(dec);

	}

}
