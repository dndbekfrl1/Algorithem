package Backjun;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] B = new int[m];
		for (int i = 0; i < m; i++) {
			B[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int result = 0;
		for (int i = 0; i < m; i++) {

			int l, r, mid = 0;
			l = 0;
			r = n - 1;

			while (l <= r) {
				mid = (l + r) / 2;

				if (B[i] >= A[mid]) {
					l = mid + 1;
					if (B[i] != A[mid])
						result = 0;
					else
						result = 1;
				}

				else
					r = mid - 1;
			}
			System.out.println(result);
		}

	}
}
