package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q2583 {

	/*
	 * 영역 구하기
	 */
	static int map[][] = new int[101][101], m, n, k;
	static boolean visited[][] = new boolean[101][101];
	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { 1, -1, 0, 0 };
	static int pointcnt = 0;
	static ArrayList<Integer> area=new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);// m*n 5
		m = Integer.parseInt(input[1]);// 7
		k = Integer.parseInt(input[2]);// 직사각형

		// 상자 그리기
		for(int i=0;i<k;i++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int x2 = Integer.parseInt(input[2]);
			int y1 = Integer.parseInt(input[1]);
			int y2 = Integer.parseInt(input[3]);
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					map[x][y] = 1;
				}
			}
		}
		

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (map[x][y] == 0 && visited[x][y]==false) {
					pointcnt=0;
					dfs(x, y);
					area.add(pointcnt);
				}
			}
		}
		int [] arr= new int[area.size()];
		for(int i=0;i<area.size();i++) {
			arr[i]=area.get(i);
		}
		Arrays.parallelSort(arr);
		System.out.println(arr.length);
		for(int i=0;i<area.size();i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		pointcnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
