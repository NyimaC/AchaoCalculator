package com.nyima.operation.impl;

import com.nyima.operation.IOperationString;

/**
 * @author Chen Panwen
 * @data 2019/9/16 17:24
 */
public class OperationStringImpl implements IOperationString {

	@Override
	public String operationSplicing(int operationNumber, Integer[] numbers, Integer[] operations) {
		String str = "";
		int start;
		for(start=0; start<=operationNumber; start++) {
			str = str+numbers[start];
			if(start == operationNumber){
				return str + "=";
			}
			switch (operations[start]){
				case 1:
					str = str + "+";
					break;
				case 2:
					str = str+ "-";
					break;
				case 3:
					str = str + "×";
					break;
				case 4:
					str = str + "÷";
					break;
				default:
					break;
			}
		}
		return str + "=";
	}
}
