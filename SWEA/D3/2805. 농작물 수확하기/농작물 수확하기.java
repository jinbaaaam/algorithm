import java.io.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int idx = 1; idx <= T; idx++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			int sumAll = 0;
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j) - '0';
					sumAll += arr[i][j];
				}
			}

			// index값 n/2 비교
			int sumOut = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i + j < n / 2 && i + j >= 0) || ((n - 1 - i) + j < n / 2 && (n - 1 - i) + j >= 0)
							|| (i + (n - 1 - j) < n / 2 && i + (n - 1 - j) >= 0)
							|| ((n - 1 - i) + (n - 1 - j) < n / 2 && (n - 1 - i) + (n - 1 - j) >= 0)) {
						sumOut += arr[i][j];
					}
				}
			}
			sb.append("#").append(idx).append(" ").append(sumAll - sumOut).append("\n");
		}
		System.out.println(sb);
	}
}