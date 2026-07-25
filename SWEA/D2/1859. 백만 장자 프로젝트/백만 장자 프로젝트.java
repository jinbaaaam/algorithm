import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int T;
	static int n;
	static int a[];
	public static int findMaxIndex(int[] arr,int start) {
		int maxIndex=start;
		int maxValue=arr[start];
		for(int i=start;i<n;i++) {
			if(maxValue<arr[i]) {
				maxValue=arr[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	public static long calc(int[] arr,int start,int end) {
		long resultcalc=0;
		for(int i=start;i<end;i++) {
			resultcalc+=a[end]-a[i];
		}
		return resultcalc;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		String[] res=new String[T];
		for (int idx = 0;idx<T;idx++) {
			n=Integer.parseInt(br.readLine());
			a=new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			long result=0;
			int start=0;
			while(start<n) {
				int maxI=findMaxIndex(a,start);
				result+=calc(a,start,maxI);
				start=maxI+1;
			}
			res[idx]=("#"+(idx+1)+" "+result);
		}
		for(String str : res)
			System.out.println(str);
	}
}