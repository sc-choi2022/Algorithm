from collections import deque

def solution(n, edge):
    answer = 0

    nodes = [[] for _ in range(n+1)]
    visit = [0] * (n+1)

    for e in edge:
        a, b = e
        nodes[a].append(b)
        nodes[b].append(a)

    queue = deque([1])
    visit[1] = 1

    while queue:
        now = queue.popleft()

        for next in nodes[now]:
            if not visit[next]:
                queue.append(next)
                visit[next] = visit[now] + 1

    N = max(visit)

    answer = visit.count(N)
    return answer
