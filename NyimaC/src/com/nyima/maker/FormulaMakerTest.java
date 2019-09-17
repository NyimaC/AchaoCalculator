package com.nyima.maker;

import com.nyima.domain.Numbers;
import com.nyima.operation.impl.OperationImpl;
import com.nyima.operation.impl.OperationStringImpl;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 用于生成运算式
 * @author Chen Panwen
 * @data 2019/9/16 9:57
 */
public class FormulaMakerTest {
	/**
	 * 生成题目的类
	 */

	public LinkedList<String> questionMaker(int total)
	{
		//用于存放生成的运算式
		String[] formulas = new String[total];
		LinkedList<String> questionList = new LinkedList<>();
		Numbers numbers = new Numbers();
		OperationImpl operation = new OperationImpl();
		OperationStringImpl operationString = new OperationStringImpl();

		//循环开始的参数（一个用于外循环，一个用于循环）
		int start1;
		int start2;
		//用于保存每次运算的结果
		int result;
		//用于标识运算是否会出现小数
		int judge = 0;
		for(start1=0; start1<total; start1++) {
			//标识结果集的下标
			//生成随2~3个的运算符
			numbers.operationNumber = (int)(2+Math.random()*(3-2+1));
			//存放每次运算的结果集
			//生成3~4个参与运算的数字
			numbers.numbers = new Integer[numbers.operationNumber+1];
			for(start2=0; start2<=numbers.operationNumber; start2++) {
				numbers.numbers[start2] = (int)(0+Math.random()*(100-0+1));
			}
			//生成运算符
			numbers.operations = new Integer[numbers.operationNumber];
			for(start2=0; start2<numbers.operationNumber; start2++) {
				numbers.operations[start2] = (int)(1+Math.random()*(4-1+1));
			}
			//运算此表达式的运算结果（重点）
			//1、判断此算式是否满足条件（主要看除法是否满足）
			for(start2=0; start2<numbers.operationNumber; start2++){
				if(numbers.operations[start2] == 4) {
					if(!operation.judgeDivision(numbers.numbers[start2], numbers.numbers[start2+1])) {
						//不满足 重新生成算式
						judge++;
					}else {
						continue;
					}
				}
			}
			//若满足除法后无小数，则此算式成立
			//算式中没有小数，可以生成表达式并打印
			if(judge == 0) {
				//算式中没有小数，可以生成表达式并打印
				formulas[start1] = operationString.operationSplicing(numbers.operationNumber, numbers.numbers, numbers.operations);
				System.out.println(formulas[start1]);
			}else {
				judge = 0;
				start1--;
				continue;
			}

			//调用计算函数计算结果
			CalculateMaker maker = new CalculateMaker();
			java.util.Queue<String> queue = new LinkedList<>();
			queue = maker.calculateResult(numbers.numbers, numbers.operations);
			result = maker.calculate(queue);
			formulas[start1] += String.valueOf(result);
			questionList.add(formulas[start1]);
		}
		return questionList;
	}
}

