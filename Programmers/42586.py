from collections import deque

def solution(progresses, speeds):
    answer = []

    time = 0
    queue = deque(progresses)
    s = deque(speeds)
    cnt = 0
    while queue:
        time += 1
        while queue and queue[0] + s[0]*time >= 100:
            cnt += 1
            queue.popleft()
            s.popleft()
        if cnt:
            answer.append(cnt)
            cnt = 0
    return answer
