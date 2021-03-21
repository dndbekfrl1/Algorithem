package Backjun_self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2178 {
	
	
	
	/*
	 * 미로찾기 4 6 101111 101010 101011 111011
	 */
	
	static int n, m;
	static int map[][] = new int[101][101];
	static int xd[] = { -1, 1, 0, 0 }, yd[] = { 0, 0, -1, 1 };
	static boolean visited[][] = new boolean[101][101];
	static int res = 101;
	static int cnt=0;
	static int check[][]=new int[101][101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		for (int i = 0; i < n; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (Integer.parseInt(input[j]) == 1)
					map[i][j] = 1;
			}
		}

		bfs(0, 0);
		System.out.println(check[n-1][m-1]+1);
	}

	private static void bfs(int x, int y) {
	
		Queue<Dot> q = new LinkedList<>(); //큐 생성
		q.add(new Dot(x,y)); // 큐에 좌표 push 
		visited[x][y] = true; // 좌표 방문 표시 
		
		while (!q.isEmpty()) {
			Dot d = q.poll(); // pull 
			
			for (int i = 0; i < 4; i++) {
				int nextx = d.x + xd[i]; //다음 방문할 좌표 
				int nexty = d.y + yd[i];
				
				
				if (nextx < n && nexty < m && nextx >= 0 && nexty >= 0 && map[nextx][nexty] == 1
						&& visited[nextx][nexty] == false) {
					
					q.add(new Dot(nextx,nexty)); //방문하지 않은 좌표 push 
					check[nextx][nexty]=check[d.x][d.y]+1;
					visited[nextx][nexty]=true; //좌표 방문 표시 
					System.out.println("현재위"+nextx+" "+nexty+"이동한 거리:"+check[nextx][nexty]);
					
				}
			}

		}
	}
	
	
	
}
	class Dot {
	    int x;
	    int y;
	 
	    Dot(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}

	




