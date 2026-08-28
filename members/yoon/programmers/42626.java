import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add((double) i);
        }
        while (pq.size() >= 2 && pq.peek() < K) {
            double first = pq.poll();
            double second = pq.poll();
            double newFood = first + second * 2;
            pq.add(newFood);
            answer++;
        }

        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
