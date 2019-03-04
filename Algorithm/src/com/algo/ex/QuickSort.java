package com.algo.ex;

public class QuickSort {

	/*퀵정렬
	피벗값? 기준값을 피벗값이라고 함 보통은 첫번 째 원소
	왼쪽에서부터 피벗값보다 큰값을 찾음
	오른쪽에서는 피벗값보다 작은값을 찾음
	그 위치를 바꿈
	계속 바꾸다가 작은값에 인덱스가 큰값 인덱스보다 커질때 교차한다고함
	그때 작은값을 피벗값과 바꿈
	바뀐 상태의 피벗값을 기준으로 왼쪽과 오른쪽으로 나눔 그리고 가장 첫번째
	숫자를 피벗값으로 잡는다(왼쪽, 오른쪽 둘다)
	왼쪽부터 큰값, 오른쪽부터 작은값 그런데 작은값이 없다? 자기 자신이 작은값이 됨 한마디로 교차가 일어남
	데이터가 한개가 남으면 그대로 둠*/
	
	public static void quicksort(int[] array, int start, int end) {
		
		//start와 end는 인덱스 번호임
		if(start>=end) {
			return;
		}
		int key = start;
		int i = start+1;
		int j = end;
		int temp = 0;
		
		while(i<=j) {
			//key값보다 큰값을 만날때까지 오른쪽으로 이동
			if(array[i]<=array[key])
				i++;
			//key값보다 작은값을 만날때까지 왼쪽으로 이동
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
