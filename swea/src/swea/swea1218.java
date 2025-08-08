package swea;

import java.io.*;
import java.util.*;

//1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
public class swea1218 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("input (7).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		label:
		for (int t = 0; t < 10; t++) {
			int lengthOfTest = Integer.parseInt(br.readLine());
			char[] chArr = br.readLine().toCharArray();

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < chArr.length; i++) {
				if (chArr[i] == '(' || chArr[i] == '[' || chArr[i] == '{' || chArr[i] == '<') {
					stack.push(chArr[i]);
				} else {
					if (chArr[i] == ')') {
						if (stack.isEmpty()) {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
					}

					if (chArr[i] == ']') {
						if (stack.isEmpty()) {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
					}

					if (chArr[i] == '}') {
						if (stack.isEmpty()) {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
					}

					if (chArr[i] == '>') {
						if (stack.isEmpty()) {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
						}
						if (stack.peek() == '<') {
							stack.pop();
						} else {
							System.out.println("#" + (t + 1) + " " + 0);
							continue label;
							
						}
					}

				}

			}
			if (stack.size() > 0) {
				System.out.println("#" + (t + 1) + " " + 0);
			} else {
				System.out.println("#" + (t + 1) + " " + 1);
				
			}

		}
	}
}
