import java.util.*;

class Solution {
	List<List<Integer>> network = new ArrayList<>(); 
	int cnt = 0;
	boolean[] visited;
    public int solution(int n, int[][] computers) {
		//network 추가		
		for(int i=0;i<n;i++) {
			network.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(computers[i][j]==1) {
					network.get(i).add(j);
				}
			}		
		}
		//방문 확인
		visited = new boolean[n];
		for(int i=0;i<n;i++ ) {
			if(!visited[i]) {
				dfs(i,network);
				//독립된 네트워크가 만들어 질때마다 cnt 추가
				cnt++;
			}
		}
		return cnt;
	}
	public void dfs(int start, List<List<Integer>> current) {
		visited[start] = true;
		for(int next : current.get(start)) {
			if(!visited[next]) {
				dfs(next,current);
			}
		}
	}
}