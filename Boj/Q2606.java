package Backjun_self;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2606 {
	static int cnt=0, com, line;
	static int[][] map;
	static boolean[]visited;

	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		com=Integer.parseInt(br.readLine());
		line=Integer.parseInt(br.readLine());
		map=new int[com+1][com+1];
		visited= new boolean[com+1];
		String[] input; int c1,c2;
		
		for(int i=0;i<line;i++) {
			input=br.readLine().split(" ");
			c1 =Integer.parseInt(input[0]);//컴퓨터 넘버
			c2 =Integer.parseInt(input[1]);//연결된컴퓨터 넘버
			map[c1][c2]=1;
			map[c2][c1]=1;
		}
	
		Count(1);
		
		System.out.println(cnt);
	}
	/*
	 *  1 2 3 4 5 6 7
	 * 1  1     1
	 * 2    1
	 * 3
	 * 4             1
	 * 5  1        1   
	 * 6
	 * 7
	 */
	
	private static void Count(int c1) {
		
		visited[c1]=true;
		
		for(int i=1;i<=com;i++) {
			if(map[c1][i]==1&&visited[i]==false) {
				Count(i);
				cnt++;
			}
		}	
		
	}

}
