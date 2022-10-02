'''
안전거리: 아기상어와의 거리 
거리   : [n+1, shark)
이동가능: 8방향 

상어 기준으로 거리 측정
'''
import queue

def bfs(y, x):
    q = queue.Queue()
    q.put((y, x))
    visited[y][x] = 1

    while not q.empty():
        y, x = q.get()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < M) and (0 <= ny < N) and (space[ny][nx] != 1) and (visited[ny][nx] != 1):
                # 최초 탐색 or 가장 가까운 안전거리로 갱신 
                if  space[ny][nx] == 0 or space[y][x] + 1 < space[ny][nx]: 
                    space[ny][nx] = space[y][x] + 1
                    visited[ny][nx] = 1
                    q.put((ny,nx))

N, M = map(int, input().split())
space = []
dx = [0, 0, 1, -1, 1, 1, -1, -1]
dy = [1, -1, 0, 0, -1, 1, -1, 1]
answer = -1

for _ in range(N): 
    space.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        visited = [[0 for _ in range(M)] for _ in range(N)]
        if space[i][j] == 1:
            bfs(i, j)

for i in range(N):
    for j in range(M):
        answer = max(answer, space[i][j])