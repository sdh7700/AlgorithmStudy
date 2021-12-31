import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_level2_거리두기확인하기_한기연 {
	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" }, { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" }, { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(places)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int tc = 0; tc < places.length; tc++) {
			boolean flag = true;
			for (int i = 0; i < 5 && flag; i++) {
				for (int j = 0; j < 5 && flag; j++) {
					if (places[tc][i].charAt(j) == 'P') {
						flag = bfs(places[tc], i, j);
					}
				}
			}
			answer[tc] = flag ? 1 : 0;
		}
		return answer;
	}

	private static boolean bfs(String[] map, int i, int j) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[5][5];

		q.add(new int[] { i, j });
		visit[i][j] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (getDistence(i, j, now[0], now[1]) == 2) {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (isRange(nr, nc) && !visit[nr][nc]) {
					if (map[nr].charAt(nc) == 'P') {
						return false;
					} else if (map[nr].charAt(nc) == 'O') {
						q.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}
		}
		return true;

	}

	private static boolean isRange(int r, int c) {
		return 0 <= r && r < 5 && 0 <= c && c < 5;
	}

	private static int getDistence(int i, int j, int r, int c) {
		return Math.abs(i - r) + Math.abs(j - c);
	}

}