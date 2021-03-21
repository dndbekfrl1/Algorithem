package Backjun;

import java.util.Scanner;

public class Q5217 {
/*
 *
 * 
 1보다 크거나 같고 12보다 작거나 같은 자연수 n이 주어졌을 때, 합이 n이 되는 두 자연수의 쌍을 찾는 프로그램을 작성하시오.
 1<=x<=12
예를 들어, 5가 주어진 경우 가능한 쌍은 1,4와 2,3이 있다. 두 수는 항상 달라야 한다. 즉, 3,3은 올바른 쌍이 아니다. 또, 첫 번째 수가 두 번째 수보다 작아야 한다.

출력하는 쌍은 항상 사전순으로 출력해야 한다. 즉, 각 쌍의 작은 수로 비교를 해야 한다. 예를 들어 1,5는 2,4보다 사전순으로 앞선다.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		int inputArr[]=new int[input];
		int[] arr= {1,2,3,4,5,6,7,8,9,10,11,12};
		for(int i=0;i<input;i++) {
			inputArr[i]=sc.nextInt(); //2 3 4 5 
		}
		
		for(int i=0;i<input;i++) {
			String answer = "";
				for(int k=0;k<12;k++) {
					int a=arr[k];
					for(int m=k+1;m<12;m++) {
						int b=arr[m];
						int tmp=a+b;
						if(tmp==inputArr[i]) {
							if(answer.isEmpty()) {answer+=a+" "+b;}
							else {answer+=", "+a+" "+b;}
						}
					}
				}
			System.out.println("Pairs for "+inputArr[i]+": "+answer);
		}
	}

}
