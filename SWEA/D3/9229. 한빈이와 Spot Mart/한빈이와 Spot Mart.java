import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        // 빠른 입출력을 위해 BufferedReader와 StringBuilder 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            // 1. 과자 무게 오름차순 정렬
            Arrays.sort(arr);
            
            int maxWeight = -1; // 과자 2봉지를 고를 수 없는 경우 기본값 -1
            int left = 0;
            int right = N - 1;
            
            // 2. 투 포인터로 최대 무게 탐색
            while(left < right) {
                int sum = arr[left] + arr[right];
                
                if(sum <= M) {
                    // M 이하인 경우, 최댓값 갱신 후 합을 더 키우기 위해 left 이동
                    maxWeight = Math.max(maxWeight, sum);
                    left++;
                } else {
                    // M을 초과한 경우, 무게를 줄이기 위해 right 이동
                    right--;
                }
            }
            
            // 출력 양식에 맞게 결과 저장
            sb.append("#").append(test_case).append(" ").append(maxWeight).append("\n");
        }
        System.out.print(sb.toString());
    }
}