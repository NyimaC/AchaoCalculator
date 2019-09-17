package com.nyima.operation;

/**
 * @author Chen Panwen
 * @data 2019/9/16 9:59
 */
public interface IOperation {
	/**
	 * 用于执行加法运算操作，返回结果
	 * @param x
	 * @param y
	 * @return
	 */
	int addition(int x, int y);

	/**
	 * 用于执行减法运算操作，返回结果
	 * @param x
	 * @param y
	 * @return
	 */
	int subtraction(int x, int y);

	/**
	 * 用于执行除法加法运算操作，返回结果
	 * @param x
	 * @param y
	 * @return
	 */
	int division(int x, int y);

	/**
	 * 用于执行乘法运算操作，返回结果
	 * @param x
	 * @param y
	 * @return
	 */
	int multiplication(int x, int y);

	/**
	 * 判断除法是否可以执行
	 * @param x
	 * @param y
	 * @return
	 */
	boolean judgeDivision(int x, int y);

	/**
	 * 判断是不是运算符
	 * @param operation
	 * @return
	 */
	boolean judgeOperation(String operation);

	/**
	 * 用于计算
	 * @param x
	 * @param y
	 * @param operation
	 * @return
	 */
	int calculateNumber(int x, int y, String operation);
}
