package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13458 {

	
	/*
	 * 
	 * A ; 응시자 수
	 * B : 총감독 감시
	 * c : 부감독 감시
	 * 
	 *  총감독 : 1명, 부감독 : 여러명 
	 *  
	 *  1    //N: 시험장의 개수 
		1	 //A : 각 시험장의 응시생 
		1 1  //B , C
		
		
		
		3
		3 4 5
		2 2
		
		각 시험장에서 따로 구해야함 
		
		7
		
		4 5 5 
		4 1
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int a[]= new int[n];
		String input[]=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(input[i]);
		}
		input=br.readLine().split(" ");
		int b=Integer.parseInt(input[0]);
		int c=Integer.parseInt(input[1]);

		long cnt=0;
		
		for(int i=0;i<n;i++) {
			int tmp=b;
			int student = a[i]; //3
			
			while(true) {
				if(student<=0) break;
				
				if(b!=0) {
					if(b<student) {
						student-=b;
						cnt++;
						b=0;
						student-=c;
						cnt++;
					}else {
						student-=b;
						cnt++;
						b=0;
						
						if(student>0) {
							student-=c;
							cnt++;
						}
					}
				}else {

					if(student%c==0) {
						
						cnt+=(student/c);
						student=0;
					}else {
						
						cnt+=(student/c);
						student=0;
						
					}
				}
			}
			b=tmp;
		}
			System.out.println(cnt);
			
			
		}
		
	}

