package com.nyima.operation.impl;

import com.nyima.operation.IOperation;
import org.junit.Test;

/**
 * @author Chen Panwen
 * @data 2019/9/16 10:01
 */
public class OperationImpl implements IOperation {
	@Override
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}

	@Override
	public int division(int x, int y) {
		return x/y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x*y;
	}


	@Override
	public boolean judgeDivision(int x, int y) {
		//判断除数是否为零
		if(y==0) {
			return false;
		}

		//判断除下来是不是小数
		int num1 = x/y;
		float num2 = (float)x/y;
		if(num1 != num2) {
			return false;
		}

		return true;
	}

	@Override
	public boolean judgeOperation(String operation) {
		switch (operation){
			case "+":
				return true;
			case "-":
				return true;
			case "×":
				return true;
			case "÷":
				return true;
			default:
				return false;
		}
	}

	@Override
	public int calculateNumber(int x, int y, String operation) {
		switch (operation){
			case "+":
				return x+y;
			case "-":
				return x-y;
			case "×":
				return x*y;
			case "÷":
				return x/y;
			default:
				return 0;
		}
	}
}
