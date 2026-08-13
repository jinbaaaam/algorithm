import java.util.*;
class Solution {
    String begin;
    String target;
    String[] words;
    boolean[] visited;
    
    class Node {
		String word;
		int cnt;
		Node(String word, int cnt) {
			this.word=word;
			this.cnt=cnt;
		}
	}
    
    Deque<Node> deque = new ArrayDeque<>(); 
    
    public int solution(String begin, String target, String[] words) {
        this.begin=begin;
        this.target=target;
        this.words=words;
        int answer = 0;
        
        int flag=0;
		for(String word : words) {
			if(target.equals(word)) flag=1;
		}
		if(flag==0) return answer;
        
        
        visited = new boolean[words.length];
		deque.offer(new Node(begin,0));
        
        while(!deque.isEmpty()) {
			Node current=deque.poll();
			if(current.word.equals(target)) {
				answer=current.cnt;
			}
			for(int i=0;i<words.length;i++) {
                if(visited[i]) continue;
				if(check(current.word, words[i])) {
					visited[i]=true;
					deque.offer(new Node(words[i],current.cnt+1));
				}
			}
		}
        return answer;
    }
    
    public static boolean check(String a, String b) {
		int k=0;
		int n=a.length();
		for(int i=0;i<n;i++) {
			if(a.charAt(i)==b.charAt(i)) k++;
		}
		if(k==n-1) return true;
		else return false;
    }
}