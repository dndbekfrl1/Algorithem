package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q13164 {
/*
 * 행복 유치원 
 * . 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다.
 *  원생의 수를 나타내는 자연수 N(1 ≤ N ≤ 300,000)
 *  나누려고 하는 조의 개수를 나타내는 자연수 K(1 ≤ K ≤ N)
 *  
 *  5 3
1 3 5 6 10
	1조: 1, 3
	2조: 5, 6
	3조: 10
	
	1 2 4/ 8/ 10
	
	
	2 2 1 4
	K조건에 맞춰 적절하게 원생을 나눠야 함
 	오름 순으로 정렬되어있음 
 	가장 키 큰 학생은 마지막 조에 배정 
 *
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n=Integer.parseInt(input[0]);//원생 수 
		int k=Integer.parseInt(input[1]);//모둠 수 
		input=br.readLine().split(" ");
		
		int narr[]=new int[n];
		for(int i=0;i<n;i++) {narr[i]=Integer.parseInt(input[i]);}
		int diff[]=new int[n-1];
		for(int i=0;i<n-1;i++) {diff[i]=narr[i+1]-narr[i];}
		Arrays.parallelSort(diff);
		
		int result=0;
		for(int i=0;i<n-k;i++) {
			result+=diff[i];
		}
		System.out.println(result);
	}

}
