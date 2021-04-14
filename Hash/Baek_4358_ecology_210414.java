import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baek_4358_ecology_210414 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		int count = 0;
		while(true) {
			String l = br.readLine();
			if(l==null|| l.length()==0 || l.equals("")) {
				break;
			}
			count++;
			if(hash.containsKey(l)) hash.put(l, hash.get(l)+1);
			else {
				hash.put(l, 1);
			}
		}
		Object[] link = hash.keySet().toArray();
		Arrays.sort(link);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<link.length; i++) {
			float k = (float)hash.get(link[i])/count*100;
			sb.append(link[i]+" "+String.format("%.4f",k)+"\n");
		}
		System.out.print(sb);
	}

}
