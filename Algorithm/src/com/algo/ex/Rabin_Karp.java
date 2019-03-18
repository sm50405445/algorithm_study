package com.algo.ex;

public class Rabin_Karp {

	static void findParent(String parent, String pattern) {
		
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int parentHash = 0, patternHash = 0;
		//power = 제곱수
		int power = 1;
		
		for(int i = 0 ; i<=parentSize-patternSize ; i++) {
			//처음에는 전체 문자열과 검색하려는 문자열의 해시코드를 초기화해준다.
			if(i==0) {
				for(int j = 0 ; j<patternSize ; j++) {
					//해시코드를 더할 때는 1의자리숫자부터 2의 제곱수를 곱해 더하게 된다.
					//즉 abc의 해시코드를 반환하려면 c부터 c*2^0+b*2^1... 끝의 index부터
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
					System.out.println(i+1+"번째에서 발견했습니다.");
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
