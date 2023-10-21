package level_1;

import java.util.Scanner;

public class Pallindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a String :");
		String s = scn.nextLine();
		if(isPallindrome(s)) {
			System.out.println(s+" - is a pallindrome");
		}
		else {
			System.out.println(s+" - is a not pallindrome");
		}
		
		scn.close();
		
	}
	public static boolean isPallindrome(String s) {
		s=s.toLowerCase();
		String reverse="";
		boolean flag=false;
		
		for(int i=s.length()-1;i>=0;i--) {
			reverse+=s.charAt(i);
		}
		
		if(s.equals(reverse)) flag = true;
		return flag;
	}
	
	
	
}
