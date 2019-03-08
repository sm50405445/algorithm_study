package com.algo.ex;

public class SieveOfEratosthenes {

	static int[] arr = new int[100001];
	
	public static void sieve() {
		
		for(int i = 2 ; i<=arr.length-1 ; i++) {
			arr[i] = i;
		}
		
		for(int i = 2 ; i<=arr.length-1 ; i++) {
			if(arr[i]==0) {
				continue;				
			}
			//i+i�� ���ִ� ���� i���� �����ع����� �Ҽ����� �������� �Ҽ��� 2������� ����� �����ؾ���
			for(int j = i+i ; j<=arr.length-1 ; j+=i) {
				arr[j] = 0;
			}
		}
		
		for(int i = 2 ; i<=arr.length-1 ; i++) {
			if(arr[i]!=0) {				
				System.out.println(arr[i]+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(arr[13]);
		sieve();
		
	}
	
}
