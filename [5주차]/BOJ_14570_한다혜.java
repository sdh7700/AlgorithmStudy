import java.io.*;
import java.util.*;
public class BOJ_14570_한다혜 {
  static int N;
  static long K;
  static ArrayList<Node> list;

  public static class Node{
    public int left;
    public int right;

    public Node(int left, int right){
      this.left = left;
      this.right = right;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new ArrayList<Node>();
    list.add(new Node(0,0));
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      list.add(new Node(u,v));
    }
    K = Long.parseLong(br.readLine());

    int node = 1;
    while(true){
      if(list.get(node).left==-1 && list.get(node).right==-1){ // 1. 자식 노드 없으면 멈춤
        break;
      }
      else if(list.get(node).left==-1){ //왼쪽 노드 없으면 오른쪽으로 
        node = list.get(node).right;
      }
      else if(list.get(node).right==-1){ // 오른쪽 노드 없으면 왼쪽으로
        node = list.get(node).left;
      }
      else if(K%2==0){ //K가 짝수면 오른쪽으로 가고 
        node = list.get(node).right;
        K = K/2;
      }
      else{ //K가 홀수면 왼쪽으로 감 
        node = list.get(node).left;
        K = K/2 + 1;
      }
    }
    System.out.println(node);
  }
  
}
