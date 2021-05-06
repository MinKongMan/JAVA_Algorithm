import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Baek_1013_contact_210506 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			String l = br.readLine();
			boolean check = Pattern.matches("^(100+1+|01)+$", l);
			if(check) sb.append("YES\n");	
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
}
