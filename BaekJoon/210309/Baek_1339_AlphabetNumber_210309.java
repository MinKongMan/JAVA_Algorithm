import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1339_AlphabetNumber_210309 {
	static int N, count, max = 0;
	static boolean[] marked = new boolean[26];
	static boolean[] check = new boolean[10];
	static int[] array = new int[10];
	static int[] array2 = new int[26];
	static String[] str1, str2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str1 = new String[N+1];
		str2 = new String[N+1];
		for(int i = 1; i<=N; i++) {
			String k = br.readLine();
			str1[i] = k;
			for(int j = 0; j<k.length(); j++) {
				marked[k.charAt(j)-'A'] = true;
			}
		}
		count = 0;
		for(int i = 0; i<26; i++) {
			if(marked[i]==true) {
				array[count] = i;
				count++;
			}
		}
		find(0,9);
		System.out.println(max);
	}
	
	static void find(int a, int b) {
		if(count == a) {
			int temp = 0;
			for(int i = 1; i<=N; i++) {
//				String num = "";
				int num = 0;
				for(int j = 0; j<str1[i].length(); j++) {
					num *=10;
					int x = str1[i].charAt(j);
					num += array2[x-'A'];
//					num += array2[x-'A']+"";
				}
				temp += num;
			}
			max = max>temp?max:temp;
			return;
		}
		for(int i = 0; i<count; i++) {
			if(marked[array[i]]==true && check[i]==false) {
				check[i] = true;
				array2[array[i]] = b;
				find(a+1,b-1);
				check[i] = false;
			}
		}
	}

}
