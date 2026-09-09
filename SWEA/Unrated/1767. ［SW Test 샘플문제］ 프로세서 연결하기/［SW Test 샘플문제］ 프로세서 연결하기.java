import java.util.*;
import java.io.*;

public class Solution {

	public static int N, min;
	public static int[][] arr, cores;
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int cnt;
	public static int maxConnected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			cnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						cnt++;
						visited[i][j] = true;
					}
				}
			}
			cores = new int[cnt][2];
			maxConnected = 0;
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						cores[cnt][0] = i;
						cores[cnt++][1] = j;
					}
				}
			}

			dfsCores(0, 0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	public static void dfsCores(int idx, int connected, int sum) {
		if (idx == cnt) {
			if (connected > maxConnected) {
				maxConnected = connected;
				min = sum;
			} else if (connected == maxConnected) {
				min = Math.min(min, sum);
			}
			return;
		}

		int x = cores[idx][0];
		int y = cores[idx][1];

		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
			dfsCores(idx + 1, connected, sum);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			boolean can = true;
			int len = 0;
			while (nx >= 0 && nx < N && ny >= 0 && ny < N) {

				if (visited[nx][ny]) {
					can = false;
					break;
				}
				len++;
				nx += dx[dir];
				ny += dy[dir];
			}

			if (can) {
				nx = x + dx[dir];
				ny = y + dy[dir];

				while (nx >= 0 && nx < N && ny >= 0 && ny < N) {

					visited[nx][ny] = true;

					nx += dx[dir];
					ny += dy[dir];
				}
				dfsCores(idx + 1, connected + 1, sum + len);

				nx = x + dx[dir];
				ny = y + dy[dir];

				while (nx >= 0 && nx < N && ny >= 0 && ny < N) {

					visited[nx][ny] = false;

					nx += dx[dir];
					ny += dy[dir];
				}
			}
		}
		dfsCores(idx + 1, connected, sum);
	}
}
