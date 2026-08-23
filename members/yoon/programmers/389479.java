import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int totalTime = players.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 서버 시작 시간 저장

        for (int i = 0; i < 24; i++) {
            // 서버 종료 관리
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }

            // 서버 인원 수 계산
            int currentPlayer = players[i];
            int currentServerAmount = pq.size() + 1;
            int currentMaxPlayer = currentServerAmount * m; // 같아지면 서버 증설해야 함!

            // 서버 증설이 필요한 상황
            if (currentPlayer >= currentMaxPlayer) {
                int needServerAmount = (currentPlayer / m) + 1;
                int newServerAmount = needServerAmount - currentServerAmount;

                for (int j = 0; j < newServerAmount; j++) {
                    pq.add(i + k);
                }

                answer += newServerAmount;
            }
        }

        return answer;
    }
}
