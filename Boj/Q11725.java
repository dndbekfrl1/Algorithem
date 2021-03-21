package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {

	/*
	 * 
	 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
	 * 
	 *  노드의 개수 N (2 ≤ N ≤ 100,000)
	 *  둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점
	 *  
	 *  왜 시간초과가 나
	 *  아... key 값의 부모를 찾으면 시간초과가 나고 
	 *  2 ~ N의 부모를 저장하는 배열을 만들면 시간초과가 안남 
	 *  
7
1 6
6 3
3 5
4 1
2 4
4 7
	 */
	//static ArrayList<Integer> map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> map[]= new ArrayList[N+1];
		for(int i=1; i<=N;i++) { map[i] = new ArrayList<Integer>();}
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken()); int n2 = Integer.parseInt(st.nextToken());
			map[n1].add(n2); map[n2].add(n1);
		}
		
		
		int[] parents = new int[N+1];
		
			int check[]=new int [N+1];
			int start=1;
			int parent=0;
			search2(start,parent,parents,check,map);
			//search(1,check,key,flag, map);
		for(int j=2;j<=N; j++) 
			System.out.println(parents[j]);
		
	}
	private static void search2(int start,int parent, int[] parents, int[] check, ArrayList<Integer> map[]) {
		
		check[start]=1;
		parents[start]=parent;
		System.out.println("현재 n 값 : "+ start+" parent:"+parent);
		for(int i=0;i<map[start].size();i++) {
			int next = map[start].get(i);
			if(next!=parent) {
				search2(next,start,parents,check,map);
				/*
//				parents[parent]=next;
//				return;
//			}
//			if(check[next]!=1) search2(next,parents,check,map);
		*/
			}
		}
	}
	private static void search(int n, int[] check, int key, boolean flag, ArrayList<Integer> map[]) {
		//System.out.println("현재 n 값 : "+ n);
		check[n]=1;
		if(flag==true) return;
		for(int i=0;i<map[n].size();i++) {
			int next = map[n].get(i);
			if(next==key) {
				flag=true;
				System.out.println(n);
				return;
			}
			if(check[next]!=1) search(next,check,key,flag, map);
		}
	}	

}
