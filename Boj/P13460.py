'''
실패
1. 파란 구슬 통과
2. 빨, 파 모두 통과
3. 10 초과

움직이기
- 상하좌우
- 더 이상 구슬이 움직이지 않을 때까지
'''
import sys
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
N, M = map(int, sys.stdin.readline().split())
redX, redY, blueX, blueY = -1, -1, -1, -1
maze = [sys.stdin.readline().strip() for _ in range(N)]

def moveBall(x, y, dir):
    count = 0
    while maze[y + dy[dir]][x + dx[dir]] != '#':
        y += dy[dir]
        x += dx[dir]
        count += 1
        if maze[y][x] == 'O': break

    return x, y, count

def bfs(redX, redY, blueX, blueY):
    q = deque()
    visited = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
    # 왜 4차원 배열로 방문여부를 체크해야하는가?
    # 빨간색 구슬의 좌표는 이전과 같을지라도 파란색 구슬의 좌표가 다르다면 다른 상황이기 때문이다. 
    q.append((redX, redY, blueX, blueY, 1))
    visited[redY][redX][blueY][blueX] = True

    while q:
        curRedX, curRedY, curBlueX, curBlueY, depth = q.popleft()
        if depth > 10: 
            print(-1)
            return

        for i in range(4):
            nextRedX, nextRedY, redCount = moveBall(curRedX, curRedY, i)
            nextBlueX, nextBlueY, blueCount = moveBall(curBlueX, curBlueY, i)

            if maze[nextBlueY][nextBlueX] == 'O': continue

            if maze[nextRedY][nextRedX] =='O':
                print(depth)
                return

            if nextRedX == nextBlueX and nextRedY == nextBlueY:
                # count으로 빨간구슬, 파란구슬의 선후 위치를 판별
                if redCount > blueCount:
                    nextRedX -= dx[i]
                    nextRedY -= dy[i]
                else:
                    nextBlueX -= dx[i]
                    nextBlueY -= dy[i]

            if not visited[nextRedY][nextRedX][nextBlueY][nextBlueX]:
                visited[nextRedY][nextRedX][nextBlueY][nextBlueX] = True
                q.append((nextRedX, nextRedY, nextBlueX, nextBlueY, depth+1))
    print(-1)
    return

for y in range(N):
    for x in range(M): 
        if maze[y][x] == 'R':
            redX = x
            redY = y
        if maze[y][x] == 'B': 
            blueX = x
            blueY = y

bfs(redX, redY, blueX, blueY)