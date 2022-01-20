import java.util.*;
import java.io.*;

public class BOJ_9421_한다혜 {
  public static int N;
  public static boolean prime[] = new boolean[1000001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    chkPrimeNumber();
    for (int i = 3; i <= N; i++) {
      if (!prime[i] && chkHappyNumber(i)) {
        System.out.println(i);
      }
    }
  }

  // 에라토스테네스의 체: 2부터 배수는 모두 지움
  public static void chkPrimeNumber() {
    for (int i = 2; i <= 1000000; i++) {
      for (int j = i * 2; j <= 1000000; j += i) {
        prime[j] = true;
      }
    }
  }

  public static Boolean chkHappyNumber(int num) {
    String number = Integer.toString(num);
    List list = new ArrayList<Integer>();
    do {
      int tmp = 0;
      for (int i = 0; i < number.length(); i++) {
        tmp += ((number.charAt(i) - '0') * (number.charAt(i) - '0'));
      }
      if (list.contains(tmp)) {
        return false;
      }
      if (tmp == 1) {
        return true;
      }
      list.add(tmp);
      number = Integer.toString(tmp);
    } while (true);
  }
}