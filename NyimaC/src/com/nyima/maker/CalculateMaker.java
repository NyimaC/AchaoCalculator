package com.nyima.maker;


import com.nyima.operation.impl.OperationImpl;
import org.junit.Test;

import java.util.*;

/**
 * @author Chen Panwen
 * @data 2019/9/17 8:01
 */
public class CalculateMaker {
	/**
	 * 用于获得后缀表达式
	 * @return
	 */
	public Queue<String> calculateResult(Integer[] num, Integer[] operations) {
		//用于存放之前的算式
		Queue<String> queue1 = new LinkedList<>();
		//用于存放后缀表达式
		Queue<String> queue2 = new LinkedList<>();
		int i;
		//把运算式放入队列
		for(i=0; i<num.length; i++) {
			queue1.offer(String.valueOf(num[i]));
			if(i<operations.length){
				switch (operations[i]){
					case 1:
						queue1.add("+");
						break;
					case 2:
						queue1.add("-");
						break;
					case 3:
						queue1.add("×");
						break;
					case 4:
						queue1.add("÷");
						break;
					default:
						break;
				}
			}
		}

		//用于存放运算符
		Stack<String> stack = new Stack<>();
		//用于标注队列中运算符的位置
		i = 2;
		while(!queue1.isEmpty()) {
			//此位置是运算符
			if(i%2==1) {
				i++;
				int num1, num2;
				//把运算符放进去
				if(stack.empty()) {
					stack.push(queue1.poll());
				}else {
					//取队首元素的值
					num1 = Translate.translateToInt(queue1.poll());
					if(num1<100) {
						while (!stack.isEmpty()) {
							queue2.offer(stack.pop());
						}
						stack.push(Translate.translateToString(num1));
					}else {
						num2 = Translate.translateToInt(stack.peek());
						if(num2<100) {
							stack.push(Translate.translateToString(num1));
						}else {
							queue2.offer(stack.pop());
							if(stack.isEmpty()) {
								stack.push(Translate.translateToString(num1));
							}else {
								while(!stack.isEmpty()) {
									if(stack.isEmpty()) {
										stack.push(Translate.translateToString(num1));
										break;
									}
									num2 = Translate.translateToInt(stack.peek());
									if(num2<100) {
										stack.push(Translate.translateToString(num1));
										break;
									}else {
										queue2.offer(stack.pop());
									}
								}
							}
						}
					}
				}
			}else {
				i++;
				queue2.offer(queue1.poll());
				if(queue1.isEmpty()){
					while(!stack.isEmpty()) {
						queue2.offer(stack.pop());
					}
				}
			}
		}
		//打印后缀表达式并返回
		return queue2;
	}

	/**
	 * 根据后缀表达式计算结果
	 * @param queue2
	 * @return
	 */
	public int calculate(Queue queue2) {
		/**
		 * 用于进行后缀计算
		 */
		OperationImpl operation = new OperationImpl();
		//保存计算结果
		int x = 0;
		int y = 0;
		int result = 0;
		Stack<String> stack = new Stack<>();
		stack.push((String)queue2.poll());
		while(!queue2.isEmpty()) {

			String str = (String) queue2.poll();
			if(!operation.judgeOperation(str)) {
				stack.push(str);
			}else {
					 y = Integer.valueOf(stack.pop());
					 x = Integer.valueOf(stack.pop());
					 result = operation.calculateNumber(x, y, str);
					 stack.push(String.valueOf(result));
					 //如果最终只有一个元素，则为计算的结果
					 if(stack.size() == 1 && queue2.isEmpty()) {
					 	return Integer.valueOf(stack.pop());
					}
			}
		}
		return y;
	}
}
