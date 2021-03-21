package Backjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2748 {
	/*피보나치 수열 2*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		List<Long> result = new ArrayList<Long>();
		int tmp=0;
		for(int i=0;i<=n;i++) {
			if(i==0) {result.add((long) 0);}
			if(i==1) {result.add((long) 1);}
			if(i>=2) {
				result.add(fibo(n,result,i));
				tmp+=fibo(n,result,i);
			}
		}
		System.out.println(result.get((int) n));
	}

	static long fibo(long n, List<Long> result, int i) {
		Long op1=result.get(i-2);
		Long op2=result.get(i-1);
		return op1+op2;
	}

}
