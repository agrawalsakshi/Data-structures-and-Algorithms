package com.sakshi;

import java.util.HashMap;
import java.util.Scanner;

public class IsPallindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = scan.nextLine();
		scan.close();
		inputStr = inputStr.toLowerCase();
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Character> validChar = new HashMap<Integer, Character>();
		validChar.put(1, ' ');
		validChar.put(2, ',');
		validChar.put(3, '.');
		validChar.put(4, '!');
		for(int i=0;i<inputStr.length();i++) {
			if(!validChar.containsValue(inputStr.charAt(i))) {
				sb.append(inputStr.charAt(i));
			}
		}
		boolean result=checkForPallindrome(sb.toString(),0, sb.toString().length()-1);
		System.out.println(result);
	}
	//5  racecar
	public static boolean checkForPallindrome(String inputStr, int startindex , int endIndex) {
		if(startindex >= endIndex) {
			return true;
		}
		
		if(inputStr.charAt(startindex)== inputStr.charAt(endIndex)) {
			startindex= startindex+1;
			endIndex = endIndex-1;
			
		}
		else return false;
		return checkForPallindrome(inputStr, startindex,endIndex );
	}

}
