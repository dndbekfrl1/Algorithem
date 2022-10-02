import sys
sys.setrecursionlimit(10 ** 6) # recursion error 방지

dx = [1, -1, 0, 0]
dy = [0, 0,-1, 1]

def dfs(y, x):
    visited[y][x] = 1
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= ny < H) and (0 <= nx < W) :
            if grid[ny][nx] == '#' and visited[ny][nx] == 0:
                dfs(ny, nx)

for _ in range(int(input())):
    H, W = map(int, input().split())
    grid = [list(input()) for _ in range(H)]
    visited = [[0 for _ in range(W)] for _ in range(H)]
    cnt = 0
    for i in range(H):
        for j in range(W):
            if grid[i][j] == '#' and visited[i][j] == 0:
                dfs(i, j)
                cnt += 1
    print(cnt)