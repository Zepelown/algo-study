class Solution {
    long answer;
    int distLimit;
    int splitLimit;
    int[] childList = {2, 3};

    public int solution(int dist_limit, int split_limit) {
        this.distLimit = dist_limit;
        this.splitLimit = split_limit;
        this.answer = 1;

        dfs(0, 1, 0, 1);

        return (int) answer;
    }

    void dfs(long leaf, long cur, long used, long score) {
        answer = Math.max(answer, leaf + cur);

        long remain = distLimit - used;
        if (remain == 0) {
            return;
        }

        for (int child : childList) {
            long nextScore = score * child;
            // 분배도 제한 초과 -> 이 깊이는 더 이상 확장 불가
            if (nextScore > splitLimit) {
                continue;
            }

            // 현재 cur개 중 실제로 분배 노드를 사용할 수 있는 개수
            long distributeCount = Math.min(cur, remain);

            // 사용하지 못한 노드는 리프로 확정
            long nextLeaf = leaf + (cur - distributeCount);
            // 분배 노드로 사용한 노드들은 다음 깊이에서 자식 노드를 만듦
            long nextCur = distributeCount * child;
            // 사용한 분배 노드 수 갱신
            long nextUsed = used + distributeCount;

            dfs(nextLeaf, nextCur, nextUsed, nextScore);
        }
    }
}
