package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2776 {
	//암기왕
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		       /*이거는 시간 초과가 남 ..*/
		    HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();
				Scanner sc = new Scanner(System.in);
				int tcase = sc.nextInt();
				for (int i = 0; i < tcase; i++) {
					int n = sc.nextInt();
					for (int j = 0; j < n; j++) {
						int num = sc.nextInt();
						check.put(num, 1);	
					} 
					int m = sc.nextInt();
					for (int j = 0; j < m; j++) {
						int num = sc.nextInt();// 재배열 안됨
						if (check.containsKey(num)) {System.out.println(1);} 
		                else {System.out.println(0);}
					}
		            check.clear();
				}
		    
		// TODO Auto-generated method stub
//		HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tcase = Integer.parseInt(br.readLine());
//		int note1=0;
//		int note2=0;
//		for (int i = 0; i < tcase; i++) {
//			int n = Integer.parseInt(br.readLine());
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < n; j++) {
//				note1 = Integer.parseInt(st.nextToken());
//				check.put(note1, 1);
//			}
//			int m = Integer.parseInt(br.readLine());
//			StringTokenizer st1 = new StringTokenizer(br.readLine());
//			for (int j = 0; j < m; j++) {
//				note2 = Integer.parseInt(st1.nextToken());// 재배열 안됨
//				if (check.containsKey(note2)) { System.out.println(1);} 
//				else { System.out.println(0);}
//			
//			}
//			check.clear();
//		}
	}
}
