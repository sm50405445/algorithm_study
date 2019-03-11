package com.algo.ex;

public class Dijkstra {

	static final int INF = 1000000;
	
	static int[][] arr = {
			{0, 2, 5, 1, INF, INF},
			{2, 0, 3, 2, INF, INF},
			{5, 3, 0, 3, 1, 5},
			{1, 2, 3, 0, 1, INF},
			{INF, INF, 1, 1, 0, 2},
			{INF, INF, 5, INF, 2, 0}
	};
	
	//방문한 노드 확인 방문했으면 true
	static boolean[] v = new boolean[6];
	
	//최단거리
	static int[] d = new int[6];
	
	//최소거리를 가지는 정점을 반환(선형탐색)
	static int getSmallIndex() {
		
		int min = INF;
		int index = 0;
		for(int i = 0 ; i<arr.length ; i++) {
			//거리가 제일 짧고 방문 하지 않은 노드의 인덱스
			if(d[i] < min && !v[i]) {
				min = d[i];
				index = i;
			}
		}
	//처음에 인덱스에 1이 담김
		return index;
	}
	
	public static void dijkstra(int start) {
		
		for(int i = 0; i<arr.length; i++) {
			//출발점으로부터 끝까지의 비용을 d배열에 담는다
			d[i] = arr[start][i];
		}
		//시작점 방문처리
		v[start] = true;
		
		for(int i = 0; i<arr.length-2; i++) {
			//현재 방문하지 않은 노드 중에서 최소 비용을 가지는 노드의 인덱스를 가져옴
			int current = getSmallIndex();
			//처음에 인덱스는 1->4로 가는 거리가 제일 짧으므로 인덱스로는 3이 담김
			//방문 처리, 그럼 이따 i가 증가하면서 getSmallIndex에서 1을 제외하고 검색
			v[current] = true;
		
			for(int j = 0; j<arr.length; j++) {
				//해당 노드에 방문하지 않았으면
				//따라서 처음에 들어오면 인덱스0과 3을 제외한 인덱스가 if문을 수행
				if(!v[j]) {
					//시작한 노드에서부터 거리가 가장 짧은 노드로 이동한 후
					//이동한 노드로부터 차례대로 처음 노드가 거치는 것 없이 다이렉트로 간 노드의
					//이동거리보다 짧은지 비교 후 짧다면 원래 이동거리를 지우고 짧은 것을 입력
					if(d[current] + arr[current][j]<d[j]) {
						d[j] = d[current] + arr[current][j];
					}
				}
				System.out.print(d[j]);
				
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		dijkstra(1);
		for(int i = 0 ; i<arr.length; i++) {
			System.out.print(d[i]+" ");
		}
	}
	
}
