
import java.util.*;
import java.io.*;

public class Solution {
	public static int[][] map;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static boolean[][] visited;
	public static int N;
	public static int startX, startY, targetX, targetY;
	public static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = tmp.charAt(j) - '0';
					if (map[i][j] == 1) {
						visited[i][j] = true;
					} else if (map[i][j] == 2) {
						startX = i;
						startY = j;
					} else if (map[i][j] == 3) {
						targetX = i;
						targetY = j;
					}
				}
			}
			int answer=0;
			q = new ArrayDeque<>();

			q.offer(new int[] { startX, startY });
			visited[startX][startY] = true;
			while (!q.isEmpty()) {
				int[] current = q.poll();
				int x = current[0];
				int y = current[1];

				if (x == targetX && y == targetY) {
					answer=1;
					break;
				}

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (map[nx][ny] == 1)
						continue;

					if (visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });

				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
