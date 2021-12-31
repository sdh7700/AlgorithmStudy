import java.util.Scanner;

public class BOJ_13908_�ѱ⿬ {
	static int N, M, ans;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[10];
		for (int i = 0; i < M; i++) {
			visit[sc.nextInt()] = true;
		}
		ans = 0;
		solve(0, 0);
		System.out.println(ans);
	}

	private static void solve(int depth, int cnt) {
		if (depth == N) {
			if (cnt == M) {
				ans++;
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visit[i]) {
				visit[i] = false;
				solve(depth + 1, cnt + 1);
				visit[i] = true;
			} else {
				solve(depth + 1, cnt);
			}
		}
	}
}