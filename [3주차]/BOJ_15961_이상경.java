import java.io.*;
import java.util.*;

public class boj_15961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> ss = new LinkedList<>();
    static List<Integer> ssPos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] plate = new int[n];
        int[] sushi = new int[d + 1];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            if (sushi[plate[i]] == 0) {
                sushi[plate[i]]++;
                cnt++;
            }
        }
        
        for (int i = 0; i < ssPos.size(); i++) {
            if (ssPos.size() == 1 && n - 1 >= k) {
                System.out.println(k + 1);
                System.out.println(1);
                return;
            }
            if (i == ssPos.size() - 1) {
                gap = Math.abs(ssPos.get(ssPos.size() - 1) - ssPos.get(i - 1));
                if (gap > k) {
                    System.out.println(gap);
                    return;
                }
            } else {
                gap = Math.abs(ssPos.get(i) - ssPos.get(i + 1));
                if (gap > k) {
                    System.out.println(gap);
                    return;
                }
            }
        }
        System.out.println(k);
    }
}
