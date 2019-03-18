package com.algo.ex;

public class Rabin_Karp {

	static void findParent(String parent, String pattern) {
		
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int parentHash = 0, patternHash = 0;
		//power = ������
		int power = 1;
		
		for(int i = 0 ; i<=parentSize-patternSize ; i++) {
			//ó������ ��ü ���ڿ��� �˻��Ϸ��� ���ڿ��� �ؽ��ڵ带 �ʱ�ȭ���ش�.
			if(i==0) {
				for(int j = 0 ; j<patternSize ; j++) {
					//�ؽ��ڵ带 ���� ���� 1���ڸ����ں��� 2�� �������� ���� ���ϰ� �ȴ�.
					//�� abc�� �ؽ��ڵ带 ��ȯ�Ϸ��� c���� c*2^0+b*2^1... ���� index����
					parentHash += parent.charAt(patternSize-1-j)*power;
					patternHash += pattern.charAt(patternSize-1-j)*power;
					if(j<patternSize-1)
						power*=2;
				}
			}else {
				parentHash = 2*(parentHash-parent.charAt(i-1)*power)+parent.charAt(patternSize-1+i);
			}
			if(parentHash==patternHash) {
				boolean find = true;
				for(int j = 0 ; j<patternSize ; j++) {
					if(parent.charAt(i+j)!=pattern.charAt(j)) {
						find = false;
						break;
					}
				}
				if(find) {
					System.out.println(i+1+"��°���� �߰��߽��ϴ�.");
				}
			}
		}
	}
	 
	public static void main(String[] args) {
		
		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		findParent(parent, pattern);
	}
	
}
