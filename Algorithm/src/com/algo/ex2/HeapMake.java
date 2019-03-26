package com.algo.ex2;

public class HeapMake {

	static int[] heap = {10,7,5,6,8,9,2,4,3,1};
	
	static void heapSort(int[] arr, int number) {
		
		for(int i = 1 ; i<number ; i++) {
			int c = i;
			int temp;
			do {
				int root = (c-1)/2;
				if(heap[root]<heap[c]) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c = root;
			}while(c!=0);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		heapSort(heap, heap.length);
		for(int i = 0 ; i<heap.length ; i++) {
			System.out.print(heap[i]+",");
		}
		System.out.println();
		for(int i = heap.length-1 ; i>=0 ; i--) {
			int temp;
			temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			heapSort(heap, i);
			
		}
		for(int i = 0 ; i<heap.length ; i++) {
			System.out.print(heap[i]+",");
		}
	}
	
}
