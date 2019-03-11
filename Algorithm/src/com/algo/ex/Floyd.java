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
		//결과 그래프 초기화(각 최소비용)
		int d[][] = new int[4][4];
		for(int i = 0 ; i<number ; i++) {
			for(int j = 0 ; j<number ; j++) {
				d[i][j] = arr[i][j];
			}
		}
		
		// k 거쳐가는 노드
		for(int k = 0; k<number ; k++) {
			//i = 출발노드
			for(int i = 0 ; i<number ; i++) {
				//j 도착노드
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
