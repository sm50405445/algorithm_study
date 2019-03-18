package com.algo.ex;

import java.util.Scanner;

public class Greedy {

	static int h = 0;
	
	static void greed(int total,int value) {
		int result = 0;
		if(total<value) {
			if(value/5 == 2000 || value/5 == 200 || value/5==20) {				
				value = value/2;
			}else if(value/2 == 25000 || value/2 == 2500 || value/2==250 || value/2==25) {
				value = value/5;
			}
			greed(total, value);
		}else{
			result = total/value;
			System.out.println(value+"권or원이"+result+"권or개 필요합니다.");
			h+=result;
			total = total-result*value;
			if(total==0) {
				System.out.println("최적의 해 : "+h);
				return;
			}
			if(value/5 == 2000 || value/5 == 200 || value/5==20) {				
				value = value/2;
			}else if(value/2 == 25000 || value/2 == 2500 || value/5==250 || value/5==25) {
				value = value/5;
			}
			greed(total, value);
		}
		
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int total = scn.nextInt();
		greed(total,50000);
		scn.close();

	}
}
