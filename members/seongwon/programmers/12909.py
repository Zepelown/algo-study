def solution(s):
    cnt = 0
    for c in s:
        if c == '(':
            cnt += 1
        elif c == ')':
            if cnt >= 1:
                cnt -= 1
            else:
                return False

    return cnt == 0
