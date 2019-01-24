package com.ejet.comm.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtils {
	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	static {
		// UPPERCASE：大写  (ZHONG)
		// LOWERCASE：小写  (zhong)
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// WITHOUT_TONE：无音标  (zhong)
		// WITH_TONE_NUMBER：1-4数字表示英标  (zhong4)
		// WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常）  (zhòng)
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		// WITH_V：用v表示ü  (nv)
		// WITH_U_AND_COLON：用"u:"表示ü  (nu:)
		// WITH_U_UNICODE：直接用ü (nü)
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
	}

	public static String getCharacterPinYin(char c) {
		String[] pinyin = null;
		try{
             pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
        }catch(BadHanyuPinyinOutputFormatCombination e) {
            // e.printStackTrace();
        }
		// 如果c不是汉字，toHanyuPinyinStringArray会返回null
		if (pinyin == null) {
			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
               return String.valueOf(c);
			}
           return null;
       }
       // 只取一个发音，如果是多音字，仅取第一个发音
       return pinyin[0];
	}
	/**
	 * 获得字符串拼音
	 *
	 * @param str
	 * @return
	 */
	public static String getPinYin(String str) {
		StringBuilder sb = new StringBuilder();
        String tempPinyin = null;
        try {
        	for (int i = 0; i < str.length(); ++i) {
                tempPinyin = getCharacterPinYin(str.charAt(i));
                if (tempPinyin == null) {
                    // 如果str.charAt(i)非汉字，且不是数字，则置空
                    char character = str.charAt(i);
                    if (Character.isJavaIdentifierPart(character) || Character.isDigit('.')) {
                        sb.append(character);
                    }
                } else {
                    sb.append(tempPinyin);
                }
            }

        } catch(Exception e) {

        }
        return sb.toString();
	}

}
