package com.nyima.domain;

/**
 * 用于存放会用到的各种数字类型
 * @author Chen Panwen
 * @data 2019/9/16 16:56
 */
public class Numbers {
	/**
	*随机生成运算符的个数
	*/
	public int operationNumber;

	/**
	 * 参与运算的数字集合
	 */
	public Integer[] numbers;

	/**
	 * 用于表示运算符 1:+ 2:- 3:* 4:/ 0:无运算符
	 */
	public  Integer[] operations;
}

