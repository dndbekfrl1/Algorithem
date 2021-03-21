package Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q4963 {
/*
 * 가로, 세로 또는 대각선으로 연결되어 있는 사각형
 * 
 *  너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수
 *  1은 땅, 0은 바다이
 *  입력의 마지막 줄에는 0이 두 개 주어진다.
 *  
 *  각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
 *  
 *  아 .. 왜 틀렸지?? 
 *  ㄴBUfferedreader, BufferedREader, StringBuilder을 사용해야 문제가 요구하는 출력이 나옴  
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0


0 0 0
0 0 0 
0 0 0
 */
	
	static int map[][] = new int[50][50];
	static int direc[][] = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,-1},{-1,1}};
	static int W,H;
	static int check[][];
	static ArrayList<Integer>answer = new ArrayList<Integer>();//[100]
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sbr = new StringBuilder();
		while(true) {
			int res=0;
			String input[] = br.readLine().split(" ");
			W = Integer.parseInt(input[0]);
			H = Integer.parseInt(input[1]);
			if(W==0 && H==0) {
				break;
			}
			
			map = new int[W][H];
			check = new int[W][H];
			for(int i=0;i<H;i++) {
				String line[]=br.readLine().split(" ");
				for(int j=0; j<W;j++) 
					map[j][i]=Integer.parseInt(line[j]);
			}
			
			for(int i=0;i<H;i++) {
				for(int j=0; j<W;j++) {
					if(map[j][i]==1 && check[j][i]==0) {
						dfs(j,i);
						res++;
						//System.out.println("==");
					}
				}
			}
			
			sbr.append(res+"\n");	
			//System.out.println(res);
		
//			answer.add(index, res);
//			index++;
			//System.out.println("저장 ");
		}
		bw.write(sbr.toString());
		bw.close();
		br.close();
	}
	
	private static void dfs(int w, int h) {
		//System.out.println("방문한 곳 " +w+" "+h);
		check[w][h]=1;
		for(int i=0;i<direc.length;i++) {
			int nextw=direc[i][0] +w;
			int nexth=direc[i][1] +h;
			
				if(0<=nextw&&nextw<W && 0<=nexth && nexth<H) {
					if(map[nextw][nexth]==1) 
					if(check[nextw][nexth]==0) 
						dfs(nextw,nexth);
				}
		}
	}

}
