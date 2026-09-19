class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int deadline = toMinutes(schedules[i]) + 10;
            boolean onTime = true;

            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7;
                if (day >= 5) {
                    continue;
                }

                if (toMinutes(timelogs[i][j]) > deadline) {
                    onTime = false;
                    break;
                }
            }

            if (onTime) {
                answer++;
            }
        }

        return answer;
    }

    private int toMinutes(int time) {
        return time / 100 * 60 + time % 100;
    }
}
