import java.util.*;
import java.io.*;

class Solution{

	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int[][] map;
	public static boolean[][] visited;
	public static int x1;
	public static int y1;
	public static int x2;
	public static int y2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					if (map[i][j] == 2) {
						x1 = i;
						y1 = j;
					} else if (map[i][j] == 3) {
						x2 = i;
						y2 = j;
					}
				}
			}

			Queue<int[]> q = new ArrayDeque<>();
			int flag = 0;
			visited = new boolean[16][16];
			q.offer(new int[] { x1, y1 });

			while (!q.isEmpty()) {
				int[] current = q.poll();
				int x = current[0];
				int y = current[1];
				if (x == x2 && y == y2)
					flag = 1;

				if (flag == 1)
					break;

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
			System.out.println("#" + test_case + " " + flag);
		}
	}
}