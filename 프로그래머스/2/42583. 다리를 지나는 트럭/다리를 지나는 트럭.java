import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> bridge = new ArrayDeque<>();
		Deque<Integer> enterTime = new ArrayDeque<>();
		
		for(int i : truck_weights) {
			deque.addLast(i);
		}
		int cnt=0;
		//다리에 트럭이 있거나, 대기 중 트럭이 있다면 계속 반복
		while(!deque.isEmpty() || !bridge.isEmpty()) {
			//1초 경과
			cnt++;
			
			//다리 맨 앞에 트럭이 내릴 시간인지
			if(!bridge.isEmpty() && cnt-enterTime.peekFirst() == bridge_length) {
				bridge.pollFirst();
				enterTime.pollFirst();
			}			
			//새 트럭이 다리에 올라갈 수 있는지
			if(!deque.isEmpty()) {
				int sum=0;
				for(int b : bridge) {
					sum+=b;
				}
				//현재 무게+들어올 트럭 무게 <= 견딜 수 있는 무게
				if(sum+deque.peekFirst()<=weight) {
					bridge.addLast(deque.pollFirst());
					enterTime.addLast(cnt);
				}
			}
		}
        return cnt;
	}
}