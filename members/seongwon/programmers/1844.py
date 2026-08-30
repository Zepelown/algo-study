from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solution(maps):
    n, m = len(maps), len(maps[0])
    queue = deque([(0, 0, 1)])
    maps[0][0] = 0

    while queue:
        x, y, dist = queue.popleft()

        if x == n - 1 and y == m - 1:
            return dist

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1:
                maps[nx][ny] = 0
                queue.append((nx, ny, dist + 1))

    return -1