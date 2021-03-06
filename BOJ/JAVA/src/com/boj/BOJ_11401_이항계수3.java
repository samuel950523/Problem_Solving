package com.boj;

import java.util.Scanner;

public class BOJ_11401_이항계수3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long p = 1000000007;
		long ans = nCr(n, k, p);
		System.out.println(ans);
		sc.close();
	}

	private static long nCr(int n, int r, long p) {
		if (r == 0)
			return 1L;

		long[] fact = new long[n + 1];
		fact[0] = 1;
		// 팩토리얼 배열 채워주기
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i % p;
		}

		return (fact[n] * power(fact[r], p - 2, p) % p * power(fact[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}
}
