package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11724 {
/* 연결요소가... 머지 
 * https://www.acmicpc.net/problem/11724
 * 
 * 연결되지 않는 독립된 요소도 연결요소에 속함 
 * 
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
 * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
 * (1 ≤ u, v ≤ N, u ≠ v)
 *  같은 간선은 한 번만 주어진다.
 *  
6 5
1 2
2 5
5 1
3 4
4 6

6 2
3 4
4 2

3 1
1 2
//correct: 2
 * */
	static ArrayList<Integer>[] map;
	static int check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]);
		int V = Integer.parseInt(st[1]);
		int res =0;
		map = new ArrayList[N+1];
		check= new int[N+1];
		for(int i=1;i<N+1;i++) map[i]=new ArrayList<Integer>();
		
		int a,b;
		for(int i=0;i<V;i++) {
			st = br.readLine().split(" ");
			a=Integer.parseInt(st[0]);
			b=Integer.parseInt(st[1]);
			
			map[a].add(b);
			map[b].add(a);
		}
		
		for(int i=1;i<=N;i++) {
			if(check[i]==1)continue;
//			if(check[i]==1 || map[i].size()==0) continue;
				dfs(i);
				System.out.println("===");
				res++;
			
		}
		System.out.println(res);
		
	}
	
	private static void dfs(int a) {
		//System.out.println("!");
		check[a]=1;
		System.out.println("방문한 곳 : "+a);
		if(map[a].size()==0) return;
		for(int i=0;i<map[a].size();i++) {
			int nexta = map[a].get(i);
			if(check[nexta]==0) 
				dfs(nexta);
		}
	}

}
