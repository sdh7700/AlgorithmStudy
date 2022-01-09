import java.io.*;
import java.util.*;

public class boj_9094 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double result = Math.pow(j, 2) + Math.pow(k, 2) + m;
                    if (result % (j * k) == 0)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
