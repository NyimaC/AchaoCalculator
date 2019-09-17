package com.nyima.maker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * @author Chen Panwen
 * @data 2019/9/17 19:22
 */
public class FileWriting {
	public void WriteStringToFile(LinkedList<String> list) {
		try {
			File file = new File("E:/生成的题目/题目.txt");
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			for (String str : list
			) {
				str += "\n";
				ps.append(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
