import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String eight = br.readLine();
		if(eight.equals("0"))
			result.append(0);
		else {
			for(int i=0; i<eight.length(); i++) {
				int sn = 4;
				int target = eight.charAt(i) - '0';
				while(sn >= 1) {
					if(target - sn >= 0) {
						result.append('1');
						target -= sn;
					}
					else {
						if(i != 0 || result.length() != 0)
							result.append('0');					
					}
					sn /= 2;
				}
			}
		}
		System.out.println(result);
	}
}
