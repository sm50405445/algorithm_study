package com.algo.ex;

import java.util.Stack;
import java.util.Vector;

public class StronglyConnectedComponent {

	static final int MAX = 10001;
	
	//����� ���� ��ȣ
	static int id;
	
	//�ش� ����� �θ��� �� ���� �� ���¿��� ���� ����ȣ�� ���� �͵�
	static int[] d = new int[12];
	
	//Ư�� dfs�������� Ȯ��
	static boolean[] finished = new boolean[12];
	
	//����� �������
	static Vector<int[]> n = new Vector<>();
	
	//SCC�׷� �� �׷������� ���� �� ���� �� ����
	static Vector<Vector<Integer>> SCC = new Vector<>();
	
	//������ �����ϴ� ����? �� ��尡 ���Ѱ��հ��踦 �����ϴ��� ������� ������ ������� Ȱ���ϱ� ���� ����
	static Stack<Integer> s = new Stack<>();
	
	//DFS �� ������ ������ŭ �����
	static int dfs(int x) {
		//�θ� ��Ÿ���� �迭�� �� ������ ��� ������ �ʱ�ȭ �����ش�
		d[x] = ++id;
		//�ش� ��带 ���ÿ� ��´�
		s.push(x);
		int parent = d[x];
		for(int i = 0 ; i<n.get(x).length; i++) {
			//�ش� ���� ����� ����� ������ y�� ������ ��´�.
			int y = n.get(x)[i];
			
			//d[y]==0�̶�� �ѹ��� dfs�� �������� ���� ����̴�.
			if(d[y]==0) {
				//�湮���� ���� �̿�,�湮���� ���� �̿��� �θ𰪰� ���Ͽ� �� ���� �θ�� �ٲ�
				parent = Math.min(parent, dfs(y));
			}else if(!finished[y]) {
				//ó�� ���� �̿�? ���� ó�� ���� �̿��� �ڽ��� �θ�� ���ٸ� �θ� ���� �ϰ�SCC�� ���Խ�Ŵ
				parent = Math.min(parent, d[y]);
			}
		}//��������� ���� �θ��� ���踦 �ϼ���Ų�� 
		
		//�θ� �ڱ� �ڽ��� ���
		//ó�� ������ ���� ���� ������� ���� ���� dfs(2)�� ����ǰ� dfs(3)�� ����ȴ� ���� 2������ 3����尡 ���ÿ� ����.
		if(parent==d[x]) {
			//scc���踦 �����ϱ� ���� ���� vector�Լ��� �����.
			Vector<Integer> scc = new Vector<>();
			while(true) {
				//���ÿ� ������ ��� ��带 ������
				int t = s.pop();
				//�Ʊ� ���� ���Ϳ� �ε���0���� �������ְ�
				scc.add(t);
				//�ش� ���� ó�� �ߴٴ� boolean�Լ��� true�����Ѵ�. finished�� true�� �Լ��� ���߿� � ���� ����Ǵ���
				//�̹� SCC�� ���� ���� ���� for������ ������ �θ� �� �������� �����Ű�� �ʴ´�.
				finished[t] = true;
				//�θ��� ���� �ڱ� �ڽŰ� ���ٴ� ���� ���� ���� ���� ���ÿ� ��� ��� ���� �θ��� ���� �ǹ��ϹǷ�
				//���ÿ��� ���� ���� dfs�� ���� ���� ���� �� ���� while�� �ݺ��� ���ش�.
				if(t==x) {
					break;						
				}
			}
			SCC.add(scc);
		}
		return parent;
	}
	
	
	public static void main(String[] args) {
		int v = 11;
		n.setSize(12);
		n.set(1, new int[] {2});
		n.set(2, new int[] {3});
		n.set(3, new int[] {1});
		n.set(4, new int[] {2,5});
		n.set(5, new int[] {7});
		n.set(6, new int[] {5});
		n.set(7, new int[] {6});
		n.set(8, new int[] {5,9});
		n.set(9, new int[] {10});
		n.set(10, new int[] {11});
		n.set(11, new int[] {3,8});
		
		for(int i = 1 ; i<=v; i++) {
			if(d[i]==0) {
				dfs(i);
			}
		}
		
		System.out.println("SCC ���� : " + SCC.size());
		for(int i = 0; i <SCC.size(); i++) {
			System.out.print(i+1+" ��° SCC: ");
			for(int j = 0 ; j<SCC.get(i).size() ; j++) {
				System.out.print(SCC.get(i).get(j)+",");
			}
			System.out.println();
		}
		
	}
}
