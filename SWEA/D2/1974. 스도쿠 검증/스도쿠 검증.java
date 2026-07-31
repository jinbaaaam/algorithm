import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int idx = 1; idx <= T; idx++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int flag = 1;
			outer: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					Set<Integer> setRow = new HashSet<>();
					Set<Integer> setCol = new HashSet<>();
					Set<Integer> setArea = new HashSet<>();
					for (int k = 0; k < 9; k++) {
						if (!setRow.add(arr[i][k]) || !setCol.add(arr[k][j])
								|| !setArea.add(arr[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3])) {
							flag = 0;
							break outer;
						}
					}
				}
			}
			sb.append("#").append(idx).append(" ").append(flag).append("\n");
		}
		System.out.println(sb);
	}
}