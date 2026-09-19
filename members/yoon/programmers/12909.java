class Solution {
    /**
     * 왼쪽 괄호의 개수를 균형값으로 관리한다.
     * 닫는 괄호가 먼저 나오면 즉시 올바르지 않은 문자열이다.
     *
     * Time: O(n), Space: O(1)
     */
    boolean solution(String s) {
        int balance = 0;

        for (char parenthesis : s.toCharArray()) {
            if (parenthesis == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
