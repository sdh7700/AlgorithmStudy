import java.io.*;
import java.util.*;

public class boj_8972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] js = new int[2];
    static int[] jsMove;
    static List<int[]> arduino = new ArrayList<>();
    static char[][] map;
    static boolean[] check;
    static int[][] move = new int[][]{{0, 0, 0}, {1, 1, -1}, {2, 1, 0}, {3, 1, 1}, {4, 0, -1}, {5, 0, 0}, {6, 0, 1}, {7, -1, -1}, {8, -1, 0}, {9, -1, 1}};
    static int moveCnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map = new char[x][y];

        for (int i = 0 ; i < x; i++) {
            String input = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = '.';
                if (input.charAt(j) == 'I') {
                    js[0] = i;
                    js[1] = j;
                }
                else if (input.charAt(j) == 'R') {
                    int[] rPos = new int[]{i, j};
                    arduino.add(rPos);
                }
            }
        }
        check = new boolean[arduino.size()];
        String moveInput = br.readLine();
        jsMove = new int[moveInput.length()];
        for (int i = 0; i < moveInput.length(); i++) {
            jsMove[i] = Character.getNumericValue(moveInput.charAt(i));
        }
        if (!solution(x, y)) {
            System.out.println("kraj " + moveCnt);
            return ;
        }
        map[js[0]][js[1]] = 'I';
        for (int i = 0; i < arduino.size(); i++) {
            if (check[i])
                continue;
            map[arduino.get(i)[0]][arduino.get(i)[1]] = 'R';
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solution(int x, int y) {
        for (int i = 0; i < jsMove.length; i++) {
            int[] go = move[jsMove[i]];
            js[0] += go[1];
            js[1] += go[2];
            moveCnt++;

            for (int j = 0; j < arduino.size(); j++) {
                if (js[0] == arduino.get(j)[0] && js[1] == arduino.get(j)[1])
                    return false;
            }

            int moveX = 0;
            int moveY = 0;

            for (int j = 0; j < arduino.size(); j++) {
                if (check[j])
                    continue;
                int[] aduGo = arduino.get(j);
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < 10; k++) {
                    int newX = aduGo[0] + move[k][1];
                    int newY = aduGo[1] + move[k][2];
                    if (newX < 0 || newX >= x || newY < 0 || newY >= y)
                        continue;

                    if (Math.abs(js[0] - newX) + Math.abs(js[1] - newY) < min) {
                        moveX = move[k][1];
                        moveY = move[k][2];
                        min = Math.abs(js[0] - newX) + Math.abs(js[1] - newY);
                    }
                }
                aduGo[0] += moveX;
                aduGo[1] += moveY;

                if (js[0] == aduGo[0] && js[1] == aduGo[1]) {
                    return false;
                }
            }
            for (int j = 0; j < arduino.size(); j++) {
                if (check[j])
                    continue;
                for (int k = j + 1; k < arduino.size(); k++) {
                    if (arduino.get(j)[0] == arduino.get(k)[0] && arduino.get(j)[1] == arduino.get(k)[1]) {
                        check[j] = true;
                        check[k] = true;
                    }
                }
            }
        }
        return true;
    }
}
