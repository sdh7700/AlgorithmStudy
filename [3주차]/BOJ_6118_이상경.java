package Solve010;

import java.io.*;
import java.util.*;

public class boj_6118 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] room;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        room = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            room[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int posX = Integer.parseInt(st.nextToken());
            int posY = Integer.parseInt(st.nextToken());
            room[posX].add(posY);
            room[posY].add(posX);
        }
        System.out.println(bfs(1, 0));

    }
    public static StringBuilder bfs(int start, int distance) {
        StringBuilder result = new StringBuilder();
        int maxDistance = -1;
        int maxCnt = 0;
        int roomNum = 0;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{start, distance});
        visit[start] = true;

        while (!qu.isEmpty()) {
            int[] poll = qu.poll();
            if (maxDistance < poll[1]) {
                maxDistance = poll[1];
                roomNum = poll[0];
                maxCnt = 1;
            }
            else if (maxDistance == poll[1]) {
                maxCnt++;
                if (roomNum > poll[0])
                    roomNum = poll[0];
            }

            for (int i : room[poll[0]]) {
                if (visit[i])
                    continue;

                qu.add(new int[]{i, poll[1] + 1});
                visit[i] = true;
            }
        }
        result.append(roomNum + " ");
        result.append(maxDistance + " ");
        result.append(maxCnt);
        return result;

    }

}
