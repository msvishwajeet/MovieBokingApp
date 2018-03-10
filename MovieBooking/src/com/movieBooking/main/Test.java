package com.movieBooking.main;

import java.util.Scanner;

public class Test {
	final static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter a strIng");
		String s = sc.nextLine();
		System.out.println(s);
		int ip= Integer.valueOf(s);
		System.out.println(ip);
	}
}
