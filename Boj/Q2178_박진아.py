'''
최소의 칸 수 
count: [start, end]
start: (0, 0)
end: (N-1, M-1)
'''
import sys
import queue

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():
    q = queue.Queue()
    q.put((0, 0))
    memo[0][0] = 1
   
    while not q.empty():
        y, x = q.get()
        if (y == N-1) and (x == M-1): break
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (0 <= ny < N) and (0 <= nx < M):
                if graph[ny][nx] == 0: continue 
                if memo[y][x] + 1 < memo[ny][nx]:
                    memo[ny][nx] = memo[y][x]+1
                    q.put((ny, nx))

N, M = map(int, input().split())
graph = [[] for _ in range(N)]
for i in range(N):
    row = input()
    for j in row:
        graph[i].append((int(j)))
    
memo = [[sys.maxsize for _ in range(M)] for _ in range(N)]
bfs()
print(memo[N-1][M-1])


