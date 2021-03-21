package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10989 {
	
	/* 버블정렬 사용시 시간초과 발생  
	 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
	 * 오름차순으로 정렬 
	 	5
		2
		3
		1
		4
		2
		3
		5
		1
		7 
	 * */

	 public static void main(String[] args) throws Exception {
	        // TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[10001];
	        for (int i = 0; i < N; i++) {
	            arr[Integer.parseInt(br.readLine())] ++;
	        }
	    	for (int i = 1; i < 10001; i++) {
				while (0 < arr[i]--) {
					bw.write(Integer.toString(i) + "\n");
				}
			}
	        br.close();
	        bw.close();
	    }

}
