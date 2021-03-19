import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1062_teaching_210319 {
	static String[] array;
	static int N,K,temp,max=0;
	static boolean[] marked = new boolean[26];
	static boolean[] marked2 = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		marked[0] = marked[2] = marked['i'-'a'] =marked['n'-'a'] = marked['t'-'a']= true;
		marked2[0] = marked2[2] = marked2['i'-'a'] =marked2['n'-'a'] = marked2['t'-'a']= true;
		String[] k = br.readLine().split(" ");
		N = Integer.parseInt(k[0]);
		K = Integer.parseInt(k[1]);
		array = new String[N+1];
		
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			l = l.substring(4, l.length()-4);
			array[i] = l;
//			System.out.println(l);
		}
		if(K<5) {
			System.out.println(0);
		}
		else {
			back(6,0);
			System.out.println(max);
		}
	}
	
	static void back(int a, int b) {
		if(a==K+1) {
			temp = 0;
			for(int i = 1; i<=N; i++) {
				for(int j = 0; j<array[i].length(); j++) {
					if(!marked2[array[i].charAt(j)-'a']) {
						temp++;
						break;
					}
				}
			}
//			for(int i = 0; i<26; i++) {
//				if(marked2[i]==true) {
//					char t = (char) ((char)i+'a');
//					System.out.print(t);
//				}
//			}
//			System.out.println();
			temp = N-temp;
//			System.out.println(temp);
			max = max>temp?max:temp;
			return;
		}
		
		for(int i = b; i<26; i++) {
			if(marked[i]) continue;
			if(!marked2[i]) {
//				int k = i+'a';
//				char t = (char) k;
//				System.out.println(t);
				marked2[i] = true;
				back(a+1, i);
				marked2[i] = false;
			}
		}
	}

}
