package com.algo.ex;

public class InsertSort {

	public static void main(String[] args) {
		
		int[] array = {10,1,4,7,5,6,3,2,9,8};
		int temp = 0;
		for(int i = 0; i<array.length-1;i++) {
			int j = i;
			//���� �迭�� �ε��� ���� ���� ������ ���� ������ while�� ���ư�
			while(array[j]>array[j+1]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
				if(j<0)
					break;
			}
		}
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		
	}
}
