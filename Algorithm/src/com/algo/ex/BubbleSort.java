package com.algo.ex;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] array = {10,1,4,7,5,6,3,2,9,8};
		int temp = 0;
		for(int i = 0 ; i < array.length;i++) {
			for(int j = 0; j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i =0;i<array.length;i++)
			System.out.print(array[i]+",");
	}
}
