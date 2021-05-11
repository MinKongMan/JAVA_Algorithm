import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_5430_AC_210510 {
	static Deque<Integer> qx = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC2 = 1 ; TC2<= TC; TC2++) {
			String k = br.readLine();
			boolean mark = true;
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			String l = br.readLine();
			l = l.replace("[", "");
			l = l.replace("]", "");
			if(l.length()>0) {
				String[] hyo = l.split(",");
				for(int i = 1; i<=N; i++) {
					qx.add(Integer.parseInt(hyo[i-1]));
				}
			}
			for(int i = 1; i<=k.length(); i++) {
				
				if(k.charAt(i-1)=='R') {
					count++;
				}
				else {
					if(qx.size()==0) {
						mark = false;
						break;
					}
					if(count%2==0) {
						qx.poll();
					}
					else {
						qx.pollLast();
					}
				}
			}
			
			if(!mark) {
				sb.append("error\n");
			}
			else {
				if(count%2==0) {
					sb.append("[");
					while(!qx.isEmpty()) {
						sb.append(qx.poll());
						if(!qx.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				}
				else {
					sb.append("[");
					while(!qx.isEmpty()) {
						sb.append(qx.pollLast());
						if(!qx.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				}
			}
			
		}
		System.out.println(sb);
	}

}
