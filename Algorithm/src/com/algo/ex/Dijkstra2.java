package com.algo.ex;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;



public class Dijkstra2 {

	static final int INF = 1000000;
	
	
	//��������
	static Vector<Integer> a = new Vector<>();
	
	//�ּҺ��
	static int[] d = new int[6];
	
	public static void dijkstra(int start) {
	/*	//���� �Ÿ��� 0
		d[start] = 0;
		
		//������(�ִ�����)
		PriorityQueue<HashMap<Integer, Integer>> pq = new PriorityQueue<>();
		
		//����� ������� ó���ϹǷ� ť ���
		while(!pq.isEmpty()) {
			
			int current = pq.peek().get(0);
			//ª�� ���� ���� ������ ����ȭ �ϱ�
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
