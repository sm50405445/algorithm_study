package com.algo.ex;

public class Dynamic_programming_ex1 {

	static double[] arr = new double[10000];
	
	static double fibonacci(int x) {
		
		if(x==1) {
			return 1;
		}
		if(x==2) {
			return 1;
		}
		if(arr[x] != 0) {
			return arr[x];
		}else {
			return arr[x] = fibonacci(x-1) + fibonacci(x-2);
		}
	}
	
	static double fibonacci2(int x) {
		
		if(x == 1)
			return 1;
		if(x == 2)
			return 1;
		else
			return fibonacci2(x-1) + fibonacci2(x-2);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fibonacci(50));
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");
		
		long start2 = System.currentTimeMillis();
		System.out.println(fibonacci2(50));
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2+"ms");
	}
}
