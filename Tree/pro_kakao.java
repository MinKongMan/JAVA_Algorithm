package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class pro_kakao {
	static class pro implements Comparable<pro>{
		int val;
		int x;
		int y;
		pro(int x, int y, int val){
			this.val = val;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pro arg0) {
			// TODO Auto-generated method stub
			return this.x-arg0.x;
		}
		
	}
	static class position{
		int x;
		int y;
		position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class dfs{
		int left;
		int right;
		int val;
		dfs(int left, int right, int val){
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}
	static ArrayList<pro> ar = new ArrayList<pro>();
	static ArrayList<ArrayList<Integer>> y_p = new ArrayList<>();
	static int[] visit;
	static dfs[] node;
	static position[] posit;
	static PriorityQueue<pro> pq = new PriorityQueue<pro>();
	static LinkedList<pro> link = new LinkedList<pro>();
	static int[][] answer;
	static int count = 0;
	
	public int[][] solution(int[][] nodeinfo) {
		answer = new int[2][nodeinfo.length];
		visit = new int[nodeinfo.length+1];
		posit = new position[nodeinfo.length+1];
		node = new dfs[nodeinfo.length+1];
		for(int i = 1; i<=nodeinfo.length; i++) {
			int x = nodeinfo[i-1][0];
			int y = nodeinfo[i-1][1];
			posit[i] = new position(x,y);
			node[i] = new dfs(-1,-1,i);
			pq.add(new pro(x,y,i));
		}
		int a = -1;
		int index = -1;
		while(!pq.isEmpty()) {
			pro hyo = pq.poll();
//			if(a!=hyo.y) {
//				index++;
//				y_p.add(new ArrayList<Integer>());
//				y_p.get(index).add(hyo.x);
//				a = hyo.y;
//			}
//			else {
//				y_p.get(index).add(hyo.x);
//			}
			link.add(new pro(hyo.x,hyo.y,hyo.val));
			
		}
		int root = 0;
		for(int i = 0; i<link.size(); i++) {
			int l = -1;
			int r = -1;
			int l_h = -1;
			int r_h = -1;
			for(int j = i-1; j>=0; j--) {
				if(link.get(j).y>link.get(i).y) {
					l = link.get(j).val;
					l_h = link.get(j).y;
					break;
				}
			}
			for(int j = i+1; j<link.size(); j++) {
				if(link.get(j).y>link.get(i).y) {
					r = link.get(j).val;
					r_h = link.get(j).y;
					break;
				}
			}
			System.out.println(i+" "+l+" "+r+" "+link.get(i).val);
			if(l==-1 && r==-1) {
				root = link.get(i).val;
			}
			else if(l==-1 && r!=-1) {
				node[r].left = link.get(i).val;
			}
			else if(r==-1 && l!=-1) {
				node[l].right = link.get(i).val;
			}
			else {
				if(l_h<r_h) {
					node[l].right = link.get(i).val;
				}
				else {
					node[r].left = link.get(i).val;
				}
			}
		}
		dfs1(root);
		count = 0;
		dfs2(root);
        return answer;
    }
	static void dfs1(int a) {
		System.out.println(a+" ?");
		answer[0][count] = a;
		int left = node[a].left;
		int right = node[a].right;
		System.out.println(a+" "+left+" "+right+" "+count);
		if(left!=-1) {
			count++;
			System.out.println(a+" "+left);
			dfs1(left);
		}
		System.out.println(count+"天天天天天天天");
		if(right!=-1) {
			count++;
			System.out.println(a+" "+right);
			dfs1(right);
		}
		
	}
	static void dfs2(int a) {
		int left = node[a].left;
		int right = node[a].right;
		if(left!=-1) dfs2(left);
		if(right!=-1) dfs2(right);
		answer[1][count] = a;
		System.out.println(a);
		count++;
	}
	public static void main(String[] args) {
        answer = new int[2][10];
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		visit = new int[nodeinfo.length+1];
		posit = new position[nodeinfo.length+1];
		node = new dfs[nodeinfo.length+1];
		for(int i = 0; i<nodeinfo.length; i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];
			posit[i+1] = new position(x,y);
			node[i+1] = new dfs(-1,-1,i+1);
			pq.add(new pro(x,y,i+1));
		}
		int a = -1;
		int index = -1;
		while(!pq.isEmpty()) {
			pro hyo = pq.poll();
			System.out.println(hyo.x+" "+hyo.y+" "+hyo.val);
//			if(a!=hyo.y) {
//				index++;
//				y_p.add(new ArrayList<Integer>());
//				y_p.get(index).add(hyo.x);
//				a = hyo.y;
//			}
//			else {
//				y_p.get(index).add(hyo.x);
//			}
			link.add(new pro(hyo.x,hyo.y,hyo.val));
		}
		int root = 0;
		for(int i = 0; i<link.size(); i++) {
			int l = -1;
			int r = -1;
			int l_h = -1;
			int r_h = -1;
			for(int j = i-1; j>=0; j--) {
				if(link.get(j).y>link.get(i).y) {
					l = link.get(j).val;
					l_h = link.get(j).y;
					break;
				}
			}
			for(int j = i+1; j<link.size(); j++) {
				if(link.get(j).y>link.get(i).y) {
					r = link.get(j).val;
					r_h = link.get(j).y;
					break;
				}
			}
			System.out.println(i+" "+l+" "+r+" "+link.get(i).val);
			if(l==-1 && r==-1) {
				root = link.get(i).val;
			}
			else if(l==-1 && r!=-1) {
				node[r].left = link.get(i).val;
			}
			else if(r==-1 && l!=-1) {
				node[l].right = link.get(i).val;
			}
			else {
				if(l_h<r_h) {
					node[l].right = link.get(i).val;
				}
				else {
					node[r].left = link.get(i).val;
				}
			}
		}
		dfs1(root);
		count = 0;
		System.out.println("天天天天天天天天天天天");
		dfs2(root);
		for(int i = 0; i<2; i++) {
			System.out.println(i);
			for(int j = 0; j<=9; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
}
