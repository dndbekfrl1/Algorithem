package Backjun;

import java.util.Scanner;

public class Q1748 {
	/*
	 * 수 이어 쓰기 1 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
	 * 1234567891011121314151617181920212223... 이렇게 만들어진 새로운 수는 몇 자리 수일까?
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); long res = 0;
		int len = String.valueOf(n).length();
		for (long i = 1; i <= n; i++) { // 1 ~ 10 12345678910
			if (i < 10) res++;
			else {
				long tmp = 1;
				while (i >= tmp) {
					tmp *= 10;
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
