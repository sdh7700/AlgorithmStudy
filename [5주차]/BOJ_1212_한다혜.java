import java.io.*;
public class BOJ_1212_한다혜 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String eight = br.readLine();
    StringBuilder answer = new StringBuilder();
    for( int i=0; i<eight.length(); i++){
      String two = Integer.toBinaryString(eight.charAt(i)-'0'); //8진수 -> 2진수
      if(i==0) answer.append(two); //맨 앞이면 0으로 시작 안해도 됨 
      else{ //0으로 시작하는 경우 예외 처리
        if(two.length()==1) answer.append("00"+two);
        else if(two.length()==2) answer.append("0"+two);
        else answer.append(two);
      }
    }
    System.out.println(answer);
  }
}
