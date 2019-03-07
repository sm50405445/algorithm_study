package com.algo.ex;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


class Queue<T>{
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

class Graph{
	
	class Node{
		int data;
		LinkedList<Node> adjacent;
		//�湮Ȯ�� marked
		boolean marked;
		//��� �����ڿ����� �����͸� �ް� marking place�� �ʱ�ȭ�ϰ� 
		public Node(int data) {
			this.data = data;
			this.marked = false;
		//linkedlist �غ�
			adjacent = new LinkedList<Node>();
		}
		
	}
	//��� ������ �迭 �ʿ�
	Node[] nodes;
	
	//�׷��� �����
	Graph(int size){
		//��� ������ �޾Ƽ� �� ������ŭ �迭���� ����
		nodes = new Node[size];
		for(int i = 0; i<size ; i++) {
			// ������ �迭�� ��ȣ�� �����ϰ� ����, 0���� ����-1���� ��� ��
			nodes[i] = new Node(i);
		}
	}
	
	//�� ��� ���� ����
	void addEdge(int i1, int i2) {
		//�����Ͱ� �ε����� ���Ƽ� ���� ���ڸ� �ε����� ��� ����
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		//������ �ִ��� Ȯ���ϰ� ���� �߰�����
		if(!n1.adjacent.contains(n2))
			n1.adjacent.add(n2);
		if(!n2.adjacent.contains(n1))
			n2.adjacent.add(n1);
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		//���ÿ� ���ٰ� ǥ��
		root.marked = true;
		while(!stack.isEmpty()) {
			//���ÿ��� �ϳ� ��������
			Node r = stack.pop();
			//������ ����� �ڽĵ��� ���ÿ� �߰���
			for(Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<>();
		queue.add(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			//remove()���� ���� �����͸� ������ ���� �����͸� ó������ ������ ����
			Node r = queue.remove();
			for(Node n : r.adjacent) {
				if(n.marked==false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}
	
	//����Լ��� ����
	void dfsR(Node r) {
		if(r==null) return;
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
			if(n.marked==false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR() {
		dfsR(0);
	}
	
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
	
	
}

public class BFS_breathFisrtSearch {

	
	/*
	--------------------------
		0
	   /
	  1 -- 3      7
	  |  / | \   /
	  | /  |   5
	  2 -- 4    \
	  			 6 - 8
	  			 
	 */
	
	public static void main(String[] args) {

		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		
		System.out.println("0���� ���� �켱 Ž�� ");
		g.bfs();
		
		
		
	}
	
	
}
