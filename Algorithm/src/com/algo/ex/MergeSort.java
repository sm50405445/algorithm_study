package com.algo.ex;

public class MergeSort {
	// ������ ���� ���� ������ ���� �迭 ���� �ݵ�� ���������� ����� ���´�.
	public static int[] sorted = new int[8];

	public static void mergeSort(int[] array, int a, int b) {
		// ũ�Ⱑ 1���� ū ���
		int middle;
		if (a < b) {
			middle = (a + b) / 2;
			mergeSort(array, a, middle);
			mergeSort(array, middle + 1, b);
			merge(array, a, middle, b);
		}
	}

	public static void merge(int[] array, int a, int middle, int b) {
		// �ɰ��� �迭�� ó�� �ε���
		int i = a;
		// �迭 �߾Ӱ� �ɰ��� �迭�� ���������� ����� �޸� ������ �پ� �ִ� ��
		int m = middle + 1;
		// ��ģ �迭�� ó�� �ε���
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
		
		// ���� �迭�� �� �������
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
