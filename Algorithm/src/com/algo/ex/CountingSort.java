package com.algo.ex;

public class CountingSort {

	public static void main(String[] args) {
		
		
		int[] count = new int[5];
		int[] Array = {1,5,4,2,3,1,2,3,5,2,1,2,3,5,4,2,1,2,3,4,2,2,1,1,1,3,4,5,3,4,3,2,1,2,3,4,5,5,3,4,5};
		
		for(int i = 0 ; i<5 ; i++) {
			count[i] = 0;			
		}
		
		for(int i = 0 ; i<Array.length ; i++) {			
			count[Array[i]-1]++;
		}
		
		for(int i = 0 ; i<count.length ; i++) {
			if(count[i]!=0) {
				for(int j = 0 ; j<count[i] ; j++) {
					System.out.print(i+1);
				}
			}
		}
	}
}
