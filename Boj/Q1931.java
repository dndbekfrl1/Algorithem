package Backjun;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1931 {
	/*
	 * 회의실 배정 
	 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)
	 * 11
		1 4
		3 5
		0 6
		5 7
		3 8
		5 9
		6 10
		8 11		
		8 12
		2 13
		12 14
		
		1 4 , 5 7 , 8 11 , 12 14
		
		가장 빨리 끝나는 회의 순으로 정렬
		회의 종료시간에 맞춰 짧은 회의를 계속해서 회의 진행  
		
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt(); //회의 시작시간 
			arr[i][1]=sc.nextInt(); //회의 종료시간 
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				if(start[1]==end[1]) 
					return Integer.compare(start[0], end[0]);
				return Integer.compare(start[1], end[1]);
			}
		});

		//진행한 회의 수 
		int cnt=1;
		//첫 회의 종료시간 (1,4)
		int end=arr[0][1];
		for(int i=1;i<N;i++) {
			//다음 회의 시작시간
			int start=arr[i][0];//(3,5)(0 6)(5,7)
			if(end<=start) {
				cnt++;
				end=arr[i][1];
			}
		}
		System.out.println(cnt);
	}

}
