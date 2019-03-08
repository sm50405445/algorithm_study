package com.algo.ex;

import java.util.Collections;
import java.util.Vector;

//합집합
class Union{
	
	public static int getParent(int[] parent, int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = getParent(parent, parent[x]);
		}
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
	
	public static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b) {
			return true;
		}else {
			return false;
		}
	}
}

// 간선 클래스 선언 
class Edge{
	//서로 연결된 두개의 노드정보
	private int[] node = new int[2];
	//거리 비용정보
	private int distance;
	
	public int[] getNode() {
		return node;
	}

	public int getDistance() {
		return distance;
	}

	public Edge(int a,int b,int distance) {
		this.node[0] = a;
		this.node[1] = b;
		this.distance = distance;
	}
	
}

public class Kruskal {
	
	public static void main(String[] args) {
		//노드 개수
		int n = 7;
		//간선 개수
		int m = 11;
		
		Vector<Edge> v = new Vector<>();
		v.add(new Edge(1,2,7));
		v.add(new Edge(1,4,5));
		v.add(new Edge(2,3,8));
		v.add(new Edge(2,4,9));
		v.add(new Edge(2,5,7));
		v.add(new Edge(3,5,5));
		v.add(new Edge(4,5,15));
		v.add(new Edge(4,6,6));
		v.add(new Edge(5,6,8));
		v.add(new Edge(5,7,9));
		v.add(new Edge(6,7,11));
		
		for(int i = 0 ; i<v.size()-1 ; i++) {
			for(int j = 0 ; j<v.size()-1 ; j++) {
				if(v.get(j).getDistance()>v.get(j+1).getDistance()) {
					Collections.swap(v, j, j+1);
				}
			}
		}
		
		int[] parent = new int[n];
		for(int i = 0 ; i<n ; i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		for(int i = 0; i<v.size() ; i++) {
			// 만약 두 노드 간 부모가 같다면(즉 연결이 되어 있지 않다면) 거리를 합해주고 연결해줘서 부모를 같게 만든다.
			if(!Union.findParent(parent,v.get(i).getNode()[0]-1,v.get(i).getNode()[1]-1 )) {
				sum += v.get(i).getDistance();
				Union.unionParent(parent, v.get(i).getNode()[0]-1, v.get(i).getNode()[1]-1);
			}
		}
		
		System.out.println(sum);
	}
	
	
}
