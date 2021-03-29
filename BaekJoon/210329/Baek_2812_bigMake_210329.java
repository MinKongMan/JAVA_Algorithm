import java.util.Scanner;
import java.util.Stack;

public class Baek_2812_bigMake_210329 {
	static char[] k;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		String l = sc.next();
		Stack<Character> stack = new Stack<Character>();
		sc.close();
		k = new char[N+1];
		for(int i = 1; i<=l.length(); i++) {
			k[i] = l.charAt(i-1);
		}
		for(int i = 1; i<=N; i++) {
			int idx = i;
//			if(stack.size()<N-M) {
//				if(stack.peek()<k[i]) {
//					stack.pop();
//					stack.push(k[i]);
//				}
//				else {
//					stack.push(k[i]);
//				}
//			}
			if(stack.size()==0) {
				stack.push(k[i]);
			}
			
			else{
				if(Integer.parseInt(stack.peek()+"")>Integer.parseInt(k[i]+"") && stack.size()<N-M) {
					stack.push(k[i]);
				}
				else {
					if(N-M-stack.size()<=N-i) {
						int hyo = M+stack.size()-i;
//						System.out.println(i+" "+hyo);
						for(int x = 0; x<=hyo; x++) {
							if(stack.size()>0) {
								if(stack.peek()<k[i]) {
									stack.pop();
								}
								else {
									break;
								}
								
							}
							else {
								break;
							}
						}
//						System.out.println(stack.peek());
						
//						System.out.println(stack.peek());
					}
					if(stack.size()<N-M) {
						System.out.println("六");
						stack.push(k[i]);
					}
					
				}
			}
//			for(int j = 0; j<stack.size(); j++) {
//				System.out.print(stack.get(j)+" ");
//			}
//			System.out.println();
//			System.out.println("天天天天天天天天");
		}
		StringBuilder sb = new StringBuilder();
		for(Character jung : stack) {
			sb.append(jung);
		}
		System.out.println(sb);
	}	
}
