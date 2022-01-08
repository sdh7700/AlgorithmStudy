package BOJ;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_6118_숨바꼭질 {
	static int N, M;
	static List<Integer>[] map;
	static int[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new List[N + 1];
		for (int i = 0; i < N; i++) {
			map[i + 1] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a].add(b);
			map[b].add(a);
		}

		Queue<int[]> q = new LinkedList<>();
		visit = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			visit[i] = -1;
		}
		visit[1] = 0;
		q.add(new int[] { 1, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i : map[now[0]]) {
				if (visit[i] == -1) {
					visit[i] = now[1] + 1;
					q.add(new int[] { i, now[1] + 1 });
				}
			}
		}
		int num = -1;
		int distence = -1;
		int size = -1;

		for (int i = 0; i < N; i++) {
			//System.out.println((i + 1) + "->" + visit[i + 1]);
			if (distence < visit[i + 1]) {
				distence = visit[i + 1];
				num = i + 1;
				size = 1;
			} else if (distence == visit[i + 1]) {
				size++;
			}
		}

		System.out.println(num + " " + distence + " " + size);

	}
}