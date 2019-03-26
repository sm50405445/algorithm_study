package com.algo.ex;

import java.util.NoSuchElementException;

class QueueEx2<T>{
	
	//�����͸� ���� �� ������ ������ ����ϱ���ϰ� ���� Ÿ���� �޴� ��带 ����
	class Node<T>{
		//������ ����
		private T data;
		//������弱��
		private Node<T> next;
		//�����ڿ��� �ش�Ÿ���� ������ �޾Ƽ� ���� ������ ����
		public Node(T data) {
			this.data = data;
		}
	}
	// �ΰ��� �ּҸ� ����ؾ���
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
		//�Ǿ� �����͸� ��ȯ�ϱ� ���� �� �����ּ��� �����͸� first�����
		
		//�����͸� ����ϰ�
		T data = first.data;
		//�������� first�� �������
		first = first.next;
		
		//fisrt null�� �ȴٸ� last�� null�� �����������
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
