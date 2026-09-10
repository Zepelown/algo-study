import java.util.*;

class Solution {

    public int solution(String message, int[][] spoiler_ranges) {

        int answer = 0;
        int n = message.length();

        // ---------------------------------
        // 1. 각 문자가 어느 스포 구간인지 표시
        // ---------------------------------

        int[] spoilerIndex = new int[n];
        Arrays.fill(spoilerIndex, -1);

        for (int i = 0; i < spoiler_ranges.length; i++) {

            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            for (int j = start; j <= end; j++) {
                spoilerIndex[j] = i;
            }
        }


        // ---------------------------------
        // 2. 일반 단어 저장
        // ---------------------------------

        Set<String> normalWords = new HashSet<>();


        // ---------------------------------
        // 3. 몇 번째 스포에서 단어가 완전히
        //    공개되는지 저장
        // ---------------------------------

        List<List<String>> revealedAt = new ArrayList<>();

        for (int i = 0; i < spoiler_ranges.length; i++) {
            revealedAt.add(new ArrayList<>());
        }


        // ---------------------------------
        // 4. message의 단어를 하나씩 탐색
        // ---------------------------------

        for (int i = 0; i < n;) {

            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;

            while (i < n && message.charAt(i) != ' ') {
                i++;
            }

            int end = i - 1;

            String word = message.substring(start, end + 1);


            // 이 단어가 마지막으로 걸쳐있는 스포 구간
            int lastSpoiler = -1;

            for (int j = start; j <= end; j++) {

                if (spoilerIndex[j] != -1) {

                    lastSpoiler = Math.max(
                        lastSpoiler,
                        spoilerIndex[j]
                    );
                }
            }


            // 스포가 전혀 없는 일반 단어
            if (lastSpoiler == -1) {

                normalWords.add(word);

            } else {

                // 이 단어는 lastSpoiler를 클릭했을 때
                // 완전히 공개됨
                revealedAt.get(lastSpoiler).add(word);
            }
        }


        // ---------------------------------
        // 5. 스포를 왼쪽부터 하나씩 공개
        // ---------------------------------

        Set<String> revealedSpoilerWords = new HashSet<>();

        for (int i = 0; i < spoiler_ranges.length; i++) {

            for (String word : revealedAt.get(i)) {

                // 일반 영역에 등장한 적도 없고
                // 이전 스포에서 공개된 적도 없다
                if (!normalWords.contains(word)
                        && !revealedSpoilerWords.contains(word)) {

                    answer++;
                }

                // 중요 여부 상관없이
                // '공개된 스포 단어'에는 추가
                revealedSpoilerWords.add(word);
            }
        }

        return answer;
    }
}
