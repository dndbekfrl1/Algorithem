from collections import deque

n = int(input())
graph=[[] for i in range(n)]
res=[[0 for i in range(n)] for j in range(n)]

for i in range(n):
    arr = list(map(int, input().split()))
    for j in range(n):
        if arr[j]==1:
            graph[i].append(j)

def bfs(i):
    q=deque()
    visit=[0 for i in range(n)]
    q.append(i)
    
    while q:
        nexti=q.popleft()
        for j in graph[nexti]:
            if visit[j] == 0:
                visit[j]=1
                q.append(j)
    print(*visit)

for i in range(n):
    bfs(i)

