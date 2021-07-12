import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_3830_professor_210712 {
	static class find{
		int x;
		long val;
		find(int x, long val){
			this.x = x;
			this.val = val;
		}
	}
	static int[] parent;
	static long[] array;
	static ArrayList<find>[] ar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] k = br.readLine().split(" ");
			int N = Integer.parseInt(k[0]);
			int M = Integer.parseInt(k[1]);
			if(N==0 && M==0) break;
			parent = new int[N+1];
			ar = new ArrayList[N+1];
			for(int i = 1; i<=N; i++) {
				parent[i] = i;
				ar[i] = new ArrayList<find>();
			}
			
			array = new long[N+1];
			
			for(int i = 1; i<=M; i++) {
				k = br.readLine().split(" ");
//				System.out.println(i+" 시작 ");
				if(k[0].charAt(0)=='!') {
					int a = Integer.parseInt(k[1]);
					int b = Integer.parseInt(k[2]);
					int c = Integer.parseInt(k[3]);
					ar[a].add(new find(b,c));
					int x = find(a);
					int y = find(b);
					if(x!=y) {
						union(a,b,c);
					}
					
				}
				else {
					int a = Integer.parseInt(k[1]);
					int b = Integer.parseInt(k[2]);
					int x = find(a);
					int y = find(b);
					if(x!=y) {
						sb.append("UNKNOWN\n");
					}
					else {
//						System.out.println(array[b]+" "+array[a]);
						sb.append(array[b]-array[a]+"\n");
					}
				}
//				for(int j = 1; j<=N; j++) {
//					System.out.print(array[j]+" ");
//				}
//				System.out.println();
//				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
		System.out.println(sb);
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		int node = find(parent[a]);
//		System.out.println(a+" "+node+" / "+parent[a]+" "+array[a]+" "+array[parent[a]]);
		array[a] += array[parent[a]];
		return parent[a] = node;
	}
	
	static void union(int a, int b, int c) {
//		System.out.println("유니온 시작");
		int x = find(a);
		int y = find(b);
//		System.out.println("유니온 끝"+a+" "+x+" / "+b+" "+y);
		parent[y] = x;
		array[y] = array[a]-array[b]+c;
//		System.out.println(b+" / "+temp+" "+c+" "+array[b]);
	}
	

}
