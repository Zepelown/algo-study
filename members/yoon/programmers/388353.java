import java.util.*;

class Solution {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] board = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], '0');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            char type = request.charAt(0);

            if (request.length() == 2) {
                removeByCrane(board, type);
            } else {
                removeByForklift(board, type);
            }
        }

        int remain = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] != '0') {
                    remain++;
                }
            }
        }

        return remain;
    }

    private void removeByCrane(char[][] board, char type) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == type) {
                    board[i][j] = '0';
                }
            }
        }
    }

    private void removeByForklift(char[][] board, char type) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] accessible = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        accessible[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + DX[dir];
                int ny = y + DY[dir];

                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                    continue;
                }

                if (accessible[nx][ny] || board[nx][ny] != '0') {
                    continue;
                }

                accessible[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

        boolean[][] toRemove = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != type) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + DX[dir];
                    int ny = j + DY[dir];

                    if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                        continue;
                    }

                    if (accessible[nx][ny]) {
                        toRemove[i][j] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (toRemove[i][j]) {
                    board[i][j] = '0';
                }
            }
        }
    }
}
