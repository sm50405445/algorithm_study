package com.algo.ex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class NetworkFlow2 {

	static final int INF = 100000000;
	static final int MAX = 100;

	// 노드 개수
	static int n = 6;
	// 최대 유량을 담을 결과값
	static int result;
	// 최대 수용량 기본적으로 노드 개수보다 1 많게 잡음 노드의 번호와 맞춰주기 위함
	static int[][] capacity = new int[n + 1][n + 1];
	// 유량
	static int[][] flow = new int[n + 1][n + 1];
	// 특정 노드를 방문 했는지 확인하는 배열
	static int[] d = new int[MAX];
	// 노드 간 연결 관계
	static Vector<int[]> NodeInf = new Vector<int[]>();

	static void maxFlow(int start, int end) {

		while (true) {
			// 안들렀다는 표시를 위해 d배열에 모두 -1을 채워놓음
			Arrays.fill(d, -1);
			// BFS형식의 알고리즘이므로 큐를 이용
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			// 큐가 비어있을때까지 진행
			while (!q.isEmpty()) {

				int x = q.poll();

				// 널값처리 해줘야함 안하면 오류남!
				if (NodeInf.get(x) != null) {
					// 노드의 연결상태 개수 만큼 진행
					for (int i = 0; i < NodeInf.get(x).length; i++) {
						// y변수에 연결된 노드의 번호를 담음
						int y = NodeInf.get(x)[i];
						// 기본적으로 단방향 노드로 진행할 때의 수용량을 capacity에 저장함
						
						// 현재 유량보다 남아있는 수용량이 더 커야하고, 한번도 들르지 않은 노드일때
						if (capacity[x][y] - flow[x][y] > 0 && d[y] == -1) {
							// 연결된 노드는 큐에 담아줌
							q.add(y);
							// 연결된 노드는 들렀다는 표시를 해줌 x값을 넣어 준 이유는 이동경로를 확인하기 위해
							// 즉d[번호]는 d[해당노드] = '출발노드'가 됨
							d[y] = x;
							// y값이 마지막 노드의 숫자와 같아지면 while문을 종료함 즉 끝에 도달하면
							if (y == end)
								break;
						}
					}
				}

			}
			System.out.println();
			
			
			if (d[end] == -1)
				break;
			
			int mFlow = INF;
			//끝점으로부터 시작점이 될 때 까지
			for (int i = end; i != start; i = d[i]) {
				//첫 번째 while문 이 돌고나서 flow[d[i]][i]값에는 처음 경로를 잡았던 최소 유량이 남아있음
				mFlow = Math.min(mFlow, capacity[d[i]][i] - flow[d[i]][i]);
			}	

			for (int i = end; i != start; i = d[i]) {
				//최종적으로 해당 노드로 흘러갈 수 있는 최대 유량이 저장 됨
				flow[d[i]][i] += mFlow;
				//음의 유량 파악(경로를 더 찾아보기 위해 임의로 정해둔 음의 유량) 즉 반대방향으로 가는 거라고 보면 됨
				flow[i][d[i]] -= mFlow;
			}
			result += mFlow;
		}
	}

	public static void main(String[] args) {

		NodeInf.setSize(7);
		NodeInf.add(1, new int[] { 2, 4 });
		capacity[1][2] = 12;
		capacity[1][4] = 11;
		NodeInf.add(2, new int[] { 1, 3, 4, 5, 6 });
		capacity[2][4] = 3;
		capacity[2][3] = 6;
		capacity[2][5] = 5;
		capacity[2][6] = 9;
		NodeInf.add(3, new int[] { 2, 5, 6 });
		capacity[3][6] = 8;
		NodeInf.add(4, new int[] { 1, 2, 5 });
		capacity[4][5] = 9;
		NodeInf.add(5, new int[] { 2, 3, 4, 6 });
		capacity[5][3] = 3;
		capacity[5][6] = 4;

		maxFlow(1, 6);
		System.out.println(result);

	}
}
