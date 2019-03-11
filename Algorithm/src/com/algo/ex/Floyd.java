package com.algo.ex;


public class Floyd {

	static int number = 4;
	
	static int INF = 100000000;
	
	static int arr[][]= {
			{0,5,INF,8},
			{7,0,9,INF},
			{2,INF,0,4},
			{INF,INF,3,0}
	};
	
	static void floydWarshall() {
		//��� �׷��� �ʱ�ȭ(�� �ּҺ��)
		int d[][] = new int[4][4];
		for(int i = 0 ; i<number ; i++) {
			for(int j = 0 ; j<number ; j++) {
				d[i][j] = arr[i][j];
			}
		}
		
		// k ���İ��� ���
		for(int k = 0; k<number ; k++) {
			//i = ��߳��
			for(int i = 0 ; i<number ; i++) {
				//j �������
				for(int j = 0 ; j<number ; j++) {
					if(d[k][j]+d[i][k]<d[i][j]) {
						d[i][j] = d[k][j]+d[i][k]; 
					}
				}
			}
		}
		
		for(int i = 0; i<number ; i++) {
			for(int j = 0 ; j<number ; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		floydWarshall();
		
	}
}
