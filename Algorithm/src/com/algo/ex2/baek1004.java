package com.algo.ex2;

import java.util.*;

public class baek1004 {

	//���� �� �ȿ� �ֳ� Ȯ���ϴ� �޼���
	static boolean inCircle(int nodeS, int nodeE, int starS, int starE, int r) {
		
		//���� ���� �߽ɻ����� �Ÿ�
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
			
			// ���� �������� ������ ��ǥ��
			int ss = scn.nextInt();
			int se = scn.nextInt();
			int es = scn.nextInt();
			int ee = scn.nextInt();
			
			// ���� ����
			int m = scn.nextInt();
			// �ش� ������ŭ vector �迭�� ���� ���� x��ǥ y��ǥ ������ ���� ����
			Vector<int[]> star = new Vector<int[]>();
			for (int j = 0; j < m; j++) {
				int a = scn.nextInt();
				int b = scn.nextInt();
				int r = scn.nextInt();
				star.add(new int[] { a, b, r });
			}

			for (int j = 0; j < star.size(); j++) {
				// ����,�� ���� �༺���� ���迡�� ��尡 �༺ ���ο� �ִ��� Ȯ��
				boolean startNode = inCircle(ss, se, star.get(j)[0], star.get(j)[1], star.get(j)[2]);
				boolean endNode = inCircle(es, ee, star.get(j)[0], star.get(j)[1], star.get(j)[2]);

				// �� �� �ϳ��� ���� �� �ȿ� ������ �켱 +1�� ������
				if (startNode == true || endNode == true) {
					count++;
				}

				// ������ �� ��� ��� �� �ȿ� ������ -1�� ����
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