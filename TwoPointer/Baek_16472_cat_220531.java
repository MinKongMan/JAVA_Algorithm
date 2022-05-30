import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_16472_cat_220531 {

	static int N;
	static Character[] array;
	static Set<Character> set = new HashSet<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int max = 0;
		
		String str = br.readLine();
		Queue<Character> q = new LinkedList<Character>();
		array = new Character[str.length()+1];	
		int[] val = new int[27];
		
		for(int i = 1; i<=str.length(); i++) {
			array[i] = str.charAt(i-1);
		}
		
		int l = 1;
		int r = 1;
		
		while(true) {
			if(r>str.length()) {
				while(!q.isEmpty()) {
					char c = q.poll();
					int x = c-'a'+1;
					val[x]--;
					if(val[x]==0) set.remove(c);
					max = Math.max(q.size(), max);
				}
				break;
			}
			else {
				if(set.size()<N) {
					if(!set.contains(array[r])) {
						set.add(array[r]);
					}
					q.add(array[r]);
					val[array[r]-'a'+1]++;
					r++;
				}
				else if((set.size()==N)) {
					if(set.contains(array[r])) {
						q.add(array[r]);
						val[array[r]-'a'+1]++;
						r++;
					}
					else {
						char c = q.poll();
						int x = c-'a'+1;
						val[x]--;
						if(val[x]==0) set.remove(c);
					}
				}
			}
//			System.out.println(r-1+" "+q.size()+" "+set.size());
			max = Math.max(q.size(), max);
		}
		System.out.println(max);
	}

}
