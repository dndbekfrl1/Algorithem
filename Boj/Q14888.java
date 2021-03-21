package Backjun;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q14888 {
/*
 * 연산자 끼워넣기
 * 10억 이
 * 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 
 * 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 
 * 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 
 * 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
 * 
 * 
2
5 6
0 0 1 0

6
1 2 3 4 5 6
2 1 1 1
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int numarr[]=new int[n];  //상수 
		int oparr[]=new int[n-1]; // 연산
		int plus, multi, minus, div;
		ArrayList<Integer> res= new List<>();
		String input[];
		
		input=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			numarr[i]=Integer.parseInt(input[i]);
		}
		
		input=br.readLine().split(" ");
		plus=Integer.parseInt(input[0]);
		minus=Integer.parseInt(input[1]);
		multi=Integer.parseInt(input[2]);
		div=Integer.parseInt(input[3]);
		
		
		
		
		
		
	}

}
