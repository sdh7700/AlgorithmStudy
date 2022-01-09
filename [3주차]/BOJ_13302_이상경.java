import java.io.*;
import java.util.*;

public class boj_13302 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static int coupon = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                dp[Integer.parseInt(st.nextToken())] = -1;
            }
        }
        dfs(1, n, 0);
        for (int i = 1; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
    }

    public static int dfs(int day, int end, int couponCnt) {
        if (day > end)
            return 0;
        coupon += couponCnt;

        if (dp[day] == -1) {
            return dp[day] = Math.min(dp[day], dfs(day + 1, end, 0));
        }
        if (coupon >= 3) {
            dp[day] = Math.min(dp[day], dfs(day + 1, end, 0));
            coupon = 0;
        }

        dp[day] = Math.min(dp[day], dfs(day + 1, end, 0) + 10000);
//        dp[day] = Math.min(dp[day], dfs(day + 3, end, 1) + 25000);
//        dp[day] = Math.min(dp[day], dfs(day + 5, end, 2) + 37000);

        return dp[day];
    }
}
