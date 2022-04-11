package programmers;

public class kakao {

	public static void main(String[] args) {
//		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		solution(board,skill);
	}
	static long[][] tree, temp_tree;
    static long[][] array;
    static int N,M;
    public static int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        
        tree = new long[N+1][4*M];
        temp_tree = new long[N+1][4*M];
        array = new long[N+1][M+1];
        
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                array[i][j] = board[i-1][j-1];
            }
        }
        
        for(int k = 0; k<skill.length; k++){
            int x = skill[k][0];
            int r1 = skill[k][1]+1;
            int c1 = skill[k][2]+1;
            int r2 = skill[k][3]+1;
            int c2 = skill[k][4]+1;
            long val = skill[k][5];
            System.out.println(r1+" "+c1+" / "+r2+" "+c2+" / "+val);
            for(int i = r1; i<=r2; i++){
                if(x==1){
                    update(i,1,c1,c2,1,M,-val);
                }
                else{
                    update(i,1,c1,c2,1,M,val);
                }
            }
            for(int i = 1; i<=N; i++) {
            	for(int j = 1; j<=9; j++) {
            		System.out.print(temp_tree[i][j]+" ");
            	}
            	System.out.println();
            }
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            for(int i = 1; i<=N; i++) {
            	for(int j = 1; j<=9; j++) {
            		System.out.print(tree[i][j]+" ");
            	}
            	System.out.println();
            }
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
        for(int i = 1; i<=N; i++){
            get(i,1,1,M,1,M);
            dfs(i,1,1,M);
            System.out.println(tree[i][1]);
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        
        int answer = 0;
        return answer;
    }

    
    public static long update(int x, int idx, int start, int end, int l, int r, long val){
        int mid = (l+r)/2;
        System.out.println(x+" "+idx+" / "+l+" "+r+" "+start+" "+end);
        if(temp_tree[x][idx]!=0){
            lazy_update(x, idx, l, r);
        }
        if(start>r || end<l) return tree[x][idx];
        if(l>=start && r<=end){
        	if(l!=r) {
	            temp_tree[x][idx*2] += val;
	            temp_tree[x][idx*2+1] += val;
        	}
        	System.out.println("변경 값 : "+x+" "+idx+" / "+l+" "+r+" "+tree[x][idx]+" "+val);
        	tree[x][idx] += val;
        	
            return tree[x][idx];
        }
        long val1 = update(x, idx*2, start, end, l, mid, val);
        long val2 = update(x, idx*2+1, start, end, mid+1, r, val);
        return tree[x][idx] = val1+val2;
    }
    
    public static void lazy_update(int x, int idx, int l, int r){
    	if(l==r) {
    		tree[x][idx] += temp_tree[x][idx];
    		temp_tree[x][idx] = 0;
    		return;
    	}
        tree[x][idx] += temp_tree[x][idx]*(r-l+1);
        temp_tree[x][idx*2] += temp_tree[x][idx];
        temp_tree[x][idx*2+1] += temp_tree[x][idx];
        temp_tree[x][idx] = 0;
//        System.out.println(x+" "+idx+" / "+l+" "+r+" / "+temp_tree[x][idx*2]+" "+temp_tree[x][idx]);
        return;
    }
    
    public static void get(int x, int idx, int start, int end, int l, int r){
        int mid = (l+r)/2;
        if(temp_tree[x][idx]!=0){
            lazy_update(x, idx, l, r);
        }
        if(start>r || end<l) return;
        if(l==r) {
        	array[x][l] += tree[x][idx]; 
        	System.out.println("끝 : "+x+" "+l+" "+r+" / "+array[x][l]+" "+tree[x][idx]+" "+temp_tree[x][idx]);
        	return;
        }
        get(x,idx*2,start,end,l,mid);
        get(x,idx*2+1,start,end,mid+1,r);
        return;
    }
    
    static void dfs(int x, int idx,int l, int r) {
    	
    	if(l==r) {
    		System.out.println(x+" / "+l+" "+r+" / "+idx+" / "+tree[x][idx]+" / "+temp_tree[x][idx]);
    		return;
    	}
    	if(l>N || r<=0) return;
    	dfs(x,idx*2, l, (l+r)/2);
    	dfs(x,idx*2+1, ((l+r)/2)+1, r);
    	
    }
}
