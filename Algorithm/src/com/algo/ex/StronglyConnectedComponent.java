package com.algo.ex;

import java.util.Stack;
import java.util.Vector;

public class StronglyConnectedComponent {

	static final int MAX = 10001;
	
	//노드의 고유 번호
	static int id;
	
	//해당 노드의 부모노드 즉 연결 된 상태에서 가장 노드번호가 작은 것들
	static int[] d = new int[12];
	
	//특정 dfs끝나는지 확인
	static boolean[] finished = new boolean[12];
	
	//노드의 연결관계
	static Vector<int[]> n = new Vector<>();
	
	//SCC그룹 한 그래프에서 여러 개 나올 수 있음
	static Vector<Vector<Integer>> SCC = new Vector<>();
	
	static Stack<Integer> s = new Stack<>();
	
	//DFS 총 정점의 개수만큼 실행됨
	
	static int dfs(int x) {
		d[x] = ++id;
		s.push(x);
		int parent = d[x];
		for(int i = 0 ; i<n.get(x).length; i++) {
			int y = n.get(x)[i];
			if(d[y]==0) {
				//방문하지 않은 이웃,방문하지 않은 이웃에 부모값과 비교하여 더 작은 부모로 바꿈
				if(parent>dfs(y)) {
					parent = dfs(y);					
				}
			}else if(!finished[y]) {
				//처리 중인 이웃? 현재 처리 중인 이웃이 자신의 부모와 같다면 부모를 같게 하고SCC에 포함시킴
				if(parent>d[y]) {
					parent = d[y];					
				}
			}
			//부모가 자기 자신인 경우
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
				/*System.out.println("SCC 개수 : " + SCC.size());
				for(int j = 0; j <SCC.size(); j++) {
					System.out.print(j+" 번째 SCC: "+j+1);
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
		System.out.println("SCC 개수 : " + SCC.size());
		for(int i = 0; i <SCC.size(); i++) {
			System.out.print(i+" 번째 SCC: "+i+1);
			for(int j = 0 ; j<SCC.get(i).size() ; j++) {
				System.out.print(SCC.get(i).get(j));
			}
			System.out.println();
		}
		
	}
}
