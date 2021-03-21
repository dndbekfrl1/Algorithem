package Backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
7
3 10	/
5 20	
1 10
1 20	/
2 15	/
4 40
2 200	/ 


1 -> 2 -> 3 -> 4 ->
순서대로 탐색


 */
public class Q14501 {
	
	static int[][] timetable= new int [16][2];
	static int money=0;
	static int n;//퇴사 디데
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());

		String input[];
		for(int i=0;i<n;i++) {
			input=br.readLine().split(" ");
			timetable[i][0]=Integer.parseInt(input[0]);
			timetable[i][1]=Integer.parseInt(input[1]);
		}
		
		//근무 날짜와 페이
		Calculate(0,0);
		
		System.out.println(money);
	}

	private static void Calculate(int date, int m) {//
		int nextdate=timetable[date][0]+date;
		int pay = timetable[date][1]; // 급여  10
		
		
		System.out.println("근무날짜 "+nextdate+" 돈 "+m);
		if(date==n) {
			money=Math.max(m, money);
			return;
		}
		
		Calculate(date+1,m);
		
		if(nextdate<=n) {
			Calculate(nextdate,m+pay);
		}
	
		//date == 현재날 짜 		 1
		//nextdate == 다음 근무 날짜 4
		
		//System.out.println(nextdate);
//		if(timetable[date][0]==1) {
//			int pay = timetable[date][1]; // 급여  10
//			m=m+pay;
//			nextdate=date+1;
//			System.out.println("근무날짜 "+nextdate+" 돈 "+m);
//			Calculate(nextdate,m);
//			
//		}
//		else {
//			nextdate=timetable[date][0]+date; 
//			System.out.println("근무날짜 "+nextdate+" 돈 "+m);
//		
//		if(nextdate>n) {
//			money=Math.max(m, money);
//			return;
//		}else {
//			int pay = timetable[date][1]; // 급여  10
//			m=m+pay;
//			
//			Calculate(nextdate,m);
//		}
		// 1 3 10 (date, work, money)
		// 1 1 1
		
	//}

	}
}
