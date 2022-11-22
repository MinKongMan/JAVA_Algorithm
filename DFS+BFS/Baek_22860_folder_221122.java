import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_22860_folder_221122 {
	static HashMap<String, Integer> hash = new HashMap<String, Integer>();
	static HashSet<String> set = new HashSet<String>();
	static HashMap<String, Integer> hash_f = new HashMap<String, Integer>();
	static HashSet<String> set_f = new HashSet<String>();
	static boolean[] marked;
	static ArrayList<Integer>[] ar_f,ar;
	static int count_f = 0, count_all = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ar_f = new ArrayList[N+2];
		ar = new ArrayList[N+2];
		marked = new boolean[M+1];
		
		for(int i = 1; i<=N+1; i++) {
			ar[i] = new ArrayList<Integer>();
			ar_f[i] = new ArrayList<Integer>();		
		}
		
		for(int i = 1; i<=M; i++) {
				
		}
		
		for(int i = 1; i<=N+M; i++) {
			String[] str = br.readLine().split(" ");
			
			String a = str[0];
			String b = str[1];
			
			int c = Integer.parseInt(str[2]);
			
			if(!set.contains(a)) {
				set.add(a);
				hash.put(a, hash.size()+1);
			}
			
			if(c==1) {
				if(!set.contains(b)) {
					set.add(b);
					hash.put(b,hash.size()+1);
				}
				ar[hash.get(a)].add(hash.get(b));
			}
			else {
				if(!set_f.contains(b)) {
					set_f.add(b);
					hash_f.put(b, hash_f.size()+1);
				}
				ar_f[hash.get(a)].add(hash_f.get(b));
			}
		}
		
		int x = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =1 ; i<=x; i++) {
			String l = br.readLine();
			String[] ll = l.split("/");
			count_f = 0;
			count_all = 0;
			int y = hash.get(ll[ll.length-1]);
			marked = new boolean[M+1];
			dfs(y);
			sb.append(count_f+" "+count_all+"\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int x) {
		for(int a : ar_f[x]) {
			if(marked[a]) count_all++;
			else {
				marked[a] = true;
				count_all++;
				count_f++;
			}
		}
		for(int a : ar[x]) {
			dfs(a);
		}
	}

}
