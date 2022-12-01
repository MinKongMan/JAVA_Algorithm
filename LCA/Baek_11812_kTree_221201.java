import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_11812_kTree_221201 {
	static int M,K;
	static long N;
	static HashMap<Long,Integer> hash = new HashMap<Long,Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			hash = new HashMap<Long,Integer>();
			
			long min = Math.min(x, y)-1;
			long max = Math.max(x, y)-1;
			hash.put(min, 0);
			hash.put(max, 0);
			
			int count = 1;
			
			find(min);
			if(M==1) {
				sb.append(max-min+"\n");
				continue;
			}
			boolean check = true;
			
			while(max!=0) {
				if(max%M==0) {
					max /= M;
					max--;
				}
				else max /= M;
				if(max<=0) {
					break;
				}
				if(hash.containsKey(max)) {
					sb.append(count+hash.get(max)+"\n");
					check = false;
					break;
				}
				count++;
			}
			
			if(check) {
				sb.append(count+hash.get(max)+"\n");
			}
//			System.out.println("天天天天天天天天天天天天天");
		}
		System.out.println(sb);
	}
	
	static void find(long x) {
		int count = 1;
		while(x!=0) {
			if(x%M==0) {
				x /= M;
				x--;
			}
			else x /= M;
			hash.put(x, count);
//			System.out.println(x+" "+count);
			count++;
		}
	}

}
