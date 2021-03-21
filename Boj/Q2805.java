package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 String[] input=in.readLine().split(" ");
		 int N=Integer.parseInt(input[0]);
		 int M=Integer.parseInt(input[1]);
		 int Narr[]=new int[N];
		 input=in.readLine().split(" ");
		 for(int i=0;i<N;i++)
			 Narr[i]=Integer.parseInt(input[i]);
		 Arrays.sort(Narr);
		 //Narr 정렬 
		 
		 int Max=Narr.length-1;
		 int Min=0;
		 int mid=0;
		 int cnt=0;
		 //10 15 17 20
		 //   mid
		
		 while(Min<=Max) {
			mid=(Min+Max)/2;
			System.out.println("mid값: "+Narr[mid]);
			int get=0;
			for(int i=0;i<=mid;i++) {
				get+=Narr[i]-Narr[mid];//얻는 나무의 길이 
			}
			//7
			if(get>=M) Max=mid-1;
			else Min=mid+1;
		 }
		 System.out.println(Min);
	}

}
