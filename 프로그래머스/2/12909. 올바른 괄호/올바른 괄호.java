import java.util.*;
class Solution {
    boolean solution(String s) {
		boolean answer = false;
		
		Deque<Character> deque = new ArrayDeque<>();
		
		int cnt1=0;
		int cnt2=0;
        int flag=0;
		for(int i=0;i<s.length();i++) {
			deque.addLast(s.charAt(i));
			if(s.charAt(i)=='(') {
				cnt1++;
			}
			else {
				cnt2++;
            }
            if (cnt1-cnt2<0) {
                flag=1;
            }
            
		}
        if(flag==1) {
            return answer;
        }
		if(deque.peekFirst()==')') {
			return answer;
		} else if(deque.peekLast()=='(') {
			return answer;
		} else {
			if(cnt1==cnt2) {
                answer=true;
				return answer;
			}
			else {
				return answer;
			}
		}
	}
}