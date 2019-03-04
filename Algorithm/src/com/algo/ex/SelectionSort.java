package com.algo.ex;

public class SelectionSort {

	public static void main(String[] args) {
		
		int index=0, temp, min;
		int[] array = {10,2,6,5,1,8,7,9,3,4};
		
		for(int i = 0;i<10;i++) {
			//min 값을 여기서 초기화 해줘야 다음 번지부터 다시 비교 가능!
			min = 9999;
			for(int j = i ; j<10;j++) {
				if(array[j]<min) {
					min = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
			
		}
		
		for(int i = 0 ; i<array.length;i++) {
			System.out.print(array[i]+",");
		}
	}
}
