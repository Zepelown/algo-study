import heapq

def solution(op):
    s = {}
    min_heap = []
    max_heap = []

    for item in op:
        ins, val = item.split(' ')
        num = int(val)

        if ins == 'I':
            s[num] = s.get(num, 0) + 1
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
        else:
            if not s:
                continue

            if num == 1: # 최댓값
                while -max_heap[0] not in s:
                    heapq.heappop(max_heap)
                target = -heapq.heappop(max_heap)
            else:
                while min_heap[0] not in s:
                    heapq.heappop(min_heap)
                target = heapq.heappop(min_heap)

            s[target] -= 1
            if s[target] == 0:
                s.pop(target)

    return [max(s), min(s)] if s else [0, 0]