package com.algo.ex;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


class Queue<T>{
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

class Graph{
	
	class Node{
		int data;
		LinkedList<Node> adjacent;
		//방문확인 marked
		boolean marked;
		//노드 생성자에서는 데이터를 받고 marking place를 초기화하고 
		public Node(int data) {
			this.data = data;
			this.marked = false;
		//linkedlist 준비
			adjacent = new LinkedList<Node>();
		}
		
	}
	//노드 저장할 배열 필요
	Node[] nodes;
	
	//그래프 만들기
	Graph(int size){
		//노드 개수를 받아서 그 개수만큼 배열방을 만듦
		nodes = new Node[size];
		for(int i = 0; i<size ; i++) {
			// 데이터 배열방 번호를 동일하게 만듦, 0부터 개수-1까지 노드 들어감
			nodes[i] = new Node(i);
		}
	}
	
	//두 노드 관계 저장
	void addEdge(int i1, int i2) {
		//데이터가 인덱스와 같아서 받은 숫자를 인덱스로 사용 가능
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		//상대방이 있는지 확인하고 서로 추가해줌
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
		//스택에 들어갔다고 표시
		root.marked = true;
		while(!stack.isEmpty()) {
			//스택에서 하나 가져오고
			Node r = stack.pop();
			//가져온 노드의 자식들을 스택에 추가함
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
			//remove()에는 현재 데이터를 빼오고 다음 데이터를 처음으로 가져다 놓음
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
	
	//재귀함수로 구현
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
		
		
		System.out.println("0부터 넓이 우선 탐색 ");
		g.bfs();
		
		
		
	}
	
	
}
