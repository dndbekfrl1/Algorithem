public class Q1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int zero=0; int one=0;
			int n = Integer.parseInt(br.readLine());
			if(n==0) {System.out.println(1+" "+0); }
			else if(n==1) {System.out.println(0+" "+1); }
			else {
			int fibo1[]=new int[n+1];
			int fibo0[]= new int[n+1];
			
			fibo0[0]=1;fibo0[1]=0;
			fibo1[0]=0; fibo1[1]=1;
			
				for(int j=2;j<=n;j++) {
					fibo0[j]=fibo0[j-1]+fibo0[j-2];
					fibo1[j]=fibo1[j-1]+fibo1[j-2];
				}
				System.out.println(fibo0[n]+" "+fibo1[n]);
			}
		}
	}
}
