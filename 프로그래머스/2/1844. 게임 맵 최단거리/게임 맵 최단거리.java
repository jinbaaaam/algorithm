import java.util.*;

class Solution {
    int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };
    boolean[][] visited;
    int n;
    int m;
    public boolean checkBound(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
    }
    public int solution(int[][] maps) {
		Deque<Integer[]> deque = new ArrayDeque<>();
        n=maps.length;
        m=maps[0].length;         
		visited = new boolean[n][m];
		visited[0][0]=true;
		deque.offer(new Integer[]{0,0,1});
		
		while(!deque.isEmpty()) {
			Integer[] current = deque.poll();
			int x = current[0];
			int y = current[1];
			int dist=current[2];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(x==n-1 && y==m-1) {
					return dist;
				}
				
				if(!checkBound(nx,ny)) continue;
				
				if(visited[nx][ny]) continue;
				
				if(maps[nx][ny]==1) {
					visited[nx][ny]=true;
					deque.offer(new Integer[] {nx,ny,dist+1});
				}
			}
		}
        return -1;
	}
}
/*
class Solution {
    
    int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };
	int n;
	int m;
	boolean[][] visited;
	int min = Integer.MAX_VALUE;
    int[][] maps;
	public boolean checkBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
    public void dfs(int x, int y, int depth) {
		if (x == n - 1 && y == m - 1) {
			min = Math.min(min,depth);
			return;
		}
        if (depth>=min) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (checkBound(nx, ny)) {
				if (maps[nx][ny]==1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					dfs(nx, ny, depth + 1);
                    visited[nx][ny] = false;
				}
			}
		}
	}
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps=maps;
        n=maps.length;
		m=maps[0].length;
        // 갈 수 없는 곳 true
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maps[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		dfs(0, 0, 1);
        answer=(min==Integer.MAX_VALUE) ? -1 : min;
        return answer;
    }
}
*/