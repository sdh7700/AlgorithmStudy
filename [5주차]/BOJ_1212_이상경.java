import java.io.*;

public class BOJ_1212_이상경 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder num = new StringBuilder(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (num.toString().equals("0"))
            sb.append(0);
        else {
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) != '0')
                    break;
                if (num.charAt(i) == '0')
                    num.deleteCharAt(i);
            }
            for (int i = 0; i < num.length(); i++) {
                char cur = num.charAt(i);
                if (i == 0) {
                    if (cur == '1')
                        sb.append("1");
                    else if (cur == '2')
                        sb.append("10");
                    else if (cur == '3')
                        sb.append("11");
                    else if (cur == '4')
                        sb.append("100");
                    else if (cur == '5')
                        sb.append("101");
                    else if (cur == '6')
                        sb.append("110");
                    else if (cur == '7')
                        sb.append("111");
                }
                else {
                    if (cur == '0')
                        sb.append("000");
                    else if (cur == '1')
                        sb.append("001");
                    else if (cur == '2')
                        sb.append("010");
                    else if (cur == '3')
                        sb.append("011");
                    else if (cur == '4')
                        sb.append("100");
                    else if (cur == '5')
                        sb.append("101");
                    else if (cur == '6')
                        sb.append("110");
                    else if (cur == '7')
                        sb.append("111");
                }
            }
        }
        System.out.println(sb);
    }
}
