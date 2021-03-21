package Backjun_self;

import java.util.Arrays;
import java.util.Scanner;

public class Q2750 {

	/*
5
5
2
3
4
1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int narr[]=new int[n];
		for(int i=0;i<n;i++) {
			narr[i]=sc.nextInt();
		}
		
		Arrays.parallelSort(narr);
		for(int i=0;i<n;i++) {
			System.out.println(narr[i]);
		}
	}

}
