package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2229 {

	/*
	 * 최대한 가까운 요소와 조를 짜야함
	 * 점수의 차는 많이
	 * 10
	 * 2 5/ 7 1 /3 4 8/ 6 9 3
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int narr[]= new int[n+1];
		int dp[]= new int[n+1];
		String[] input=br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			narr[i]=Integer.parseInt(input[i-1]);
			int max=0; int min=10001;
			
			for(int j=i;j>0;j--) {
				//입력 받은 값 중에서 max값과 min값을 memozation 
				max=Math.max(max, narr[j]);
				min=Math.min(min, narr[j]);
				//dp의 최대값을 저장함
				dp[i]=Math.max(dp[i], max-min+dp[j-1]);
			}
		}
		System.out.println(dp[n]);
	}
}
