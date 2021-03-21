package Backjun;

import java.util.Scanner;

public class Q14650 {

	/*
	 * 3개 숫자(0, 1, 2)만 가지고 N자리 3의 배수 0, 1, 2만 가지고 만들 수 있는 N자리 3의 배수의 개수를 출력하삼.
	 * 
	 * N을 입력 받으삼. (1 ≤ N ≤ 9)
	 * 
	 * 중복순열 -> 재귀함수로 만든 후  
	 * 메소드 check로 3의 배수인지 확인함  
	 * 
	 * 	static int Arr[]=new int [9];
	 *	static int Select[]=new int[9]; 를 9로 먼저 선언 하지 않으니까 런타임 에러가 발생함
	 *  Integer.toString() -> 메소드는 왜인지 모르겠으나 일정 자릿수 넘어가면 오류가 발생함 쓰면 안될듯
	 */
	static int res = 0;
	static int Arr[]=new int [9];
	static int Select[]=new int[9];
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < 3; i++)
			Arr[i] = i;
		dfs(0);
		System.out.println(res);
	}

	public static void dfs(int Cnt) {
		if (N == Cnt) {
			int number = 0;
			for (int i = 0; i < N; i++) {
				number += Select[i] * (Math.pow(10, (N - 1 - i)));
			}
			check(number);
			return;
		}

		for (int i = 0; i < 3; i++) {
			Select[Cnt] = Arr[i];
			if (Select[0] == 0)
				continue;
			else
				dfs(Cnt + 1);
		}
	}

	private static void check(int number) {
		if (number % 3 == 0) {
			res++;
		}
	}

}
