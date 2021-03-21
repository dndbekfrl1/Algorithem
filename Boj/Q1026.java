package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		int[] A= new int[N];
		int[] B= new int[N];
		int S=0;
		String input[]=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(input[i]);}
		input=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			B[i]=Integer.parseInt(input[i]);}
		
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i=0;i<N;i++) {
			S+=A[i]*B[N-1-i];
		}
		System.out.println(S);
	}

}
