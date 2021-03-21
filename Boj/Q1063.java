package Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1063 {
	/*
	 * A ~ H 1 ~ 8
	 * 킹과 돌의 마지막 위치 킹은 주변 8칸으로 이동 가능 돌+1
	 * 
	 *  R : 한 칸 오른쪽으로
	 *  L : 한 칸 왼쪽으로 
	 *  B : 한 칸 아래로
	 *  T : 한 칸 위로 
	 *  RT : 오른쪽 위 대각선으로 
	 *  LT : 왼쪽 위 대각선으로 
	 *  RB : 오른쪽 아래 대각선으로 
	 *  LB : 왼쪽 아래 대각선으로
	 * 
	 * A1 
	 * A2
	 * 5 B L LB RB LT
	 *  
	 */
	static int x, y;
	static int stoneX, stoneY, kingX, kingY;

	public static void move(String m) {
		switch (m) {
		case "R":
			y = 0;
			x = 1;
			break;
		case "L":
			y = 0;
			x = -1;
			break;
		case "B":
			y = -1;
			x = 0;
			break;
		case "T":
			y = 1;
			x = 0;
			break;
		case "RT":
			y = 1;
			x = 1;
			break;
		case "LT":
			y = 1;
			x = -1;
			break;
		case "RB":
			y = -1;
			x = 1;
			break;
		case "LB":
			y = -1;
			x = -1;
			break;
		}
	}
	public static int returnNum(String x) {
		switch (x) {
		case "A":
			return 1;
		case "B":
			return 2;
		case "C":
			return 3;
		case "D":
			return 4;
		case "E":
			return 5;
		case "F":
			return 6;
		case "G":
			return 7;
		case "H":
			return 8;
		}
		return -1;
	}
	public static String returnChar(int x) {
		switch (x) {
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		String[] stone = input[1].split("");String[] king = input[0].split("");
		kingX=returnNum(king[0]);
		kingY=Integer.parseInt(king[1]);
		stoneX=returnNum(stone[0]); 
		stoneY=Integer.parseInt(stone[1]);		
		int num=Integer.parseInt(input[2]);
		for (int i = 0; i < num; i++) {
			String line = br.readLine();
			move(line);
			Go();
		}
		
		String s=returnChar(stoneX)+stoneY;
		String k=returnChar(kingX)+kingY;
		System.out.println(k);
		System.out.println(s);
		
		//System.out.println(stoneX+" "+ stoneY+" "+kingX+" "+ kingY);
	}

	private static void Go() {
		if ((kingX + x) < 1 || (kingX + x) > 8 || (kingY + y) < 1 || (kingY + y) > 8) {
			return;
		} else {
			if ((kingX + x) == stoneX && (kingY + y) == stoneY) {
				if((stoneX + x) < 1 || (stoneX + x) > 8 || (stoneY + y) < 1 || (stoneY + y) > 8){
					return;
				}else {
					stoneX += x;
					stoneY += y;
				}
			
			}
			kingX += x;
			kingY += y;
		}
		return;
//		String s=returnChar(stoneX)+stoneY;
//		String k=returnChar(kingX)+kingY;
//		System.out.println(s+" "+k);
	}
}
