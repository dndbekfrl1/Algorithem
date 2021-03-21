package Backjun;

import java.util.Scanner;

public class Q1072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long X, Y, Z;
		long tempZ = 0;
		long max = 1000000000;
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		Z = 100 * Y / X;

		long l, r, mid;
		long result = -1;
		mid = 0;
		l = 0;
		r = max;

		if (Z >= 99) {
			System.out.println(result);
		} else {
			while (l <= r) {
				mid = (l + r) / 2;
				tempZ = 100l * (Y + mid) / (X + mid);

				if (Z < tempZ) {
					r = mid - 1;

				} else {
					l = mid + 1;
				}
			}
			result=l;
			System.out.println(result);
		}
	}

}
