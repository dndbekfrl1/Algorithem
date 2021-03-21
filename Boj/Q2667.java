package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Q2667 {
/*
 * 단지 번호 붙이기 
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */
	
	private static int dx[] = {0,0,1,-1};
    private static int dy[] = {1,-1,0,0};
    private static int[] aparts = new int[26*26];
    private static int n;
    private static int apartNum = 0; //아파트 단지 번호의 수
    private static boolean[][] visited = new boolean[26][26]; //방문여부
    private static int[][] map = new int[26][26]; //지도
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			String [] input = br.readLine().split("");
			for(int j=1;j<=n;j++) {
				map[i][j]= Integer.parseInt(input[j-1]);//0110100
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1 &&!visited[i][j]) {
					apartNum++;
					dfs(i,j);
				}
			}
		}
		Arrays.parallelSort(aparts);
		System.out.println(apartNum);
		
		for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{               
                System.out.println(aparts[i]);
            }
        }
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y]=true;
		aparts[apartNum]++;
		
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			
			if(nx>=1&&ny>=1&&nx<=n&&ny<=n) {
				if(map[nx][ny]==1 &&!visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}

}
//	private static int N,cnt;
//	static int arr[][];
//	static boolean visited[][];
//	static int dx[] = {-1,1,0,0};
//    static int dy[] = {0,0,-1,1};
//    static ArrayList<Integer> al = new ArrayList();
//    
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N=Integer.parseInt(br.readLine());
//		arr=new int[N+1][N+1];
//		for(int i=1;i<N+1;i++) {
//			String [] input = br.readLine().split("");
//			for(int j=1;j<N;j++) {
//				arr[i][j]= Integer.parseInt(input[j-1]);//0110100
//			}
//		}
//		
//		visited=new boolean[N+1][N+1];
//		
//		
//		for(int i=1;i<N+1;i++) {
//			for(int j=1;j<N+1;j++) {
//				if(arr[i][j]==1 &&!visited[i][j]) {
//					cnt=1;
//					System.out.println(cnt);
//					dfs(i,j);
//					//al.add(cnt);
//				}
//			}
//		}
//	//	System.out.println(al.size());
//		
//	}
//	
//	private static void dfs(int i,int j) {
//		visited[i][j]=true;
//		System.out.println("i:"+i+"j:"+j);
//		for(int m=0;m<4;i++) {
//			System.out.println("m:"+m);
//			System.out.println("n:"+N);
//			int nx=i+dx[m];
//			int ny=j+dy[m];
//			/*
//			 * 	static int dx[] = {-1,1,0,0};
//    		 *	static int dy[] = {0,0,-1,1};
//			 */
//			System.out.println("nx :" +nx+" ny:"+ny);
//			 if(nx >=1 && ny >=1 && nx <=N && ny <=N){
//	               if(arr[nx][ny] == 1 && !visited[nx][ny]){
//					System.out.println(nx+" "+ny);
//					dfs(nx,ny);
//				}
//			}
//		}
//		
//		
//	}

	
	
	

