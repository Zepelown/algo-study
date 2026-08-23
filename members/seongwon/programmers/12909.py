def solution(s):
    cnt = 0
    for i, j in enumerate(list(s)):
        if i == 0 and j == ')':
            return False
        if j == '(':
            cnt += 1
        elif j == ')':
            if cnt >= 1:
                cnt -= 1
            else:
                return False

    if cnt != 0:
        return False

    return True
