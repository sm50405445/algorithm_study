package com.algo.ex;

public class Union_Find {

	
	public static int getParent(int parent[], int x) {
		//�⺻������ �ڱ� �ڽ��� �θ�� ����
		if(parent[x]==x) {
			return x;
		}else {
			/*�����θ� ã�ƿ��� ����
			���� : 1 2 3 4 5 6 7 8 9
			�θ� : 1 1 2 3 4 5 6 7 8
			3������ �ִ� �θ�� 2�� ����Ŵ �׷��� else�κ��� ����ǰ�
			2 = getparent(parent�迭,parent[2])�� ���� Ȯ���� ����Լ� ����*/
			return parent[x] = getParent(parent,parent[x]);
		}
	}
	
	//�θ� Ȯ���ϰ� �� ���� �θ� ���� ������ ��ģ��.
	public static void unionParent(int parent[],int a,int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
	
	//���� �θ� �������� Ȯ��
	public static int findParent(int parent[],int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b) {
			System.out.println("�θ� �����ϴ�.");
			return 1;
		}else {
			System.out.println("�θ� �ٸ��ϴ�.");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[11];
		for(int i = 0 ; i<arr.length ; i++) {
			arr[i] = i;
		}
		
		unionParent(arr, 1, 2);
		unionParent(arr, 1, 3);
		unionParent(arr, 1, 4);
		unionParent(arr, 5, 6);
		unionParent(arr, 6, 7);
		unionParent(arr, 7, 8);
		
		findParent(arr, 1, 2);
		findParent(arr, 2, 4);
		findParent(arr, 1, 6);
		unionParent(arr, 4, 5);
		findParent(arr, 1, 6);
		
	}
}
