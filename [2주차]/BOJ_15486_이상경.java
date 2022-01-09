import java.io.*;
import java.util.*;

public class boj_15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] t;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        t = new int[n + 2];
        p = new int[n + 2];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());

        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n + 1; i++) {
            if (max < dp[i])
                max = dp[i];

            if (i + t[i] < n + 2 && (max + p[i] > dp[i + t[i]])) {
                dp[i + t[i]] = max + p[i];
            }
        }
        System.out.println(max);
    }
}