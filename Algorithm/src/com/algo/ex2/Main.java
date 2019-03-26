package com.algo.ex2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int result = 0;
		
		result += n/1000;
		n %= 1000;
		result += n/500;
		n %= 500;
		result += n/100;
		n %= 100;
		result += n/50;
		n %= 50;
		result += n/10;
		n %= 10;
		System.out.println(result);
	}
	
	
}
