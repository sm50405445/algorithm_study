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
	
	//스택을 형성하는 이유? 각 노드가 강한결합관계를 형성하는지 순서대로 꺼내는 방식으로 활용하기 위해 선언
	static Stack<Integer> s = new Stack<>();
	
	//DFS 총 정점의 개수만큼 실행됨
	static int dfs(int x) {
		//부모를 나타내는 배열을 그 고유의 노드 값으로 초기화 시켜준다
		d[x] = ++id;
		//해당 노드를 스택에 담는다
		s.push(x);
		int parent = d[x];
		for(int i = 0 ; i<n.get(x).length; i++) {
			//해당 노드와 연결된 노드의 정보를 y의 변수에 담는다.
			int y = n.get(x)[i];
			
			//d[y]==0이라면 한번도 dfs를 실행하지 않은 노드이다.
			if(d[y]==0) {
				//방문하지 않은 이웃,방문하지 않은 이웃에 부모값과 비교하여 더 작은 부모로 바꿈
				parent = Math.min(parent, dfs(y));
			}else if(!finished[y]) {
				//처리 중인 이웃? 현재 처리 중인 이웃이 자신의 부모와 같다면 부모를 같게 하고SCC에 포함시킴
				parent = Math.min(parent, d[y]);
			}
		}//여기까지가 노드와 부모의 관계를 완성시킨다 
		
		//부모가 자기 자신인 경우
		//처음 시작할 때를 보자 여기까지 돌기 전에 dfs(2)가 실행되고 dfs(3)이 실행된다 따라서 2번노드와 3번노드가 스택에 담겼다.
		if(parent==d[x]) {
			//scc관계를 설정하기 위한 작은 vector함수를 만든다.
			Vector<Integer> scc = new Vector<>();
			while(true) {
				//스택에 마지막 담긴 노드를 꺼내서
				int t = s.pop();
				//아까 만든 벡터에 인덱스0부터 저장해주고
				scc.add(t);
				//해당 노드는 처리 했다는 boolean함수를 true변경한다. finished에 true된 함수는 나중에 어떤 노드와 연결되더라도
				//이미 SCC가 끝난 노드는 위의 for문에서 누구의 부모가 더 작은지를 실행시키지 않는다.
				finished[t] = true;
				//부모의 값이 자기 자신과 같다는 말은 가장 먼저 담겼고 스택에 담긴 모든 수의 부모라는 것을 의미하므로
				//스택에서 꺼낸 수와 dfs에 넣은 값이 같을 때 까지 while문 반복을 해준다.
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
		
		System.out.println("SCC 개수 : " + SCC.size());
		for(int i = 0; i <SCC.size(); i++) {
			System.out.print(i+1+" 번째 SCC: ");
			for(int j = 0 ; j<SCC.get(i).size() ; j++) {
				System.out.print(SCC.get(i).get(j)+",");
			}
			System.out.println();
		}
		
	}
}
