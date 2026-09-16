import java.util.*;
import java.io.*;

public class Solution {
	public static char[][] map;
	public static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static boolean[][] visited;
	public static int[][] countMap;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			countMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '*')
						visited[i][j] = true;
					else
						countMap[i][j] = getMineCount(i, j);
				}
			}
			int ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && countMap[i][j] == 0) {
						bfs(i, j);
						ans++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] == '.') {
						ans++;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	public static int getMineCount(int x, int y) {
		int cnt = 0;
		for (int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '*') {
				cnt++;
			}
		}
		return cnt;
	}

	public static void bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { startX, startY });
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int dir = 0; dir < 8; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				if (countMap[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
