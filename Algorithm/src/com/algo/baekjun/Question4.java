package com.algo.baekjun;

import java.util.Scanner;

public class Question4 {

	static int zero = 0;
	static int one = 0;

	static int fibonacci(int num) {
		if(num==0) {			
			zero++;
			return 0;
		}else if(num==1) {			
			one++;
			return 1;
		}else {
			return fibonacci(num-1) + fibonacci(num-2);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int[] result = new int[T];
		for(int i = 0 ; i<result.length ; i++) {
			int num = scn.nextInt();
			fibonacci(num);
			System.out.println(zero + " " + one);
			one = 0;
			zero = 0;
		}
		scn.close();
	}
}
