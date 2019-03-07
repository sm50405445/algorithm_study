package com.algo.ex;

import java.util.LinkedList;
import java.util.Queue;


public class Ex {
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(3);
		q.add(4);
		q.add(5);
		
		q.poll();
		
		System.out.println(q.toString());
	}
	    
}


