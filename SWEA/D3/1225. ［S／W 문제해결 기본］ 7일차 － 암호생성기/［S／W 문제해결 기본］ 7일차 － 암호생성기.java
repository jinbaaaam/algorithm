import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int idx = 1; idx <= 10; idx++) {
			int[] arr = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int diff = 1;
			int tmp = 0;
			while (arr[7] > 0) {
				while (diff < 6 && arr[7] > 0) {
					tmp = arr[0] - diff;
					for (int i = 0; i < 7; i++) {
						arr[i] = arr[i + 1];
					}
					arr[7] = (tmp >= 0) ? tmp : 0;
					diff++;
				}
				diff = 1;
			}
			sb.append("#").append(n).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(arr[i]);
				if (i == 7)
					sb.append("\n");
				else
					sb.append(" ");
			}
		}
		System.out.println(sb);
	}
} 