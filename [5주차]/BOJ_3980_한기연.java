package BOJ;
import java.util.Scanner;

public class BOJ_3980_선발명단 {
	static int[][] s;
	static boolean[] visit;
	static int[] now;
	static int ret;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			s = new int[11][11];
			now = new int[11];
			visit = new boolean[11];
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					s[i][j] = sc.nextInt();
				}
			}
			ret = 0;
			solve(0, 0);
			System.out.println(ret);
		} // end of TC
	}

	private static void solve(int start, int depth) {
		if (depth == 11) {
			int sum = check();
			// System.out.println(depth + Arrays.toString(now) + " " + sum);
			ret = ret < sum ? sum : ret;
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (!visit[i] && s[i][depth] != 0) {// i 선수가 depth번 포지션
				visit[i] = true;
				now[depth] = i; // depth번 포지션에 i 선수
				solve(0, depth + 1);
				visit[i] = false;
			}
		}

	}

	private static int check() {
		int ret = 0;
		for (int i = 0; i < 11; i++) {
			ret += s[now[i]][i]; // now[i]번 선수는 i번 포지션
		}
		return ret;
	}
}