package com.algo.baekjun;

import java.util.Scanner;

public class Question4_2 {

public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int[][] arr = new int[t+1][t+1];
		
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		for(int i = 2 ; i<=t ; i++) {
			for(int j = 0 ; j<=1 ; j++) {
				arr[i][j] = arr[i-1][j]+arr[i-2][j];
			}
		}
		for(int i = 0 ; i<t ; i++) {
			int number = scn.nextInt();
			System.out.println(arr[number][0]+" "+arr[number][1]);
		}
		
		scn.close();
	}
}
