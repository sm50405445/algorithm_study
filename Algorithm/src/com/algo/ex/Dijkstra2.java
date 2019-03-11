package com.algo.ex;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;



public class Dijkstra2 {

	static final int INF = 1000000;
	
	
	//간선정보
	static Vector<Integer> a = new Vector<>();
	
	//최소비용
	static int[] d = new int[6];
	
	public static void dijkstra(int start) {
	/*	//본인 거리는 0
		d[start] = 0;
		
		//힙구조(최대힙임)
		PriorityQueue<HashMap<Integer, Integer>> pq = new PriorityQueue<>();
		
		//가까운 순서대로 처리하므로 큐 사용
		while(!pq.isEmpty()) {
			
			int current = pq.peek().get(0);
			//짧은 것이 먼저 오도록 음수화 하기
			int distance = -pq.peek().get(1);
			
			pq.poll();
			
			if(d[current]<distance) {				
				continue;
			}
			
			for(int i = 0 ; i<a.get(current).size(); i++) {
				
				int next = a.get(current).get(i);
				
				int nextDistance = distance + a.get(current).get(i+1);
				
				if(nextDistance<d[next]) {
					d[next] = nextDistance;
					pq.add(new HashMap<Integer,Integer>(next,-nextDistance));
				}
			}
			
		}*/
		
		
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i<6; i++) {
			d[i] = INF;
		}
		a.setSize(6);

		a.add(0,new HashMap<Integer,Integer>().put(2, 2));
		a.add(0,new HashMap<Integer,Integer>().put(3, 5));
		a.add(0,new HashMap<Integer,Integer>().put(4, 1));
		
		/*a.add(1,new HashMap<Integer,Integer>(1,2));
		a.add(1,new HashMap<Integer,Integer>(3,3));
		a.add(1,new HashMap<Integer,Integer>(4,2));
		
		a.add(2,new HashMap<Integer,Integer>(1,5));
		a.add(2,new HashMap<Integer,Integer>(2,3));
		a.add(2,new HashMap<Integer,Integer>(4,3));
		a.add(2,new HashMap<Integer,Integer>(5,1));
		a.add(2,new HashMap<Integer,Integer>(6,5));
		
		a.add(3,new HashMap<Integer,Integer>(1,1));
		a.add(3,new HashMap<Integer,Integer>(2,2));
		a.add(3,new HashMap<Integer,Integer>(3,3));
		a.add(3,new HashMap<Integer,Integer>(5,1));
		
		a.add(4,new HashMap<Integer,Integer>(3,1));
		a.add(4,new HashMap<Integer,Integer>(4,1));
		a.add(4,new HashMap<Integer,Integer>(6,2));
		
		a.add(5,new HashMap<Integer,Integer>(3,5));
		a.add(5,new HashMap<Integer,Integer>(5,2));*/
		
		
		dijkstra(0);
		
		for(int i = 0 ; i<6 ; i++) {
			System.out.print(d[i]+" ");
		}
	}
	
}
