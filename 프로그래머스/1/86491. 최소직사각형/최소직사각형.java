import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = 0;
		int y = 0;

		// 큰 숫자 앞에 오게
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] < sizes[i][1]) {
				int tmp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = tmp;
			}
		}

		// 가로 길이 최대:sizes[0][0]
		Arrays.sort(sizes, (o1, o2) -> o2[0] - o1[0]);
		x = sizes[0][0];

		// 세로 길이 최대:sizes[0][1]
		Arrays.sort(sizes, (o1, o2) -> o2[1] - o1[1]);
		y = sizes[0][1];

		answer = x * y; // 최댓값
        
        return answer;
    }
}