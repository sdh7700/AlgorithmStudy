package BOJ;
import java.util.Scanner;

public class BOJ_9094_수학적호기심{
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			m = sc.nextInt();
			int ans = 0;
			for (int i = 1; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (check(i, j)) {
						//System.out.println("i=" + i + ", j=" + j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static boolean check(int a, int b) {
		double ret = ((a * a) + (b * b) + m);
		ret /= (a * b);
		return ret == (int) ret;
	}
}