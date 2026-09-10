import java.util.*;
import java.io.*;

class Solution
{
    public static int N, S, result;
    public static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            S=Integer.parseInt(st.nextToken());
            arr = new int[N];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
            	arr[i]=Integer.parseInt(st.nextToken());
            }
            result=Integer.MAX_VALUE;
            dfs(0,0);
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
        System.out.println(sb);
	}
    public static void dfs(int idx, int sum)  {
        if(idx==N) {
            if(sum>=S) {
	            result=Math.min(result,sum-S);
            }
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}