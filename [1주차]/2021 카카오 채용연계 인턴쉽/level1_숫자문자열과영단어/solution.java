import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = s;
        String[] words = new String[]{"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int size = 9;
        for (int i = 0; i < size; i++) {
            result = result.replace(words[i],numbers[i]);
        }

        System.out.println(result);
    }
}
