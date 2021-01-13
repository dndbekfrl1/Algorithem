import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 */
public class Q1389 {
	static int max = 99999;
	static int res =101;
	static int map[][]= new int[101][101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] =br.readLine().split(" ");
		int user = Integer.parseInt(input[0]);
		int cnt = Integer.parseInt(input[1]);
		ArrayList<Integer> resArr = new ArrayList<>();
		
		for(int i=1;i<=user;i++) {
			for(int j=1;j<=user;j++) {
				if(i==j) {
					map[i][j]=map[j][i]=0;
				}
				map[i][j]=map[j][i]=999999;
            }
		} 
		
		for(int i=0;i<cnt;i++) {
			input=br.readLine().split(" ");
			int usr = Integer.parseInt(input[0]);
			int frnd=Integer.parseInt(input[1]);
			
			map[usr][frnd]=map[frnd][usr]=1;
		}
		
		
		
		for(int mid=1;mid<=user;mid++) {
			for(int start=1;start<=user;start++) {
				for(int end=1;end<=user;end++) {
					if(map[start][end]> map[start][mid]+map[mid][end]){
                        map[start][end]=map[start][mid]+map[mid][end];
                    }
				}
			}
		}
		
		for(int i=1;i<=user;i++) {
			int tmp=0;
			for(int j=1;j<=user;j++) {
				tmp+=map[i][j];
			}
			if(max>tmp) {
				max=tmp;
				res=i;
			}
		}
		
		System.out.println(res);
		
	}
}
