import java.util.*;
import java.io.*;

public class BOJ_14425_한다혜 {
  public static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    List list = new ArrayList<String>();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      list.add(str);
    }
    int cnt = 0;
    for (int i = 0; i < M; i++) {
      String str = br.readLine();
      if (list.contains(str)) {
        cnt++;
      }
    }
    System.out.println(cnt);

  }
}
