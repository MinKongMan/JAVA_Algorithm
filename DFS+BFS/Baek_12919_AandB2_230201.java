import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_12919_AandB2_230201 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		HashSet<String> set = new HashSet<String>();
		
		set.add(B);
		Queue<String> q = new LinkedList<String>();
		q.add(B);
		
		while(!q.isEmpty()) {
			String l = q.poll();
			
			if(l.length()>A.length()&& l.charAt(l.length()-1)=='A') {
				String t = l.substring(0,l.length()-1);
				set.add(t);
				q.add(t);
			}
			
			if(l.length()>A.length() && l.charAt(0)=='B') {
				String t = "";
				for(int i = l.length()-1; i>=1; i--) {
					t += l.charAt(i);
				}
				set.add(t);
				q.add(t);
			}
		}
		if(set.contains(A)) System.out.println(1);
		else System.out.println(0);
	}

}
