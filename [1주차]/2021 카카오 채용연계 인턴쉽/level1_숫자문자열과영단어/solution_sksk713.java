import java.util.*;

class Solution {
    static Map<String, String> digit = new HashMap<>();
    static StringBuilder result = new StringBuilder();

    public int solution(String s) {
        digit.put("zero", "0");
        digit.put("one", "1");
        digit.put("two", "2");
        digit.put("three", "3");
        digit.put("four", "4");
        digit.put("five", "5");
        digit.put("six", "6");
        digit.put("seven", "7");
        digit.put("eight", "8");
        digit.put("nine", "9");

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (temp.length() != 0) {
                    result.append(digit.get(temp.toString()));
                    temp.setLength(0);
                }
                result.append(s.charAt(i));
            }
            else {
                if (digit.containsKey(temp.toString())) {
                    result.append(digit.get(temp.toString()));
                    temp.setLength(0);
                }
                temp.append(s.charAt(i));
            }
        }
        if (temp.length() != 0) {
            result.append(digit.get(temp.toString()));
        }

        return Integer.parseInt(result.toString());
    }
}