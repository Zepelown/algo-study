import heapq

def solution(jobs):
    n = len(jobs)
    jobs = [[req, dur, i] for i, (req, dur) in enumerate(jobs)]
    jobs.sort()

    heap = []
    now, i, total, done = 0, 0, 0, 0

    while done < n:
        # 1. now까지 도착한 작업 전부 힙에 넣기
        while i < n and jobs[i][0] <= now:
            req, dur, idx = jobs[i]
            heapq.heappush(heap, (dur, req, idx))
            i += 1

        if heap:
            dur, req, idx = heapq.heappop(heap)
            total += now - req + dur
            now += dur
            done += 1
        else:
            now = jobs[i][0]
            pass

    return total // n