import java.util.Stack;

public class Solution_level3_표편집_한기연 {
	public static void main(String[] args) {
		System.out.println(solution(8, 2, new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" }));
		System.out.println(solution(8, 2, new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" }));
	}

	public static String solution(int n, int k, String[] cmd) {
		Node[] list = new Node[n];
		for (int i = 0; i < n; i++) {
			list[i] = new Node();
		}
		for (int i = 1; i < n; i++) {
			list[i - 1].next = list[i];
			list[i].prev = list[i - 1];
		}

		Node now = list[k];
		Stack<Node> stack = new Stack<>();

		for (String str : cmd) {
			if (str.charAt(0) == 'U') {
				int x = Integer.parseInt(str.substring(2));
				for (int i = 0; i < x; i++) {
					now = now.prev;
				}
			} else if (str.charAt(0) == 'D') {
				int x = Integer.parseInt(str.substring(2));
				for (int i = 0; i < x; i++) {
					now = now.next;
				}
			} else if (str.charAt(0) == 'C') {
				stack.push(now);
				now.removed = true;
				Node up = now.prev;
				Node down = now.next;
				if (up != null) {
					up.next = down;
				}
				if (down != null) {
					down.prev = up;
					now = down;
				} else {
					now = up;
				}
			} else { // Z
				Node popNode = stack.pop();
				popNode.removed = false;
				Node up = popNode.prev;
				Node down = popNode.next;
				if (up != null) {
					up.next = popNode;
				}
				if (down != null) {
					down.prev = popNode;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			if (list[i].removed) {
				sb.append("X");
			} else {
				sb.append("O");
			}
		}
		return sb.toString();
	}
}

class Node {
	boolean removed;
	Node prev;
	Node next;
}