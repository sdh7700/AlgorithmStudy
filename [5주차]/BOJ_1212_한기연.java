package BOJ;
import java.util.Scanner;

public class BOJ_1212_8진수2진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			int x = input.charAt(i) - '0'; // 숫자 하나.
			String temp = Integer.toBinaryString(x);
			if (i != 0) {
				while (temp.length() != 3) {
					temp = '0' + temp;
				}
			}
			sb.append(temp);
		}
		System.out.println(sb.toString());
	}
}