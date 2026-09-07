from collections import deque

def compare(word1, word2):
    cnt = 0
    for i in range(len(word1)):
        if word1[i] == word2[i]:
            cnt += 1
    
    return len(word1) - cnt == 1


def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    visited = [False] * len(words)
    
    while queue:
        cur_word, answer = queue.popleft()
        if cur_word == target:
            return answer
        
        for i in range(len(words)):
            if not visited[i] and compare(cur_word, words[i]):
                visited[i] = True
                queue.append((words[i], answer+1))
    
    
    return 0
    
