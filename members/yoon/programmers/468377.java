import java.util.*;

class Solution {
    private int n;
    private int[][] cost, hint;

    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        n = cost.length;
        this.cost = cost;
        this.hint = hint;
        return search(0, new int[n]);
    }

    private int search(int stage, int[] hints) {
        if (stage == n) {
            return 0;
        }

        int availableHints = Math.min(hints[stage], cost[stage].length - 1);
        // 해당 스테이지에 보유 중인 모든 힌트를 사용하는 것이 맞음
        int clearCost = cost[stage][availableHints];
        // 힌트 구매 X
        int result = clearCost + search(stage + 1, hints);
        // 힌트 구매
        // 마지막 스테이지에선 힌트 구매 X
        if (stage < n - 1) {
            int[] nextHints = hints.clone();

            for (int i = 1; i < hint[stage].length; i++) {
                int hintNumber = hint[stage][i];
                nextHints[hintNumber - 1]++;
            }
            int hintBuyCost = hint[stage][0] + clearCost + search(stage + 1, nextHints);
            result = Math.min(result, hintBuyCost);
        }

        return result;
    }
}
