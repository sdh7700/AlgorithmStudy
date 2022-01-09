import java.io.*;
import java.util.*;

public class boj_5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> fire = new LinkedList<>();
    static Queue<int[]> sg = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map = new int[y][x];

            /*
            * # -3
            * * -2
            * @ -1*/
            for (int j = 0; j < y; j++) {
                String input = br.readLine();
                for (int k = 0; k < x; k++) {
                    if (input.charAt(k) == '#')
                        map[j][k] = -3;
                    else if (input.charAt(k) == '*')
                        map[j][k] = -2;
                    else if (input.charAt(k) == '.')
                        map[j][k] = -1;
                }
            }

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (map[j][k] == -2) {
                        fire.add(new int[]{j, k});
                    }

                    if (map[j][k] == 0) {
                        sg.add(new int[]{j, k});
                    }
                }
            }
            cnt = 1;
            bfs(y, x);
            sg.clear();
            fire.clear();
            map = null;
        }
    }
    public static void bfs(int x, int y) {
        while (!sg.isEmpty()) {
            int size = fire.size();
            int sgSize = sg.size();
            while (size != 0) {
                int[] poll = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = poll[0] + dx[i];
                    int newY = poll[1] + dy[i];

                    if (newX < 0 || newX >= x || newY < 0 || newY >= y || map[newX][newY] == -3 || map[newX][newY] == -2)
                        continue;

                    map[newX][newY] = -2;
                    fire.add(new int[]{newX, newY});
                }
                size--;
            }
            while (sgSize != 0) {
                int[] pos = sg.poll();
                if (pos[0] == 0 || pos[0] == x - 1 || pos[1] == 0 || pos[1] == y - 1) {
                    map[pos[0]][pos[1]] = cnt;
                    System.out.println(map[pos[0]][pos[1]]);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int newX = pos[0] + dx[i];
                    int newY = pos[1] + dy[i];


                    if (newX < 0 || newX >= x || newY < 0 || newY >= y || map[newX][newY] != -1)
                        continue;

                    map[newX][newY] = cnt;
                    sg.add(new int[]{newX, newY});

                    }
                sgSize--;
                }
            cnt++;
        }
        System.out.println("IMPOSSIBLE");
    }
}
