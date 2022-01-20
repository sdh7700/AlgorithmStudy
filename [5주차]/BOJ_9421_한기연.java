package BOJ;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_9421_소수상근수 {
	static int N;
	static boolean[] primeNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		primeNum = new boolean[N + 1];
		primeNum[0] = true;
		primeNum[1] = true;
		for (int i = 2; i <= N; i++) {
			if (!primeNum[i]) {
				int x = i + i;
				while (x <= N) {
					primeNum[x] = true;
					x += i;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (!primeNum[i]) {
				if (check(i, new ArrayList<Integer>())) {
					System.out.println(i);
				}
			}
		}
	}

	private static boolean check(int i, ArrayList list) {
		if (list.contains(i))
			return false;
		else if (i == 1)
			return true;

		String str = Integer.toString(i);
		int ret = 0;
		for (int j = 0; j < str.length(); j++) {
			int x = str.charAt(j) - '0';
			ret += x * x;
		}
		list.add(i);
		return check(ret, list);
	}
}