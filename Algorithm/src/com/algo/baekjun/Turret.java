package com.algo.baekjun;

import java.util.Scanner;

public class Turret {

	static int distance(int x1,int y1,int r1,int x2,int y2,int r2) {
		
		double d = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		
		if(r1+r2<d||Math.abs(r1-r2)>d)
			return 0;
		if(r1+r2>d)
			return 2;
		if(r1+r2==d || Math.abs(r1-r2)==d)
			return 1;
		if(x1==x2&&y1==y2&&r1==r2)
			return -1;
		if(x1==x2&&y1==y2&&r1!=r2)
			return 0;
		
		return 1;
	}
	
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int length = scn.nextInt();
		int[] arr = new int[length];
		for(int i = 0 ; i<length ; i++) {
			int x1 = scn.nextInt();
			int y1 = scn.nextInt();
			int r1 = scn.nextInt();
			int x2 = scn.nextInt();
			int y2 = scn.nextInt();
			int r2 = scn.nextInt();
			arr[i] = distance(x1, y1, r1, x2, y2, r2);
		}
		scn.close();
		
		for(int i = 0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}

}
