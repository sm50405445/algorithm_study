package com.algo.ex;

import java.util.NoSuchElementException;

class QueueEx2<T>{
	
	//데이터를 받을 때 데이터 형식을 명시하기로하고 같은 타입을 받는 노드를 생성
	class Node<T>{
		//데이터 선언
		private T data;
		//다음노드선언
		private Node<T> next;
		//생성자에서 해당타입의 데이터 받아서 내부 변수에 저장
		public Node(T data) {
			this.data = data;
		}
	}
	// 두개의 주소를 기억해야함
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		Node<T> t = new Node<T>(item);
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first==null) {
			throw new NoSuchElementException();
		}
		//맨앞 데이터를 반환하기 전에 그 다음주소의 데이터를 first만들기
		
		//데이터를 백업하고
		T data = first.data;
		//다음놈을 first로 만들어줌
		first = first.next;
		
		//fisrt null이 된다면 last도 null로 변경해줘야함
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first==null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

public class QueueEx {

	public static void main(String[] args) {
	
		QueueEx2<Integer> q = new QueueEx2();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		
	}
	
}
