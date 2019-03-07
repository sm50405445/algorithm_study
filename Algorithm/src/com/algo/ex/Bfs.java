package com.algo.ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Bfs {

	static int[] c = new int[7];
	static Vector<Integer> a = new Vector<>(8);
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		c[start] = 1;
		while(!q.isEmpty()) {
			int x = q.peek();
			q.poll();
			System.out.print(x);
			
		}
	}
	
	
	
}
