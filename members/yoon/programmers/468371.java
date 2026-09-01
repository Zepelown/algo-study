class Solution {
    public int solution(int[][] signals) {
        long limit = 1;
        for (int[] signal : signals) {
            int period = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, period);
        }

        for (long time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int green = signal[0];
                int yellow = signal[1];
                int period = signal[0] + signal[1] + signal[2];
                long position = (time - 1) % period;

                if (position < green || position >= green + yellow) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return (int) time;
            }
        }

        return -1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
