package com.sakshi;

import java.util.Scanner;

public class Atoi {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String inputstr = scan.nextLine();
		scan.close();
		inputstr=inputstr.trim();
		boolean isNegative=false;
		int index=0;
		
	if(inputstr.charAt(index)=='+') {
		index++;
	}
	else if(inputstr.charAt(index)=='-') {
		isNegative=true;
		index++;
	}
	
	int resultedNum=0;
	
	for(int curIndex = index;curIndex<inputstr.length();curIndex++) {
		if(Character.isDigit(inputstr.charAt(curIndex))) {
			resultedNum = resultedNum*10 + inputstr.charAt(curIndex)-'0';
		}
		else
			break;
	}
	
	 if(isNegative) {
		 resultedNum=resultedNum*(-1);
	 }
	
	System.out.println( resultedNum);	
	}

}
