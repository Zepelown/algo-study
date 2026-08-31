class Solution {

    int answer = 0;
    int n;
    int[][] q;
    int[] ans;

    int[] selected = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;

        dfs(1, 0);

        return answer;
    }

    private void dfs(int start, int depth) {

        // 숫자 5개를 모두 선택했다면
        if (depth == 5) {
            if (check()) {
                answer++;
            }
            return;
        }

        // start부터 n까지 하나씩 선택
        for (int i = start; i <= n; i++) {

            selected[depth] = i;

            // 다음 숫자는 i보다 큰 숫자부터 선택
            dfs(i + 1, depth + 1);
        }
    }

    private boolean check() {

        for (int i = 0; i < q.length; i++) {

            int count = 0;

            for (int x : selected) {
                for (int y : q[i]) {

                    if (x == y) {
                        count++;
                        break;
                    }
                }
            }

            if (count != ans[i]) {
                return false;
            }
        }

        return true;
    }
}
