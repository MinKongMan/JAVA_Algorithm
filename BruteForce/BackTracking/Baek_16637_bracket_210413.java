import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baek_16637_bracket_210413 {
	static LinkedList<Integer> array = new LinkedList<Integer>();
	static LinkedList<Character> c_array = new LinkedList<Character>();
	static boolean[] marked;
	static int[] ar;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		marked = new boolean[(N+1)/2];
		ar = new int[(N+1)/4];
		String l = br.readLine();
		for(int i = 1; i<=N; i++) {
			if(i%2==1) {
				array.add(l.charAt(i-1)-'0');
			}
			else {
				c_array.add(l.charAt(i-1));
			}
		}
		back(array.get(0),0);
		System.out.println(max);
	}
	
	static void back(int a, int b) {
		if(b>=c_array.size()) {
			max = max>a?max:a;
			System.out.println(a);
			return;
		}
		
		int result = cal(a,array.get(b+1),c_array.get(b));
		back(result,b+1);
		
		if(b+1<c_array.size()) {
			int res = cal(array.get(b+1),array.get(b+2),c_array.get(b+1));
			back(cal(a, res, c_array.get(b)),b+2);
		}
		
	}
	
	static int cal(int a, int b, char c) {
		switch(c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return 0;
	}

}
