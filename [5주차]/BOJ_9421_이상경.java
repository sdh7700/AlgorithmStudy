package Solve010;

import java.io.*;
import java.util.*;

public class boj_9421 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] check = new boolean[(81 * 7) + 1];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int i = 7;
        while (i <= n) {
            if (i % 2 == 0) {
                i++;
                continue;
            }

            if (isPrime(i))
                if (isSg(i))
                    System.out.println(i);
            i++;
        }
    }

    static boolean isPrime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isSg(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        List<Integer> list = new ArrayList<>();

        while (true) {
            n = 0;
            for (int i = 0; i < sb.length(); i++) {
                n += Math.pow(Character.getNumericValue(sb.charAt(i)), 2);
            }
            if (n == 1){
                while (!list.isEmpty())
                    check[list.remove(0)] = false;
                return true;
            }
            if (check[n]) {
                return false;
            }
            check[n] = true;
            list.add(n);
            sb = new StringBuilder(String.valueOf(n));
        }
    }
}
