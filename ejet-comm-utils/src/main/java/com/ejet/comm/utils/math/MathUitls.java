package com.ejet.comm.utils.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * @author ShenYijie
 * @Description: TODO( )
 * @date 2018年8月6日
 *
 */
public class MathUitls {

	public static BigDecimal math(Double money) {
		BigDecimal bigDecimal = new BigDecimal(money);
		return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal math(Long money, int scale) {
		BigDecimal bigDecimal = new BigDecimal(money);
		return bigDecimal.setScale(scale <= 0 ? 0 : scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 四舍五入取位数
	 * @param scale
	 * @return
	 */
	public static BigDecimal round(Object value, int scale) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}
		ret = ret.setScale(scale < 0 ? 0 : scale, BigDecimal.ROUND_HALF_UP);
		return ret;
	}

	public static Integer formatInteger(Object obj) {
		Integer rs = null;
		try {
			if (obj instanceof String) {
				rs = Integer.valueOf((String) obj);
			}
		} catch (Exception e) {
		}
		return rs;
	}

	public static Long formatLong(Object obj) {
		Long rs = null;
		try {
			if (obj instanceof String) {
				rs = Long.valueOf((String) obj);
			}
		} catch (Exception e) {
		}
		return rs;
	}

	public static Double formatDouble(Object obj) {
		Double rs = null;
		try {
			if (obj instanceof String) {
				rs = Double.valueOf((String) obj);
			}
		} catch (Exception e) {
		}
		return rs;
	}

}
