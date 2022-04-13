import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_2632_sellPizza_220413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		
		int[] array1 = new int[2*x+1];
		int[] array2 = new int[2*y+1];
		
		int[] answer1 = new int[1000001];
		int[] answer2 = new int[1000001];
		
		for(int i = 1; i<=x; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			array1[i] = val;
		}
		
		for(int i = 1; i<=y; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			array2[i] = val;
		}
		
		for(int i = x+1; i<=2*x; i++) {
			array1[i] = array1[i-x];
		}
		
		for(int i = y+1; i<=2*y; i++) {
			array2[i] = array2[i-y];
		}
		
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		ArrayList<Integer> ar3 = new ArrayList<Integer>();
		boolean[] marked = new boolean[1000001];
		int val2 = 0;
		
		for(int i = 1; i<=x; i++) {
			int val = 0;
			val2 += array1[i];
			for(int j = 0; j<x-1; j++) {
				val += array1[i+j];
				ar1.add(val);
			}
		}
		
		ar1.add(val2);
		val2 = 0;
		
		for(int i = 1; i<=y; i++) {
			int val = 0;
			val2 += array2[i];
			for(int j = 0; j<y-1; j++) {
				val += array2[i+j];
				ar2.add(val);
			}
		}
		ar2.add(val2);
		Collections.sort(ar1);
		Collections.sort(ar2);
		
		int count = 0;
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i : ar1) {
			if(i==N) count++;
			answer1[i]++;
			if(!marked[i]) {
				marked[i] = true;
				ar3.add(i);
			}
		}
		for(int i : ar2) {
			if(i==N) count++;
			answer2[i]++;
		}
		
		for(int i : ar3) {
			int temp_count = 0;
			
			int temp_val = 0;
			int val = i;
			
			if(temp_val==val) {
				count += temp_count;
				continue;
			}
			
			int left = 0;
			int right = ar2.size()-1;
			int mid = 0;
			while(left<right) {
				
				mid = (left+right)/2;
				
				if(ar2.get(mid)+val>=N) {
					right = mid;
				}
				else {
					left = mid+1;
				}
			}
			
			if(ar2.get(left)+val==N) {
				count += answer2[ar2.get(left)]*answer1[i];
			}
		}
		
		System.out.println(count);
		
	}

}
