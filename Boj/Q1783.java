package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 병든 나이트가 N × M 크기 체스판의 가장 왼쪽아래 칸
2칸 위로, 1칸 오른쪽 [-2][1]
1칸 위로, 2칸 오른쪽 [-1][2]
1칸 아래로, 2칸 오른쪽 [1][2]
2칸 아래로, 1칸 오른쪽 [2][1]
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (1,1) (1,2)
*방문한 칸의 수를 최대로
*
*이동 방법을 모두 한 번씩 사용해야 한다.
*이동 횟수가 4번보다 적은 경우(방문한 칸이 5개 미만)에는 이동 방법에 대한 제약이 없다.
*/

/*
 * 이동 수가 한정적일떄는
 * 이동 규칙을 찾을 수 가있음 
 * */
public class Q1783 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		int n=Integer.parseInt(input[0]); //세로 
		int m=Integer.parseInt(input[1]);
		
		if(n==1) {
			System.out.println(1);
		}
		else if(n==2) {
			System.out.println(Math.min(4, (m+1)/2));
		}
		else if(n>=3) {
			if(m<=6) {
				System.out.println(Math.min(4, m));
			}else {
				System.out.println(m-2);
			}
		}
		
	}

}
