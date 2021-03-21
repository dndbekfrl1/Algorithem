package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q2628 {
	//가로길이의 배열과 높이길이의 배열을 저장후 각 최대값을 구
	/*
	0 3
	1 4
	0 2
	 */
	//근데 BuffredReader랑 Scanner을 같이 쓰면 런타임에러가 나던데 왜그런거..? 
	public static void main(String[] args) throws IOException {
       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc =new Scanner(System.in);
		
		int w=sc.nextInt(); int h=sc.nextInt();
		int cut=sc.nextInt();
		String input[];
		int[] warr=new int[cut+1];
		int[] harr=new int[cut+1];
		int hMax=0; int wMax=0;
		for(int i=0;i<cut;i++) {
			int row=sc.nextInt();
			int num=sc.nextInt();
			if(row==0) harr[i]=num;							  //{0,0,4,10} -> {0,4,6} 사이값 구하기 
			else warr[i]=num;							  	//{0,2,3,8} -> {2,1,5} 사이값 구하기 
		}
		harr[cut]=h; warr[cut]=w;
		Arrays.sort(harr); 	Arrays.sort(warr);
		hMax=harr[0];
		wMax=warr[0];

		for(int i=1;i<cut+1;i++) {
			int tmp=harr[i]-harr[i-1];//사이값 구하기 
			int tmp2=warr[i]-warr[i-1];//사이값 구하기 
			hMax=Math.max(hMax, tmp);
			wMax=Math.max(wMax, tmp2);	
		}
		System.out.println(hMax*wMax);
    }
	
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc =new Scanner(System.in);
//		
//		int w=sc.nextInt(); long h=sc.nextLong();
//		long cut=sc.nextLong();
//		String input[];
//		long[] warr=new long[(int) (cut+1)];
//		long[] harr=new long[(int) (cut+1)];
//		long hMax=0; long wMax=0;
//		for(long i=0;i<cut;i++) {
//			input=in.readLine().split(" ");
//			if(Long.parseLong(input[0])==0) {harr[(int) i]=Long.parseLong(input[1]);}//{0,0,4,10} -> {0,4,6} 사이값 구하기 
//			else warr[(int) i]=Long.parseLong(input[1]); //{0,2,3,8} -> {2,1,5} 사이값 구하기 
//		}
//		harr[(int) cut]=h; warr[(int) cut]=w;
////		for(long i:warr) {
////			System.out.pg(i+" ");
////		}
////		System.out.prlongln();
//		Arrays.sort(harr); 	Arrays.sort(warr);
//		hMax=harr[0];
//		wMax=warr[0];
//
//		for(long i=1;i<cut+1;i++) {
//			long tmp=harr[(int) i]-harr[(int) (i-1)];
//			long tmp2=warr[(int) i]-warr[(int) (i-1)];
//			hMax=Math.max(hMax, tmp);
//			wMax=Math.max(wMax, tmp2);	
//		}
////		System.out.println(hMax+" "+wMax);
//		System.out.println(hMax*wMax);
//	}

}
