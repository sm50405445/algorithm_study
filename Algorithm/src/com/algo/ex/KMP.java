package com.algo.ex;

public class KMP {

	static int findString (String parent,String pattern) {
		
		int parentSize = parent.length();
		int patternSize = pattern.length();
		
		
		for(int i = 0 ; i<=parentSize-patternSize ; i++) {
			boolean find = true;
			for(int j = 0 ; j<patternSize ; j++) {
				if(parent.charAt(i+j)!=pattern.charAt(j)) {
					find = false;
					break;
				}
			}
			if(find==true) {				
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		String parent = "Hello world";
		String pattern = "o worl";
		System.out.println(findString(parent, pattern));
		if(findString(parent, pattern)!=-1) {
			System.out.println("해당 문자열을 "+findString(parent, pattern)+" 번 째에서 찾았습니다.");
		}else {
			System.out.println("해당 문자열을 못찾았습니다.");
		}
		
	}
}
