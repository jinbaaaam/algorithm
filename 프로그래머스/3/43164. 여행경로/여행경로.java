import java.util.*;
class Solution {
    boolean[] visited;
    Deque<String> deque = new ArrayDeque<>();
    String[] answer;
    boolean isFound = false;

    public String[] solution(String[][] tickets) {
        // 알파벳 사전 순 정렬
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        int n = tickets.length;
        visited = new boolean[n];
        answer = new String[n + 1];
        deque.offer("ICN");
        dfs("ICN", tickets, 0);

        return answer;
    }

    private void dfs(String current, String[][] tickets, int count) {
        if (isFound) return;
        if (count == tickets.length) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                answer[i] = deque.poll();
            }
            isFound = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                deque.offer(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                deque.pollLast();
                visited[i] = false;
            }
        }
    }
}