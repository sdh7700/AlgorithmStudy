import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_20056_ÇÑ±â¿¬ {
	// 0¡è 1¢Ö 2¡æ 3¢Ù 4¡é 5¢× 6¡ç 7¢Ø
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int N, M, K;

	static class Node {
		int m, s, d;

		public Node(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static List<Node>[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			// ri, ci, mi, si, di
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			map[r][c].add(new Node(m, s, d));
		}

		for (int k = 0; k < K; k++) {
			map = solve();
		}

		int ret = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Node node : map[i][j]) {
					ret += node.m;
				}
			}
		}
		System.out.println(ret);
	}

	private static List<Node>[][] solve() {
		List<Node>[][] moveMap = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				moveMap[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Node curr : map[i][j]) {
					int nr = (i + dr[curr.d] * curr.s) % N;
					int nc = (j + dc[curr.d] * curr.s) % N;
					nr += nr < 0 ? N : 0;
					nc += nc < 0 ? N : 0;
					moveMap[nr][nc].add(curr);
				}
			}
		}

		List<Node>[][] updateMap = new List[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				updateMap[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = moveMap[i][j].size();
				if (size == 1) {
					updateMap[i][j].add(moveMap[i][j].get(0));
				} else if (size > 1) {
					int m = 0;
					int s = 0;
					boolean even = false;
					boolean odd = false;
					for (Node curr : moveMap[i][j]) {
						m += curr.m;
						s += curr.s;
						if (curr.d % 2 == 0)
							even = true;
						else
							odd = true;
					}

					m /= 5;
					s /= size;
					if (m == 0)
						continue;
					if (even == odd) {
						for (int k = 1; k < 8; k += 2) {
							updateMap[i][j].add(new Node(m, s, k));
						}
					} else {
						for (int k = 0; k < 8; k += 2) {
							updateMap[i][j].add(new Node(m, s, k));
						}
					}
				}
			}
		}
		return updateMap;
	}
}