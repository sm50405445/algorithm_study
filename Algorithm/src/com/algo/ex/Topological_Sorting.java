package com.algo.ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Topological_Sorting {

	public static final int MAX = 12;
	// ����� ����
	public static int n;
	// �� ����� ��������
	public static int[] inDegree = new int[MAX];
	// �� ������ ��� ����
	public static Vector<int[]> nodeInf = new Vector<int[]>();

	public static void topologySort() {
		// �������� ������� ���� �迭
		int[] result = new int[MAX];
		Queue<Integer> q = new LinkedList<Integer>();

		//���� ������ 0�� ���� ť�� ��´�.
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		// ���� ������ ������ ���� �Ƿ��� n���� ��带 �湮�ؾ���
		for (int i = 1; i <= n; i++) {
			// ���� n�� ������ ť�� �������� ����Ŭ�� �߻��� ��
			if (q.isEmpty() == true) {
				System.out.println("����Ŭ�� �߻��߽��ϴ�.");
				return;
			}
			//ť�� ��� ��带 ������.
			int x = q.poll();
			result[i] = x;

		//����� ������ null�� �ƴ� �� ���� �ݺ��Ѵ� nulló�� �����ָ� ������!!!!
		if(nodeInf.get(x)!=null) {
			
			//�ش� ť�� ��� ���� ����� ����� ������ŭ ����
			for (int j = 0; j < nodeInf.get(x).length; j++) {
				int y = nodeInf.get(x)[j];
				//������ŭ ���������� �ϳ��� ���ָ鼭
				--inDegree[y];
				//���� ���İ��� 0�̵� ��带 ť�� �ִ´� ���������� ������ �� ���� ���
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
