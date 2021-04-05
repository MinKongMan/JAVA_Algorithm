import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_1351_infiniteSequence_210405 {
	static long N,M,K;
	static HashMap<Long,Long> hash;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		hash = new HashMap<Long,Long>();
		hash.put(0L, 1L);
		long hyo = M>K? M:K;
		for(long i = 1; i<=hyo; i++) {
			hash.put(i, hash.get(i/K)+hash.get(i/M));
		}
		System.out.println(hash.get(N/M)+hash.get(N/K));
//		System.out.println(find(N));
	}
	
//	static long find(long N) {
//		if(hash.containsKey(N)) {
//			return hash.get(N);
//		}
//		else {
//			long val = find(N/K)+find(N/M);
//			hash.put(N, val);
//			return val;
//		}
//	}
}
