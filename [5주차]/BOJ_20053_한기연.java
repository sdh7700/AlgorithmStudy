package BOJ;
import java.util.Scanner;

public class BOJ_20053_최소최대2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				max = max < x ? x : max;
				min = min > x ? x : min;
			}
			System.out.println(min + " " + max);
		}
	}
}