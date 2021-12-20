public class Solution_level1_숫자문자열과영단어_한기연 {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}

	static String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static int solution(String s) {
		StringBuilder sb = new StringBuilder();
		int N = s.length();

		String subString = "";
		for (int i = 0; i < N; i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				sb.append(s.charAt(i));
			} else {
				subString += s.charAt(i);
				for (int j = 0; j < number.length; j++) {
					if (number[j].equals(subString)) {
						sb.append(j);
						subString = "";
						break;
					}
				}
			}
		}

		return Integer.parseInt(sb.toString());
	}

}