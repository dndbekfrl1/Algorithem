import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input=sc.next();
		
		String subtraction[] = input.split("-");
		
		int res = 0;
		int cnt=0;
		
		for(int i=0;i<subtraction.length;i++) {
			
			int sum =0;
			String plusArr[]=subtraction[i].split("\\+");
			for(int j=0;j<plusArr.length;j++) {
				sum+=Integer.parseInt(plusArr[j]);
			}
			if(cnt==0) {res=sum;}
			else {
				res=res-sum;
			}
			cnt+=1;
		}
		System.out.println(res);
	}
}