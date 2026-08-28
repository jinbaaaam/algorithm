import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> l1 = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				l1.add(Integer.parseInt(st.nextToken()));
			}
						
			int m = Integer.parseInt(br.readLine());
			List<String> l2 = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int k = st.countTokens();
			for(int i=0;i<k;i++) {
				l2.add(st.nextToken());
			}
			int idx=0;
			int l2Size=l2.size();
			while(idx<l2Size) {
				char c = l2.get(idx).charAt(0);
				idx++;
				if(c=='I') {
					int location=Integer.parseInt(l2.get(idx));
					idx++;
					int len=Integer.parseInt(l2.get(idx));
					idx++;
					
					for(int i=idx;i<idx+len;i++) {
						int tmp = Integer.parseInt(l2.get(i));
						l1.add(location++,tmp);						
					}
					idx+=len;
				} else {
					int location=Integer.parseInt(l2.get(idx));
					idx++;
					int len=Integer.parseInt(l2.get(idx));
					idx++;
					
					for(int i=location;i<location+len;i++) {
						l1.remove(location);		
					}
				}
			}
			System.out.print("#"+test_case);
			for(int i=0;i<10;i++) {
				System.out.print(" "+l1.get(i));
			}
			System.out.println();
		}
		
	}

}