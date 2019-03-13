package com.algo.ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Topological_Sorting {

	public static final int MAX = 12;
	// 노드의 개수
	public static int n;
	// 각 노드의 진입차수
	public static int[] inDegree = new int[MAX];
	// 각 정점에 노드 정보
	public static Vector<int[]> nodeInf = new Vector<int[]>();

	public static void topologySort() {
		// 위상정렬 결과값을 담을 배열
		int[] result = new int[MAX];
		Queue<Integer> q = new LinkedList<Integer>();

		//위상 정렬이 0인 값을 큐에 담는다.
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		// 위상 정렬이 완전히 실행 되려면 n개의 노드를 방문해야함
		for (int i = 1; i <= n; i++) {
			// 만약 n번 이전에 큐가 비어버리면 사이클이 발생한 것
			if (q.isEmpty() == true) {
				System.out.println("사이클이 발생했습니다.");
				return;
			}
			//큐에 담긴 노드를 꺼낸다.
			int x = q.poll();
			result[i] = x;

		//노드의 정보가 null이 아닐 때 까지 반복한다 null처리 안해주면 에러남!!!!
		if(nodeInf.get(x)!=null) {
			
			//해당 큐에 담긴 노드와 연결된 노드의 개수만큼 진행
			for (int j = 0; j < nodeInf.get(x).length; j++) {
				int y = nodeInf.get(x)[j];
				//개수만큼 위상정렬을 하나씩 빼주면서
				--inDegree[y];
				//위상 정렬값이 0이된 노드를 큐에 넣는다 시작점과의 연결이 다 끊긴 노드
				if (inDegree[y] == 0) {
					q.add(y);
				}
			}
		}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(result[i] + ",");
		}
	}
	
	public static void addNode(int number, int[] inDegree) {
		
		nodeInf.add(number,inDegree);
	}

	public static void main(String[] args) {

		n = 7;
		nodeInf.setSize(10);
		nodeInf.add(1, new int[] { 2, 5 });
		inDegree[2]++;
		inDegree[5]++;
		nodeInf.add(2, new int[] { 3 });
		inDegree[3]++;
		nodeInf.add(3, new int[] { 4 });
		inDegree[4]++;
		nodeInf.add(4, new int[] { 6 });
		inDegree[6]++;
		nodeInf.add(5, new int[] { 6 });
		inDegree[6]++;
		nodeInf.add(6, new int[] { 7 });
		inDegree[7]++;
		topologySort();
	}
	
}
