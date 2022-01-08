package BOJ;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5427_불 {
	static int W, H, ans;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> me, fire;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			W = sc.nextInt();
			H = sc.nextInt();
			map = new char[H][W];
			me = new LinkedList<>();
			fire = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {// 상근이의 시작 위치
						me.add(new int[] { i, j, 0 });
						map[i][j] = '.';// 맵을 빈공간으로 처리
					} else if (map[i][j] == '*') { // 불의 위치
						fire.add(new int[] { i, j });
					}
				}
			}
			ans = 0;
			BFS();
			if (ans != 0) {
				System.out.println(ans);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

	private static void BFS() {
		visit = new boolean[H][W];
		while (!me.isEmpty()) {
			fire = moveFire();
			me = moveMe();
		}
	}

	private static Queue<int[]> moveMe() {
		LinkedList<int[]> tempList = new LinkedList<>();
		while (!me.isEmpty()) {
			int[] now = me.poll();
			for (int k = 0; k < 4; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (!isRange(nr, nc)) { // 상하좌우가 맵을 벗어난 경우(즉, 탈출)
					ans = now[2] + 1;
					return new LinkedList<>();
				} else {
					if (map[nr][nc] == '.' && !visit[nr][nc]) {
						tempList.add(new int[] { nr, nc, now[2] + 1 });
						visit[nr][nc] = true;
					}
				}
			}
		}
		return tempList;
	}

	private static Queue<int[]> moveFire() {
		LinkedList<int[]> tempList = new LinkedList<>();
		while (!fire.isEmpty()) {
			int[] now = fire.poll();
			for (int k = 0; k < 4; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (isRange(nr, nc) && map[nr][nc] == '.') {
					tempList.add(new int[] { nr, nc });
					map[nr][nc] = '*';
				}
			}
		}
		return tempList;
	}

	private static boolean isRange(int nr, int nc) {
		return 0 <= nr && nr < H && 0 <= nc && nc < W;
	}
}