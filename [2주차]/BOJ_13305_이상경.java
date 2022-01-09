import java.io.*;
import java.util.*;

public class boj_13305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] distance;
    static long[] cost;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        distance = new long[n - 1];
        cost = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++)
            distance[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cost.length; i++)
            cost[i] = Long.parseLong(st.nextToken());

        int currIdx = 0;
        long result = 0;
        for (int i = 1; i < cost.length; i++) {
            result += cost[currIdx] * distance[i - 1];
            if (cost[currIdx] > cost[i])
                currIdx = i;
        }
        System.out.println(result);
    }
}