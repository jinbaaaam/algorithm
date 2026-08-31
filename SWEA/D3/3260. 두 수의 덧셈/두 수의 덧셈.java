import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            BigInteger result = a.add(b);
            sb.append("#"+test_case+" "+result);
            sb.append("\n");
		}
        System.out.println(sb);
	}
}