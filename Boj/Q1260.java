package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * DfS BFS 기본문제 
 */
public class Q1260 {

	static int N, M, V;
	static int ad[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		// 4, 5, 1
		ad = new int[N + 1][N + 1];
		boolean visit[] = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			input=br.readLine().split(" ");
			int t1 = Integer.parseInt(input[0]);
			int t2 = Integer.parseInt(input[1]);

			ad[t1][t2] = ad[t2][t1] = 1;
		}

		// dFS
		dfs(V,visit);
		for(int i=0;i<visit.length;i++) visit[i]=false;
		System.out.println();
		//bfs
		bfs(V,visit);

	}

	public static void dfs(int V,boolean visit[]) {
		visit[V] = true;
		System.out.print(V + " ");

		for (int j = 1; j < N + 1; j++) {
			if (ad[V][j] == 1 && visit[j] == false) {
				dfs(j, visit);
			}
		}
	}
	
	public static void bfs(int V,boolean visit[]) {
		Queue<Integer> q = new LinkedList<>();
		int n=ad.length-1;
		q.add(V);
		visit[V]=true;
		
		while(!q.isEmpty()) {
			V=q.poll();
			System.out.print(V+" ");
			for (int i = 1; i <= n; i++) {
				if (ad[V][i] == 1 && !visit[i]) {
					q.add(i); 
					visit[i] = true; 
				} 
			}

		}
		
	}

}
