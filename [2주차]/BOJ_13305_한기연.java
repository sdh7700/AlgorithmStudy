import java.util.Scanner;

public class BOJ_13305_한기연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] distence = new long[N - 1];
		long[] cost = new long[N];

		for (int i = 0; i < N - 1; i++) {
			distence[i] = sc.nextLong();
		}
		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextLong();
		}

		long ans = 0;
		long min = 1000000001;
		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < min) { // 현재 주유소가 이전 주유소보다 싸다
				min = cost[i];
			}
			ans += min * distence[i];
		}

		System.out.println(ans);
	}
}
