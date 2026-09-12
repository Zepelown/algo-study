class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int column = (num - 1) % w;
        if (row % 2 == 1) {
            column = w - 1 - column;
        }

        int lastRow = (n - 1) / w;
        int lastRowCount = (n - 1) % w + 1;
        int answer = lastRow - row + 1;

        // 마지막 층에서 같은 열에 상자가 없으면 제외한다.
        if (lastRow % 2 == 0 && column >= lastRowCount
                || lastRow % 2 == 1 && column < w - lastRowCount) {
            answer--;
        }

        return answer;
    }
}
