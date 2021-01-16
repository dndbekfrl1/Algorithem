
public class Q1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int cnt =0;
		
		int dp[]= new int[1000001];
		
		dp[1]=0;
		for(int i=2;i<=x;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i]=Math.min(dp[i/2]+1, dp[i]);
			if(i%3==0) dp[i]=Math.min(dp[i/3]+1, dp[i]);
		}
		System.out.println(dp[x]);
    }
}