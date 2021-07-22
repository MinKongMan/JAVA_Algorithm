package programmers;

import java.io.IOException;

class Solution {
    static int[][] array, real_array, temp_array, lock_array, temp_lock;
    static int N, M;
    public static void main(String[] args) throws IOException {
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        N = key.length;
        M = lock.length;
        int l = M*M;
        int count = 0;
        lock_array = new int[M+1][M+1];
        array = new int[61][61];
        real_array = new int[61][61];
        temp_array = new int[61][61];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                array[i][j] = key[i-1][j-1];
            }
        }
        
        for(int i = 1; i<=M; i++){
            for(int j = 1; j<=M; j++){
                lock_array[i][j] = lock[i-1][j-1];
                count+= lock_array[i][j];
            }
        }
        if(find1()) return true;
        if(find2()) return true;
        if(find3()) return true;
        if(find4()) return true;
        return false;
    }
    
    static boolean find1(){
        real_array = new int[61][61];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                real_array[i+20][j+20] = array[N-j+1][i];
            }
        }
        if(check1(real_array)) return true;
        return false;
    }
    
    static boolean find2(){
        real_array = new int[61][61];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                real_array[i+20][j+20] = array[N-i+1][N-j+1];
            }
        }
        
        if(check1(real_array)) return true;
        return false;
    }
    
    static boolean find3(){
        real_array = new int[61][61];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                real_array[i+20][j+20] = array[j][N-i+1];
            }
        }
        if(check1(real_array)) return true;
        return false;
    }
    
    static boolean find4(){
        real_array = new int[61][61];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                real_array[i+20][j+20] = array[i][j];
            }
        }
        if(check1(real_array)) return true;
        return false;
    }
    
    static boolean check1(int[][] ar){
        for(int x = 21-M; x<=21+M; x++){
            for(int y = 21-M; y<=21+M; y++){
                temp_array = new int[M+1][M+1];
                for(int i = 1; i<=M; i++){
                    for(int j = 1; j<=M; j++){
                        temp_array[i][j] = ar[x+i-1][j+y-1];
                    }
                }
                int[][] temp_lock = new int[M+1][M+1];
                boolean check = true;
                forout:
                for(int i = 1; i<=M; i++){
                    for(int j = 1; j<=M; j++){
                        temp_lock[i][j] = temp_array[i][j]+lock_array[i][j];
                        if(temp_lock[i][j] == 0 || temp_lock[i][j]==2){
                            check = false;
                            break forout;
                        }
                    }
                }
                if(check) return true;
            }
        }
        return false;
    }
}