import java.io.*;
import java.util.*;

public class boj_13908 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] know;
    static Stack<Integer> stack = new Stack<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m != 0) {
            know = new int[m];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                know[i] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, n, m);
        System.out.println(result);
    }

    public static void dfs(int start, int end, int m) {
        if (start == end) {
            for (int i = 0; i < m; i++) {
                if (!stack.contains(know[i]))
                    return;
            }
            result++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            stack.add(i);
            dfs(start + 1, end, m);
            stack.pop();
        }
    }
}