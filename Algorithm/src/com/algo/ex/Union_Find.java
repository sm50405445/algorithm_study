package com.algo.ex;

public class Union_Find {

	
	public static int getParent(int parent[], int x) {
		//기본적으로 자기 자신을 부모로 지정
		if(parent[x]==x) {
			return x;
		}else {
			/*실제부모를 찾아오는 과정
			본래 : 1 2 3 4 5 6 7 8 9
			부모 : 1 1 2 3 4 5 6 7 8
			3번지에 있는 부모는 2를 가르킴 그래서 else부분이 실행되고
			2 = getparent(parent배열,parent[2])의 값을 확인함 재귀함수 실행*/
			return parent[x] = getParent(parent,parent[x]);
		}
	}
	
	//부모를 확인하고 더 작은 부모를 가진 쪽으로 합친다.
	public static void unionParent(int parent[],int a,int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b) {
			parent[b] = a;
		}else {
			parent[a] = b;
		}
	}
	
	//같은 부모를 가지는지 확인
	public static int findParent(int parent[],int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b) {
			System.out.println("부모가 같습니다.");
			return 1;
		}else {
			System.out.println("부모가 다릅니다.");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[11];
		for(int i = 0 ; i<arr.length ; i++) {
			arr[i] = i;
		}
		
		unionParent(arr, 1, 2);
		unionParent(arr, 1, 3);
		unionParent(arr, 1, 4);
		unionParent(arr, 5, 6);
		unionParent(arr, 6, 7);
		unionParent(arr, 7, 8);
		
		findParent(arr, 1, 2);
		findParent(arr, 2, 4);
		findParent(arr, 1, 6);
		unionParent(arr, 4, 5);
		findParent(arr, 1, 6);
		
	}
}
