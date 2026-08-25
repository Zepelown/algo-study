class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answers = [0] * len(temperatures)
        stack = []  # 아직 더 따뜻한 날을 못 찾은 인덱스들

        for i, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                prev = stack.pop()
                answers[prev] = i - prev
            stack.append(i)

        return answers