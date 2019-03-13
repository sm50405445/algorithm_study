package com.algo.ex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class NetworkFlow2 {

	static final int INF = 100000000;
	static final int MAX = 100;

	// ��� ����
	static int n = 6;
	// �ִ� ������ ���� �����
	static int result;
	// �ִ� ���뷮 �⺻������ ��� �������� 1 ���� ���� ����� ��ȣ�� �����ֱ� ����
	static int[][] capacity = new int[n + 1][n + 1];
	// ����
	static int[][] flow = new int[n + 1][n + 1];
	// Ư�� ��带 �湮 �ߴ��� Ȯ���ϴ� �迭
	static int[] d = new int[MAX];
	// ��� �� ���� ����
	static Vector<int[]> NodeInf = new Vector<int[]>();

	static void maxFlow(int start, int end) {

		while (true) {
			// �ȵ鷶�ٴ� ǥ�ø� ���� d�迭�� ��� -1�� ä������
			Arrays.fill(d, -1);
			// BFS������ �˰����̹Ƿ� ť�� �̿�
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			// ť�� ������������� ����
			while (!q.isEmpty()) {

				int x = q.poll();

				// �ΰ�ó�� ������� ���ϸ� ������!
				if (NodeInf.get(x) != null) {
					// ����� ������� ���� ��ŭ ����
					for (int i = 0; i < NodeInf.get(x).length; i++) {
						// y������ ����� ����� ��ȣ�� ����
						int y = NodeInf.get(x)[i];
						// �⺻������ �ܹ��� ���� ������ ���� ���뷮�� capacity�� ������
						
						// ���� �������� �����ִ� ���뷮�� �� Ŀ���ϰ�, �ѹ��� �鸣�� ���� ����϶�
						if (capacity[x][y] - flow[x][y] > 0 && d[y] == -1) {
							// ����� ���� ť�� �����
							q.add(y);
							// ����� ���� �鷶�ٴ� ǥ�ø� ���� x���� �־� �� ������ �̵���θ� Ȯ���ϱ� ����
							// ��d[��ȣ]�� d[�ش���] = '��߳��'�� ��
							d[y] = x;
							// y���� ������ ����� ���ڿ� �������� while���� ������ �� ���� �����ϸ�
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
			//�������κ��� �������� �� �� ����
			for (int i = end; i != start; i = d[i]) {
				//ù ��° while�� �� ������ flow[d[i]][i]������ ó�� ��θ� ��Ҵ� �ּ� ������ ��������
				mFlow = Math.min(mFlow, capacity[d[i]][i] - flow[d[i]][i]);
			}	

			for (int i = end; i != start; i = d[i]) {
				//���������� �ش� ���� �귯�� �� �ִ� �ִ� ������ ���� ��
				flow[d[i]][i] += mFlow;
				//���� ���� �ľ�(��θ� �� ã�ƺ��� ���� ���Ƿ� ���ص� ���� ����) �� �ݴ�������� ���� �Ŷ�� ���� ��
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
