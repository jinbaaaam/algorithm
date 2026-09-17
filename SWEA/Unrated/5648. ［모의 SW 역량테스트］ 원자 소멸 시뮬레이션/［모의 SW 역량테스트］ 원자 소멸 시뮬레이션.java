import java.io.*;
import java.util.*;

public class Solution {

    public static int[][] atoms;

    // 상 하 좌 우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int N;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            // [x, y, 방향, 에너지]
            atoms = new int[N][4];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 4; j++) {

                    int value = Integer.parseInt(st.nextToken());

                    // x, y 좌표는 0.5 단위 충돌을 처리하기 위해 2배
                    if (j == 0 || j == 1) {
                        atoms[i][j] = value * 2;
                    } else {
                        atoms[i][j] = value;
                    }
                }
            }

            int result = 0;

            /*
             * 원래 좌표 범위 : -1000 ~ 1000
             * 2배 후 범위     : -2000 ~ 2000
             *
             * 한 번 이동할 때 0.5만큼 이동하는 것을
             * 좌표를 2배 했기 때문에 1칸 이동으로 표현한다.
             */
            for (int time = 0; time <= 4000; time++) {

                // 현재 시간에 각 좌표에 존재하는 원자 개수
                HashMap<Long, Integer> positionCount = new HashMap<>();

                // 1. 살아있는 모든 원자 이동
                for (int i = 0; i < N; i++) {

                    if (visited[i]) {
                        continue;
                    }

                    int dir = atoms[i][2];

                    atoms[i][0] += dx[dir];
                    atoms[i][1] += dy[dir];

                    // 충돌 가능 범위를 벗어난 원자는 더 이상 확인할 필요 없음
                    if (atoms[i][0] < -2000 || atoms[i][0] > 2000
                            || atoms[i][1] < -2000 || atoms[i][1] > 2000) {

                        visited[i] = true;
                        continue;
                    }

                    // (x, y)를 하나의 long 값으로 변환
                    long key = makeKey(atoms[i][0], atoms[i][1]);

                    positionCount.put(
                            key,
                            positionCount.getOrDefault(key, 0) + 1
                    );
                }

                // 2. 같은 좌표에 2개 이상 존재하면 모두 충돌
                for (int i = 0; i < N; i++) {

                    if (visited[i]) {
                        continue;
                    }

                    long key = makeKey(atoms[i][0], atoms[i][1]);

                    if (positionCount.get(key) >= 2) {

                        result += atoms[i][3];

                        visited[i] = true;
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(result)
              .append("\n");
        }

        System.out.print(sb);
    }

    // x, y 두 int 값을 하나의 long key로 변환
    public static long makeKey(int x, int y) {

        return ((long) x << 32)
                ^ (y & 0xffffffffL);
    }
}