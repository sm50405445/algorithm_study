package com.algo.ex;

public class QuickSort {

	/*������
	�ǹ���? ���ذ��� �ǹ����̶�� �� ������ ù�� ° ����
	���ʿ������� �ǹ������� ū���� ã��
	�����ʿ����� �ǹ������� �������� ã��
	�� ��ġ�� �ٲ�
	��� �ٲٴٰ� �������� �ε����� ū�� �ε������� Ŀ���� �����Ѵٰ���
	�׶� �������� �ǹ����� �ٲ�
	�ٲ� ������ �ǹ����� �������� ���ʰ� ���������� ���� �׸��� ���� ù��°
	���ڸ� �ǹ������� ��´�(����, ������ �Ѵ�)
	���ʺ��� ū��, �����ʺ��� ������ �׷��� �������� ����? �ڱ� �ڽ��� �������� �� �Ѹ���� ������ �Ͼ
	�����Ͱ� �Ѱ��� ������ �״�� ��*/
	
	public static void quicksort(int[] array, int start, int end) {
		
		//start�� end�� �ε��� ��ȣ��
		if(start>=end) {
			return;
		}
		int key = start;
		int i = start+1;
		int j = end;
		int temp = 0;
		
		while(i<=j) {
			//key������ ū���� ���������� ���������� �̵�
			if(array[i]<=array[key])
				i++;
			//key������ �������� ���������� �������� �̵�
			if(array[j]>=array[key] && j>start) {
				j--;
			}
			
			if(i>j) {
				temp = array[j];
				array[j] = array[key];
				array[key] = temp;
			}else {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		quicksort(array, start, j-1);
		quicksort(array, j+1, end);
	}
	
	
	public static void main(String[] args) {
		
		int[] array = {10,1,4,7,5,6,3,2,9,8};
		quicksort(array, 0, 9);
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]+",");
		}
		
	}
}
