import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// N의 범위가 최대 10^12이므로 int가 아닌 long으로 받아야 합니다.
			long N = Long.parseLong(br.readLine());
			long ans = 0;
			
			while (N > 2) {
				long root = (long) Math.sqrt(N);
				
				// Case 1: N이 이미 완전제곱수인 경우
				if (root * root == N) {
					N = root;
					ans++;
				} 
				// Case 2: N이 완전제곱수가 아닌 경우
				else {
					long nextRoot = root + 1;
					long nextSquare = nextRoot * nextRoot;
					
					// 다음 제곱수까지 1씩 더하는 횟수 축적
					ans += (nextSquare - N);
					// 다음 제곱수에서 루트를 취해 값을 갱신하고 연산 횟수(+1) 반영
					N = nextRoot;
					ans++;
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

}