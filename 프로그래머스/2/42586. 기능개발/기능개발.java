import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> result = new ArrayDeque<>();

		for (int i = 0; i < progresses.length; i++) {
			int tmp = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
			deque.addLast(tmp);
		}
		System.out.println(deque);
		
		while (!deque.isEmpty()) {
			//기준 day
			int max = deque.pollFirst();
			int cnt=1;
			//기준 day 보다 작으면 함께 배포
			while(!deque.isEmpty() && deque.peekFirst() <= max) {
				deque.pollFirst();
				cnt++;
			}
			result.add(cnt);
		}
		
		int k=result.size();
		answer = new int[k];
		for (int i = 0; i < k; i++) {
			answer[i] = result.pollFirst();
		}
        return answer;
	}
}