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
	
	static Stack<Integer> s = new Stack<>();
	
	//DFS �� ������ ������ŭ �����
	
	static int dfs(int x) {
		d[x] = ++id;
		s.push(x);
		int parent = d[x];
		for(int i = 0 ; i<n.get(x).length; i++) {
			int y = n.get(x)[i];
			if(d[y]==0) {
				//�湮���� ���� �̿�,�湮���� ���� �̿��� �θ𰪰� ���Ͽ� �� ���� �θ�� �ٲ�
				if(parent>dfs(y)) {
					parent = dfs(y);					
				}
			}else if(!finished[y]) {
				//ó�� ���� �̿�? ���� ó�� ���� �̿��� �ڽ��� �θ�� ���ٸ� �θ� ���� �ϰ�SCC�� ���Խ�Ŵ
				if(parent>d[y]) {
					parent = d[y];					
				}
			}
			//�θ� �ڱ� �ڽ��� ���
			if(parent==d[x]) {
				Vector<Integer> scc = new Vector<>();
				while(true) {
					int t = s.peek();
					s.pop();
					System.out.print(t+" ");
					scc.add(t);
					finished[t] = true;
					if(t==x) {
						break;						
					}
				}
				System.out.println();
				SCC.add(scc);
				/*System.out.println("SCC ���� : " + SCC.size());
				for(int j = 0; j <SCC.size(); j++) {
					System.out.print(j+" ��° SCC: "+j+1);
					for(int k = 0 ; k<SCC.get(j).size() ; k++) {
						System.out.print(SCC.get(j).get(k));
					}
					System.out.println();
				}*/
				
			}
			
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
			System.out.print(i+" ��° SCC: "+i+1);
			for(int j = 0 ; j<SCC.get(i).size() ; j++) {
				System.out.print(SCC.get(i).get(j));
			}
			System.out.println();
		}
		
	}
}
