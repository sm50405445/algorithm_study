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
	
	//�湮�� ��� Ȯ�� �湮������ true
	static boolean[] v = new boolean[6];
	
	//�ִܰŸ�
	static int[] d = new int[6];
	
	//�ּҰŸ��� ������ ������ ��ȯ(����Ž��)
	static int getSmallIndex() {
		
		int min = INF;
		int index = 0;
		for(int i = 0 ; i<arr.length ; i++) {
			//�Ÿ��� ���� ª�� �湮 ���� ���� ����� �ε���
			if(d[i] < min && !v[i]) {
				min = d[i];
				index = i;
			}
		}
	//ó���� �ε����� 1�� ���
		return index;
	}
	
	public static void dijkstra(int start) {
		
		for(int i = 0; i<arr.length; i++) {
			//��������κ��� �������� ����� d�迭�� ��´�
			d[i] = arr[start][i];
		}
		//������ �湮ó��
		v[start] = true;
		
		for(int i = 0; i<arr.length-2; i++) {
			//���� �湮���� ���� ��� �߿��� �ּ� ����� ������ ����� �ε����� ������
			int current = getSmallIndex();
			//ó���� �ε����� 1->4�� ���� �Ÿ��� ���� ª���Ƿ� �ε����δ� 3�� ���
			//�湮 ó��, �׷� �̵� i�� �����ϸ鼭 getSmallIndex���� 1�� �����ϰ� �˻�
			v[current] = true;
		
			for(int j = 0; j<arr.length; j++) {
				//�ش� ��忡 �湮���� �ʾ�����
				//���� ó���� ������ �ε���0�� 3�� ������ �ε����� if���� ����
				if(!v[j]) {
					//������ ��忡������ �Ÿ��� ���� ª�� ���� �̵��� ��
					//�̵��� ���κ��� ���ʴ�� ó�� ��尡 ��ġ�� �� ���� ���̷�Ʈ�� �� �����
					//�̵��Ÿ����� ª���� �� �� ª�ٸ� ���� �̵��Ÿ��� ����� ª�� ���� �Է�
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
