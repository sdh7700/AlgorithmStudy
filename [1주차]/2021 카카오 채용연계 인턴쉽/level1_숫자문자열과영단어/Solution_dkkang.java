public class Solution_dkkang {
	public static void main(String[] args) {

		//1478
		String test1 = "one4seveneight";
		//234567
		String test2 = "23four5six7";
		//234567
		String test3 = "2three45sixseven";
		String test4 = "1234";

		Solution_dkkang s = new Solution_dkkang();
		System.out.println(s.solution(test1));
	}

	String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public int solution(String s) {

		String answer = s;

		for(int i=0; i<number.length; i++) {
			if(answer.contains(number[i])) {
				answer = answer.replaceAll(number[i], String.valueOf(i));
			}
		}

		return Integer.valueOf(answer);
	}

}