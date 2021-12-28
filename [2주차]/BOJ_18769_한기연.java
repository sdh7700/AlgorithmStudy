import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_18769_�ѱ⿬ {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int R = sc.nextInt();
			int C = sc.nextInt();

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C - 1; j++) {
					int w = sc.nextInt();
					int curr = (i * C) + j;
					pq.add(new int[] { curr, curr + 1, w });
				}
			}
			for (int i = 0; i < R - 1; i++) {
				for (int j = 0; j < C; j++) {
					int w = sc.nextInt();
					int curr = (i * C) + j;
					pq.add(new int[] { curr, curr + C, w });
				}
			}

			parent = new int[R * C];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}

			int answer = 0;

			while (!pq.isEmpty()) {
				int[] curr = pq.poll();
				if (check(curr[0], curr[1]))
					continue;
				union(curr[0], curr[1]);
				answer += curr[2];
			}

			System.out.println(answer);

		}
	}

	public static boolean check(int x, int y) {
		x = find(x);
		y = find(y);
		return x == y;
	}

	private static void union(int a, int b) {
		int x = find(a);
		int y = find(b);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

}