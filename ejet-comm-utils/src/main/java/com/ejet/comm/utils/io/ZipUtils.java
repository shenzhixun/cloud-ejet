package com.ejet.comm.utils.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ZipUtils {

	private static final String charset = "ISO-8859-1";
	/**
	 * 压缩字符串，数据库中一般格式为: ISO-8859-1
	 * @param str
	 * @return
	 */
	public static String zipString(String str) {
		String result = null;
		ByteArrayOutputStream bos = null;
		GZIPOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new GZIPOutputStream(bos);
			os.write(str.getBytes());
			os.close();
			bos.close();
			byte[] bs = bos.toByteArray();
			result = new String(bs, charset);
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			IOUtils.closeQuietly(bos);
			IOUtils.closeQuietly(os);
		}
		return result;
	}

	public static String unzipString(String str) {
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		GZIPInputStream is = null;
		byte[] buf = null;
		try {
			bis = new ByteArrayInputStream(str.getBytes(charset));
			bos = new ByteArrayOutputStream();
			is = new GZIPInputStream(bis);
			buf = new byte[1024];
			int len;
			while ((len = is.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			is.close();
			bis.close();
			bos.close();
			return new String(bos.toByteArray());
		} catch (Exception ex) {
			ex.printStackTrace();
			return str;
		} finally {
			IOUtils.closeQuietly(bis);
			IOUtils.closeQuietly(bos);
			IOUtils.closeQuietly(is);
			buf = null;
		}
	}
	
	
//	public static void main(String[] arg) throws IOException {
//		StringBuilder content = FileUtils.readFile("c:\\device.ini", "gbk");
//		System.out.println(content.length());
//		String ziped = zipString(content.toString());
//		System.out.println(ziped.length());
//		
//		String unziped = unzipString(ziped);
//		System.out.println(unziped.length());
//		FileUtils.writeFile("c:\\deviceunzip.ini", new String(unziped.getBytes("ISO-8859-1"), "UTF-8"), "utf-8");
//		
//		
//	}
	
	

}
