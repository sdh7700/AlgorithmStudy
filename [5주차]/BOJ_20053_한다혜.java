import java.util.*;
import java.io.*;

public class BOJ_20053_한다혜 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int t=0; t<T; t++){
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(long i=0; i<N; i++){
        int num = Integer.parseInt(st.nextToken());
        if(num<min) min = num;
        if(num>max) max = num;
      }
      System.out.println(min+" "+max);
    }
   
  }
}
