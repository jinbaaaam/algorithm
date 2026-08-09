import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer=0;
        Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			deque.addLast(i);
		}

		int cnt = 0;
		while (!deque.isEmpty()) {
			int idx = deque.pollFirst();
			int flag = 0;
			for (int nextIdx : deque) {
				if (priorities[nextIdx] > priorities[idx]) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 1) {
				deque.addLast(idx);
			} else {
				cnt++;
				if(idx==location) {
					answer=cnt;
					break;
				}
			}
		}
        return answer;
	}
}