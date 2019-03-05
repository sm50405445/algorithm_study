package com.algo.ex;

public class MergeSort {
	// 정렬을 위해 만든 임의의 전역 배열 변수 반드시 전역변수로 만들어 놓는다.
	public static int[] sorted = new int[8];

	public static void mergeSort(int[] array, int a, int b) {
		// 크기가 1보다 큰 경우
		int middle;
		if (a < b) {
			middle = (a + b) / 2;
			mergeSort(array, a, middle);
			mergeSort(array, middle + 1, b);
			merge(array, a, middle, b);
		}
	}

	public static void merge(int[] array, int a, int middle, int b) {
		// 쪼개진 배열의 처음 인덱스
		int i = a;
		// 배열 중앙값 쪼개진 배열로 설명했지만 사실은 메모리 구조상 붙어 있는 것
		int m = middle + 1;
		// 합친 배열의 처음 인덱스
		int k = a;

		while (i <= middle && m <= b) {
			if (array[i] <= array[m]) {
				sorted[k] = array[i++];

			} else {
				sorted[k] = array[m];
				m++;
			}
			k++;
		}
		
		// 한쪽 배열이 다 담겼으면
		if (i > middle) {
			for (int t = m; t <= b; t++) {
				sorted[k] = array[t];
				k++;
			}
		} else {
			for (int t = i; t <= middle; t++,k++) {
				sorted[k] = array[t];
			}
		}
		for (int t = a; t <= b; t++) {
			array[t] = sorted[t];
		}
	}

	public static void main(String[] args) {
		int[] array = { 7, 6, 5, 8, 3, 5, 9, 1 };
		MergeSort.mergeSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
}
