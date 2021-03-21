package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
	/*
	 * 적록색약 https://www.acmicpc.net/problem/10026 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를
	 * 구하는 프로그램을 작성하시오. RRRBB GGBBB BBBRR BBRRR RRRRR
	 * 
	 * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100) 5 RRRBB GGBBB BBBRR BBRRR RRRRR
	 */
	// R = 1 G = 2 B = 3
	static int map[][] = new int[100][100];
	static int N;
	static boolean visited[][] = new boolean[100][100];
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String line[];
		int res1=0,res2=0;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split("");
			for (int j = 0; j < N; j++) {

				if (line[j].equals("R")) {
					map[i][j] = 1;
				} else if (line[j].equals("G")) {
					map[i][j] = 2;
				} else
					map[i][j] = 3;
				// System.out.println(line[j]+" "+map[i][j]);
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					dfs(x, y);
					//System.out.println("===");
					res1++;
				}
			}
		}
	
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				visited[x][y]=false;
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					dfs2(x, y);
					//System.out.println("===");
					res2++;
				}
			}
		}
		
		System.out.println(res1);
		System.out.println(res2);

	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		int color = map[x][y];
		
		//System.out.println("위치  "+x+"  "+y);
		//		System.out.println("위치  "+nextx+"  "+nexty);
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			
			if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && visited[nextx][nexty]==false) {
				int nextcolor = map[nextx][nexty];
				if(nextcolor==color) {
					//System.out.println("색 "+color+"  "+ nextcolor);
					dfs(nextx,nexty);
				}
				
			}
		}

	}

	private static void dfs2(int x, int y) {
		visited[x][y] = true;
		int color = map[x][y];
		
		//System.out.println("위치  "+x+"  "+y);
		//		System.out.println("위치  "+nextx+"  "+nexty);
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];
			
			if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && visited[nextx][nexty]==false) {
				int nextcolor = map[nextx][nexty];
				
				// 빨강초록인접 구역
				if (nextcolor== 2 && color==1 || color==2 &&nextcolor==1) {
					//System.out.println("색 "+color+"  "+ nextcolor);
					dfs2(nextx, nexty);
				}else if(nextcolor==color) {
					//System.out.println("색 "+color+"  "+ nextcolor);
					dfs2(nextx,nexty);
				}
				
			}
		}

	}

	/*
	 * RRRBB GGBBB BBBRR BBRRR RRRRR
	 */
}
