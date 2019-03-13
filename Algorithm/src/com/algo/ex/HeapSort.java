package com.algo.ex;

public class HeapSort {

	static int[] heap = { 7, 6, 5, 8, 3, 1, 9, 1, 6 };

	public static void heapSort(int[] arr, int number) {
		
		for (int i = 1; i < number; i++) {
			int c = i;
			int temp;
			do {
				int root = (c - 1) / 2;
				if (heap[root] < heap[c]) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				c=root;
			} while (c != 0);
		}
	}
	
	public static void main(String[] args) {

		//�迭�� �ִ��� ������ �ٲ�
		heapSort(heap, heap.length);
		
		System.out.print("�ִ��� ������ �ٲٰ� ���� �� : ");
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + ",");
		}
		System.out.println();
		
		//ũ�⸦ �ٿ����� �ݺ��� �� ����
		for(int i = heap.length-1; i >= 0 ;i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			heapSort(heap, i);
		}
		
		System.out.print("�ִ��� ������ �ٲٰ� ���� �� : ");
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + ",");
		}
		
	}
}
