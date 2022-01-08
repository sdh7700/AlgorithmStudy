package BOJ;
import java.util.Scanner;

public class BOJ_8972_미친아두이노 {
	// 1↙ 2↓ 3↘ 4← 6→ 7↖ 8↑ 9↗
	static int[] dr = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dc = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static int R, C, r, c;
	static char[][] map, temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					r = i;
					c = j;
				}
			}
		}

		String input = sc.next();
		for (int k = 0; k < input.length(); k++) {
			temp = new char[R][C];
			int dir = input.charAt(k) - '0';
			// 1. 먼저, 종수가 아두이노를 8가지 방향(수직,수평,대각선)으로 이동시키거나, 그 위치에 그대로 놔둔다.
			r = r + dr[dir];
			c = c + dc[dir];
			// 2. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되며, 종수는 게임을 지게 된다.
			if (map[r][c] == 'R') { // 종수와 충돌
				System.out.println("kraj " + (k + 1));
				return;
			}
			temp[r][c] = 'I';

			// 3. 미친 아두이노는 8가지 방향 중에서 종수의 아두이노와 가장 가까워 지는 방향으로 한 칸 이동한다.
			// 즉, 종수의 위치를 (r1,s1), 미친 아두이노의 위치를 (r2, s2)라고 했을 때, |r1-r2| + |s1-s2|가 가장 작아지는
			// 방향으로 이동한다.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'R') {
						int nr = i;
						int nc = j;
						if (nr < r) {
							nr++;
						} else if (nr > r) {
							nr--;
						}

						if (nc < c) {
							nc++;
						} else if (nc > c) {
							nc--;
						}

						// 4. 미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되고, 종수는 게임을 지게 된다.
						if (temp[nr][nc] == 'I') {
							System.out.println("kraj " + (k + 1));
							return;
						} else if (temp[nr][nc] == '\0') { // 빈칸
							temp[nr][nc] = 'R';
						}
						// 5. 2개 또는 그 이상의 미친 아두이노가 같은 칸에 있는 경우에는 큰 폭발이 일어나고, 그 칸에 있는 아두이노는 모두 파괴된다.
						else if (temp[nr][nc] == 'R') {
							temp[nr][nc] = 'X'; // 충돌
						}
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (temp[i][j] == '\0' || temp[i][j] == 'X') {
						map[i][j] = '.';
					} else {
						map[i][j] = temp[i][j];
					}
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}