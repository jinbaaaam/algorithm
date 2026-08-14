import java.util.*;
class Solution {
    boolean[] visited;
    // 탐색하면서 공항 경로를 실시간으로 담아둘 리스트
    ArrayList<String> currentRoute = new ArrayList<>();
    // 최종 정답을 복사해둘 배열
    String[] answer;
    // 정답을 찾았는지 확인하는 플래그
    boolean isFound = false;

    public String[] solution(String[][] tickets) {
        // 1. 알파벳 사전 순 정렬 (출발지가 같으면 도착지 기준)
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];

        // 2. 시작점인 "ICN"을 먼저 리스트에 추가
        currentRoute.add("ICN");
        
        // DFS 탐색 시작
        dfs("ICN", tickets, 0);

        return answer;
    }

    private void dfs(String current, String[][] tickets, int count) {
        // 이미 다른 앞선 경로에서 정답을 찾았다면 더 이상 탐색하지 않음 (가지치기)
        if (isFound) return;

        // 모든 티켓을 다 사용했다면 정답을 찾은 것임
        if (count == tickets.length) {
            // currentRoute 리스트의 값을 answer 배열로 고대로 복사
            for (int i = 0; i < currentRoute.size(); i++) {
                answer[i] = currentRoute.get(i);
            }
            isFound = true; // 정답 찾았다고 표시
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 아직 안 썼고, 출발지가 현재 공항과 같다면
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                currentRoute.add(tickets[i][1]); // 도착지 공항을 리스트 배열에 추가!

                // 다음 공항으로 탐색 진행
                dfs(tickets[i][1], tickets, count + 1);

                // [백트래킹] 길이 막혔다면, 넣었던 공항을 리스트 끝에서 다시 제거(삭제)
                currentRoute.remove(currentRoute.size() - 1);
                visited[i] = false;
            }
        }
    }
}