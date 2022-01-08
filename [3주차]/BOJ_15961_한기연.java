package BOJ;
import java.util.Scanner;

public class BOJ_15961_회전초밥 {
	static int N, d, k, c;
	static int[] arr, visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 접시수
		d = sc.nextInt(); // 가짓수
		k = sc.nextInt(); // 연속해서 먹는 접시의 수
		c = sc.nextInt(); // 쿠폰 번호
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		visit = new int[d + 1];

		int cnt = 0; // 먹은 가짓수
		for (int i = 0; i < k; i++) {
			if (visit[arr[i]] == 0) {
				cnt++;
			}
			visit[arr[i]]++;
		}

		int max = cnt;

		for (int i = 1; i < N; i++) {
			if (cnt >= max) {
				if (visit[c] == 0) {
					max = cnt + 1;
				} else {
					max = cnt;
				}
			}
			visit[arr[i - 1]]--;
			if (visit[arr[i - 1]] == 0) {
				cnt--;
			}
			if (visit[arr[(i + k - 1) % N]] == 0) {
				cnt++;
			}
			visit[arr[(i + k - 1) % N]]++;
		}

		System.out.println(max);

	}
}