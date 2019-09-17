package com.nyima.main;

import com.nyima.maker.FileWriting;
import com.nyima.maker.FormulaMakerTest;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Chen Panwen
 * @data 2019/9/17 19:18
 */
public class Main {
	/**
	 * 生成题目的主类
	 * @param args
	 */
	public static void main(String[] args) {
		//输入想要的题目数
		System.out.println("请输入想要创建题目的数目：");
		//生成题目的数目
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		//生成题目生成器
		FormulaMakerTest maker = new FormulaMakerTest();
		//题目集
		LinkedList<String> questionList = 	maker.questionMaker(total);
		System.out.println(questionList);
		//将题目存入文件中
		FileWriting writing = new FileWriting();
		writing.WriteStringToFile(questionList);
	}
}
