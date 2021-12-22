import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_level4_미로탈출_한기연 {
	public static void main(String[] args) {
		System.out.println(solution(3, 1, 3, new int[][] { { 1, 2, 2 }, { 3, 2, 3 } }, new int[] { 2 }));
		System.out.println(solution(4, 1, 4, new int[][] { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } }, new int[] { 2, 3 }));
	}

	static final int INF = Integer.MAX_VALUE;

	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				graph[i][j] = INF;
			}
		}

		for (int[] is : roads) {
			// u에서 v로 가는데 w의 비용이 든다.
			int u = is[0];
			int v = is[1];
			int w = is[2];
			if (graph[u][v] > w) {
				graph[u][v] = w;
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[][] visit = new boolean[n + 1][1 << traps.length];
		pq.add(new int[] { 0, start, 0 });
		int answer = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			int cost = pq.peek()[0];
			int curr = pq.peek()[1];
			int state = pq.poll()[2];
			if (curr == end) {
				if (cost < answer)
					answer = cost;
				continue;
			}
			if (visit[curr][state])
				continue;
			visit[curr][state] = true;

			boolean currTrap = false;
			Set<Integer> set = new HashSet<>();
			for (int t = 0; t < traps.length; t++) {
				int bit = 1 << t;
				if ((bit & state) != 0) {
					if (traps[t] == curr)
						state &= ~bit;
					else
						set.add(traps[t]);
				} else {
					if (traps[t] == curr) {
						state |= bit;
						set.add(traps[t]);
						currTrap = true;
					}
				}
			}

			for (int next = 1; next <= n; next++) {
				if (curr == next)
					continue;
				boolean nextTrap = set.contains(next) ? true : false;
				if (currTrap == nextTrap) {
					if (graph[curr][next] != INF) {
						pq.add(new int[] { cost + graph[curr][next], next, state });
					}
				} else {
					if (graph[next][curr] != INF) {
						pq.add(new int[] { cost + graph[next][curr], next, state });
					}
				}
			}
		}
		return answer;
	}
}