class Solution {
    String word;
	char[] aeiou= {'A','E','I','O','U'};
	int cnt= 0;
	int answer= 0;
    
    public int solution(String word) {
        this.word=word;
        dfs("",0);
        return answer;
    }
    
    public void dfs(String s, int depth) {
		if(s.equals(word)) {
			answer=cnt;
		}
        if(depth>=aeiou.length) {
			return;
		}
        for(int i=0;i<aeiou.length;i++) {
			cnt++;
			dfs(s+aeiou[i],depth+1);
		}
    }
}