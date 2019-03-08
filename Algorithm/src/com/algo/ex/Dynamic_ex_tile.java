package com.algo.ex;

public class Dynamic_ex_tile {

	static int[] arr = new int[1000];
	
	public static int sum(int x) {
		
		if(x==1) {
			return 0;
		}
		if(x==2) {
			return 3;
		}
		if(arr[x]!=0) {
			return arr[x];
		}else {
			int result = 3*sum(x-2);
			for(int i = 3 ; i<x ; i++) {
				if(i%2==0) {
					result+=2*sum(x-i);
				}
			}
			return arr[x] = result;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(sum(6));
	}
	
}
