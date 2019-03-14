package com.algo.ex;

import java.util.Arrays;
import java.util.Vector;

public class Bipartite {
	
	static final int MAX = 101;
	
	static Vector<int[]> arr = new Vector<int[]>();
	//������ ����� ����
	static int d[] = new int[MAX];
	//Ư���� ��带 ó���ߴ��� Ȯ��
	static boolean c[] = new boolean[MAX];
	//���
	static int n = 3;
	
	static boolean dfs(int x) {
		
		for(int i = 0 ; i<arr.get(x).length ; i++) {
			int t = arr.get(x)[i];
			System.out.println("arr.get("+x+")["+i+"] = "+t);
			//�̹� ó�� �� ����� �ǳʶ�
			if(c[t]) {				
				continue;
			}else {
				c[t] = true;				
			}
			//��带 �ƹ��� �������� �ʾҰų� ��忡 �� �� ������ ���� ��
			if(d[t]==0 || dfs(d[t])) {
				d[t] = x;
				//��ȯ����!!!!!! �ٱ��� for���� ���� ���� ��ȯ�Ѵ�!!!!!!!!!!!
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		arr.setSize(n+1);
		
		arr.add(1,new int[] {1,2,3});
		arr.add(2,new int[] {1});
		arr.add(3,new int[] {2});
		
		int count = 0;
		for(int i = 1 ; i<=n; i++) {
			//�ش� ������ ���� �ߴ��� �迭�� ��尡 �� ������ �ʱ�ȭ ���ش� �׷��� �Ž��� �ö󰡸鼭 dfs()�Լ��� �����ϱ� ����
			Arrays.fill(c, false);
			//dfs(i) true�϶� count�� �ø��� �� ������ ���������� count �ö󰣴ٰ� ���� ��
			if(dfs(i)) {
				count++;
			}	
		}
		System.out.println(count+" ���� ��Ī�� �̷����");
		
		//�ش� ������ ������ ��带 ���ش�.
		for(int i = 1 ; i<MAX; i++) {
			if(d[i]!=0) {
				System.out.println(d[i]+"->"+i);
			}
		}
	}
}

