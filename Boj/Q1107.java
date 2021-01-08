import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1107 {

	static int[] btnArr;
	static int curChanner=100;
	static int channer=0;
	static int channerLength=1;
	static int min = 0; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		channer = Integer.parseInt(br.readLine());
		btnArr = new int[10];
		//채널이 0번보다 클 경우 
		if(channer > 0) {
			channerLength = Integer.toString(channer).split("").length;
		}
		int btnNum = Integer.parseInt(br.readLine());
		//고장난 버튼이 0이면 아래 작업을 수행하지 않는다. 	
		if(btnNum>0){
			String input[] = br.readLine().split(" ");
			for(int i=0;i<btnNum;i++) btnArr[Integer.parseInt(input[i])]=1;
		}
		min = Math.abs(channer - curChanner);

		for(int i=0;i<10;i++) {
			if(btnArr[i]==1) continue;
			createNumber(1,i);
		}
		System.out.println(min);
	}
	private static void createNumber (int length, int ch) {
		if(channerLength+1<length) {
			return;
		}
		int abs = Math.abs(channer-ch);
		min = Math.min(min, length+abs);
		for(int i=0;i<10;i++) {
			if(btnArr[i]!=1) {
				createNumber(length+1,(ch*10)+i);
			}
		}
	}
}	
