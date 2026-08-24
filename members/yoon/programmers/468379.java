import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] grid = new int[m][n];

        // 빗방울 시각 기록
        for (int i = 0; i < drops.length; i++) {
            grid[drops[i][0]][drops[i][1]] = i + 1;
        }

        // 기록 안된 빗방울 INF 처리
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                grid[i][j] = Integer.MAX_VALUE;
            }
        }

        // 슬라이딩 윈도우 초기화
        int[][] rowMins = new int[m][n - w + 1];

        // 가로 방향 슬라이딩
        for (int i = 0; i < m; i++) {
            Deque<Integer> dequeue = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                // 오름차순 유지를 위한 나보다 큰 값 제거
                while (!dequeue.isEmpty() && grid[i][dequeue.peekLast()] >= grid[i][j]) {
                    dequeue.pollLast();
                }

                dequeue.offerLast(j);

                if (dequeue.peekFirst() <= j - w) {
                    dequeue.pollFirst();
                }

                if (j >= w - 1) {
                    rowMins[i][j - w + 1] = grid[i][dequeue.peekFirst()];
                }
            }
        }

        // 세로 방향 데이터 초기화
        int[][] finalMins = new int[m - h + 1][n - w + 1];

        // rowMins을 세로 방향 슬라이딩
        for (int i = 0; i < n - w + 1; i++) {
            Deque<Integer> dequeue = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                // 오름차순 유지
                while (!dequeue.isEmpty() && rowMins[dequeue.peekLast()][i] >= rowMins[j][i]) {
                    dequeue.pollLast();
                }

                dequeue.offerLast(j);

                // 슬라이딩 윈도우에서 벗어난 인덱스 제거
                if (dequeue.peekFirst() <= j - h) {
                    dequeue.pollFirst();
                }

                // 결과 기록
                if (j >= h - 1) {
                    finalMins[j - h + 1][i] = rowMins[dequeue.peekFirst()][i];
                }
            }
        }

        int max = 0;
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < finalMins.length; i++) {
            for (int j = 0; j < finalMins[0].length; j++) {
                if (max < finalMins[i][j]) {
                    max = finalMins[i][j];
                    maxX = j;
                    maxY = i;
                }
            }
        }

        int[] answer = {maxY, maxX};
        return answer;
    }
}
