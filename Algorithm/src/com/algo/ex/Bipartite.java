package com.algo.ex;

import java.util.Arrays;
import java.util.Vector;

public class Bipartite {
	
	static final int MAX = 101;
	
	static Vector<int[]> arr = new Vector<int[]>();
	//점유한 노드의 정보
	static int d[] = new int[MAX];
	//특정한 노드를 처리했는지 확인
	static boolean c[] = new boolean[MAX];
	//노드
	static int n = 3;
	
	static boolean dfs(int x) {
		
		for(int i = 0 ; i<arr.get(x).length ; i++) {
			int t = arr.get(x)[i];
			System.out.println("arr.get("+x+")["+i+"] = "+t);
			//이미 처리 된 노드라면 건너뜀
			if(c[t]) {				
				continue;
			}else {
				c[t] = true;				
			}
			//노드를 아무도 점유하지 않았거나 노드에 더 들어갈 공간이 있을 때
			if(d[t]==0 || dfs(d[t])) {
				d[t] = x;
				//반환했음!!!!!! 바깥쪽 for문이 돌기 전에 반환한다!!!!!!!!!!!
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
			//해당 공간을 점유 했는지 배열은 노드가 들어갈 때마다 초기화 해준다 그래야 거슬러 올라가면서 dfs()함수를 실행하기 때문
			Arrays.fill(c, false);
			//dfs(i) true일때 count를 올린다 즉 점유가 가능해지면 count 올라간다고 보면 됨
			if(dfs(i)) {
				count++;
			}	
		}
		System.out.println(count+" 개의 매칭이 이루어짐");
		
		//해당 공간을 점유한 노드를 써준다.
		for(int i = 1 ; i<MAX; i++) {
			if(d[i]!=0) {
				System.out.println(d[i]+"->"+i);
			}
		}
	}
}

