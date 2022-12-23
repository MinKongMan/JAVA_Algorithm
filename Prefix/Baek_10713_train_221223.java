import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10713_train_221223 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] station = new int[M+1];
        long[][] money = new long[4][N+2];
        int[] sum = new int[N+2];
        int[] array = new int[N+2];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i<=M; i++) {
        	int x = Integer.parseInt(st.nextToken());
        	station[i] = x;
        }
        
        for(int i = 2; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
        	money[1][i] = x;
        	money[2][i] = y;
        	money[3][i] = z;
        }
        
        for(int i = 1; i<M; i++) {
        	int x = station[i];
        	int y = station[i+1];
        	
        	if(x<y) {
        		sum[x+1]++;
        		sum[y+1]--;
        	}
        	else {
        		sum[y+1]++;
        		sum[x+1]--;
        	}
        }
        
        for(int i = 1; i<=N; i++) {
        	array[i] += array[i-1]+sum[i];
        }
        
        long val = 0;
        
        for(int i = 1; i<=N; i++) {
        	if(array[i]==0) continue;
        	else {
        		long case1 = array[i]*money[1][i];
        		long case2 = array[i]*money[2][i]+money[3][i];
        		
        		if(case1>case2) val += case2;
        		else val += case1;
        	}
        	
        }
        System.out.println(val);
	}

}
