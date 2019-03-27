package com.algo.ex2;

import java.util.*;

public class baek1004 {

	//점이 원 안에 있나 확인하는 메서드
	static boolean inCircle(int nodeS, int nodeE, int starS, int starE, int r) {
		
		//노드와 원의 중심사이의 거리
		double d = Math.sqrt(Math.pow(starS - nodeS, 2) + Math.pow(starE - nodeE, 2));
		
		if (d < r)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			int count = 0;
			
			// 각각 시작점과 끝점의 좌표값
			int ss = scn.nextInt();
			int se = scn.nextInt();
			int es = scn.nextInt();
			int ee = scn.nextInt();
			
			// 원의 개수
			int m = scn.nextInt();
			// 해당 개수만큼 vector 배열에 각각 원의 x좌표 y좌표 반지름 값을 넣음
			Vector<int[]> star = new Vector<int[]>();
			for (int j = 0; j < m; j++) {
				int a = scn.nextInt();
				int b = scn.nextInt();
				int r = scn.nextInt();
				star.add(new int[] { a, b, r });
			}

			for (int j = 0; j < star.size(); j++) {
				// 시작,끝 노드와 행성간의 관계에서 노드가 행성 내부에 있는지 확인
				boolean startNode = inCircle(ss, se, star.get(j)[0], star.get(j)[1], star.get(j)[2]);
				boolean endNode = inCircle(es, ee, star.get(j)[0], star.get(j)[1], star.get(j)[2]);

				// 둘 중 하나의 노드라도 원 안에 있으면 우선 +1씩 더해줌
				if (startNode == true || endNode == true) {
					count++;
				}

				// 하지만 두 노드 모두 원 안에 있으면 -1씩 해줌
				if (startNode == true && endNode == true) {
					count--;
				}
			}
			result[i] = count;
		}
		scn.close();
		for(int i = 0 ; i<result.length ; i++) {
			System.out.println(result[i]);
		}
	}

}