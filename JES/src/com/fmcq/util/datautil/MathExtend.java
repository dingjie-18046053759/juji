package com.fmcq.util.datautil;

import java.math.BigDecimal;

/**
 * 浮点数精确运算
 * 
 * @author administrator
 * 
 */
public class MathExtend {
	// 默认除法运算精度
	private static final int DEFAULT_DIV_SCALE = 10;

	/**
	 * 比较类型：==,!=,>,<,>=,<=
	 * @author wind
	 *
	 */
	public enum CompareType{
		/**
		 * 相等(==)
		 */
		EQ("=="),//相等
		/**
		 * 不等(!=)
		 */
		NE("!="),//不等
		/**
		 * 大于(>)
		 */
		GT(">"), //大于
		/**
		 * 小于(<)
		 */
		LT("<"),//小于
		/**
		 * 大等于(>=)
		 */
		GE(">="),//大等于
		/**
		 * 小等于(<=)
		 */
		LE("<=") //小等于
		;
		private String value;
		private CompareType(String value){
			this.value=value;
		}
		public String getValue() {
			return value;
		}
		@Override
		public String toString() {
			return this.value.toString();
		}
	}
	
	/**
	 * 
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的和
	 * 
	 */

	public static double add(double v1, double v2)

	{

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	/**
	 * 
	 * 提供精确的加法运算
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数数学加和，以字符串格式返回
	 * 
	 */

	public static String add(String v1, String v2)

	{

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.add(b2).toString();

	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的差
	 * 
	 */

	public static double subtract(double v1, double v2)

	{

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	/**
	 * 
	 * 提供精确的减法运算
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数数学差，以字符串格式返回
	 * 
	 */

	public static String subtract(String v1, String v2)

	{

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.subtract(b2).toString();

	}

	/**
	 * 
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的积
	 * 
	 */

	public static double multiply(double v1, double v2)

	{

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 * 
	 * 提供精确的乘法运算
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的数学积，以字符串格式返回
	 * 
	 */

	public static String multiply(String v1, String v2)

	{

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.multiply(b2).toString();

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 
	 * 小数点以后10位，以后的数字四舍五入,舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的商
	 * 
	 */

	public static double divide(double v1, double v2)

	{

		return divide(v1, v2, DEFAULT_DIV_SCALE);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 定精度，以后的数字四舍五入。舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @param scale
	 *            表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的商
	 * 
	 */

	public static double divide(double v1, double v2, int scale)

	{

		return divide(v1, v2, scale, BigDecimal.ROUND_HALF_UP);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 定精度，以后的数字四舍五入。舍入模式采用用户指定舍入模式
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @param scale
	 *            表示需要精确到小数点以后几位
	 * 
	 * @param round_mode
	 *            表示用户指定的舍入模式
	 * 
	 * @return 两个参数的商
	 * 
	 */

	public static double divide(double v1, double v2, int scale, int round_mode) {

		if (scale < 0)

		{

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, round_mode).doubleValue();

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 
	 * 小数点以后10位，以后的数字四舍五入,舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @return 两个参数的商，以字符串格式返回
	 * 
	 */

	public static String divide(String v1, String v2)

	{

		return divide(v1, v2, DEFAULT_DIV_SCALE);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 定精度，以后的数字四舍五入。舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @param scale
	 *            表示需要精确到小数点以后几位
	 * 
	 * @return 两个参数的商，以字符串格式返回
	 * 
	 */

	public static String divide(String v1, String v2, int scale)

	{

		return divide(v1, v2, scale, BigDecimal.ROUND_HALF_UP);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 定精度，以后的数字四舍五入。舍入模式采用用户指定舍入模式
	 * 
	 * @param v1
	 * 
	 * @param v2
	 * 
	 * @param scale
	 *            表示需要精确到小数点以后几位
	 * 
	 * @param round_mode
	 *            表示用户指定的舍入模式
	 * 
	 * @return 两个参数的商，以字符串格式返回
	 * 
	 */

	public static String divide(String v1, String v2, int scale, int round_mode)

	{

		if (scale < 0)

		{

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(v1);

		BigDecimal b2 = new BigDecimal(v2);

		return b1.divide(b2, scale, round_mode).toString();

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @return 四舍五入后的结果
	 * 
	 */

	public static double round(double v, int scale)

	{

		return round(v, scale, BigDecimal.ROUND_HALF_UP);

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @param round_mode
	 *            指定的舍入模式
	 * 
	 * @return 四舍五入后的结果
	 * 
	 */

	public static double round(double v, int scale, int round_mode)

	{

		if (scale < 0)

		{

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		return b.setScale(scale, round_mode).doubleValue();

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @return 四舍五入后的结果，以字符串格式返回
	 * 
	 */

	public static String round(String v, int scale)

	{

		return round(v, scale, BigDecimal.ROUND_HALF_UP);

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @param round_mode
	 *            指定的舍入模式
	 * 
	 * @return 四舍五入后的结果，以字符串格式返回
	 * 
	 */

	public static String round(String v, int scale, int round_mode)

	{

		if (scale < 0)

		{

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(v);

		return b.setScale(scale, round_mode).toString();

	}

	/**
	 * 转换成BigDecimal精确比较两个数值
	 * @param v1 数据1
	 * @param v2 数据2
	 * @param type 比较类型：==,!=,>,<,>=,<=
	 * @return
	 */
	public static boolean compareTo(double v1,double v2,CompareType type){
		return compareTo(Double.toString(v1),Double.toString(v2), type);
	}
	
	/**
	 * 转换成BigDecimal精确比较两个数值
	 * @param v1 数据1
	 * @param v2 数据2
	 * @param type 比较类型：==,!=,>,<,>=,<=
	 * @return
	 */
	public static boolean compareTo(String v1,String v2,CompareType type){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		
		if(CompareType.EQ.equals(type)){
			//== 相等判断
			return b1.compareTo(b2) == 0;
		}else if(CompareType.NE.equals(type)){
			//!= 不等判断
			return b1.compareTo(b2) != 0;
		}else if(CompareType.GE.equals(type)){
			//>= 大等于判断
			return b1.compareTo(b2) >=0;
		}else if(CompareType.LE.equals(type)){
			//<= 小等于判断
			return b1.compareTo(b2) <=0;
		}else if(CompareType.GT.equals(type)){
			//> 大于判断
			return b1.compareTo(b2) >0;
		}else if(CompareType.LT.equals(type)){
			// < 小于判断
			return b1.compareTo(b2) <0;
		}else{
			throw new RuntimeException("无效的数据比较类型！");
		}
	}
}
