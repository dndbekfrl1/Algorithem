package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1012 {

	/*
	 * 유기농 배추 https://www.acmicpc.net/problem/1012 최소의 배추흰지렁이 마리 수를 출력한다.
	 * 
	 * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 배추가
	 * 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤
	 * N-1)가 주어진다.
	 * 
	 * 
	 * 2 10 8 17
	 * 
	 * bfs로 선 탐색하고 dfs 진행?
	 * 2667이랑 같은 문제네 
	 * 
	 */
	static int warm;
	static int M, N;

	static int dx[] = { -1, 0, 0, 1 };
	static int dy[] = { 0, 1, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			warm=0;
			int map[][]=new int[50][50];
			Boolean visit[][]= new Boolean[50][50];
			
			String line[]=br.readLine().split(" ");
			M=Integer.parseInt(line[0]); N=Integer.parseInt(line[1]); int K = Integer.parseInt(line[2]);
			//가로, 세로, 배추개수
			
			for(int j=0;j<K;j++) {
				line=br.readLine().split(" ");
				int x=Integer.parseInt(line[0]); int y=Integer.parseInt(line[1]);
				map[x][y]=1;
			}
			
			for(int x=0;x<M;x++) {
				for(int y=0;y<N;y++) {
					if(map[x][y]==1 && visit[x][y] ==null) {
						dfs(x,y,visit, map);
						System.out.println("탐색하는 좌표 "+x+" "+y);
						warm++;
					}
				}
				
			}
			System.out.println(warm);
		}
		
	}

	private static void dfs(int x, int y, Boolean visit[][], int map[][]) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
				if (map[nextX][nextY] == 1 && visit[nextX][nextY]==null) {
					dfs(nextX, nextY, visit, map);
				}
			}
		}

	}

}
