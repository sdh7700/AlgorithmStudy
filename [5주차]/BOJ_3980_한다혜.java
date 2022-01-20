import java.io.*;
import java.util.*;

public class BOJ_3980_한다혜 {
  static int[][] arr = new int[11][11];
  static boolean[] chk = new boolean[11];
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int t = 0; t < tc; t++) {
      for (int i = 0; i < 11; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      max = 0;
      dfs(0, 0);
      System.out.println(max);
    }
  }

  public static void dfs(int cur, int sum) {
    if (cur == 11) {
      if (max < sum) {
        max = sum;
      }
      return;
    }
    for (int i = 0; i < 11; i++) {
      if (!chk[i] && arr[cur][i] != 0) {
        chk[i] = true;
        dfs(cur + 1, sum + arr[cur][i]);
        chk[i] = false;
      }
    }
  }
}
