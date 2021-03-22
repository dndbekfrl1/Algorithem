"""
다 익게 되는 최소 일수
위, 아래, 왼쪽, 오른쪽, 앞 뒤
인접한 곳 익게됨

M*N
H

1  - rippen
0  - no rippen
-1 - none

            
"""
from collections import deque

def go_time():
    while q:
        z,x,y = q.popleft()
        for i in range(6):
            nextx=x+dx[i]
            nexty=y+dy[i]
            nextz=z+dz[i]
            
            if(0<= nextx< N and 0<= nexty<M and 0<= nextz<=h):
                if box[nextz][nextx][nexty] == 0:
                    box[nextz][nextx][nexty]= box[z][x][y]+1
                    q.append([nextz,nextx,nexty])
         
dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]
day = 0

M,N,H = map(int, input().split())
box = [[list(map(int,input().split())) for _ in range(N)]for _ in range(H)]
q=deque()


isDone = True #all rippen
               
for h in range(H):
    for n in range(N):
        for m in range(M):
            if box[h][n][m]==0:
               isDone=False
            if box[h][n][m]==1:
                q.append([h,n,m])

if(isDone):
    print(day)
               
else:
    go_time()

    print(box)

    for h in range(H):
        for n in range(N):
            for m in range(M):
                if box[h][n][m]==0:
                    day=-1
                    isDone=True

    if(isDone):
        print(day)
    else:
        for h in range(H):
            for n in range(N):
                for m in range(M):
                    m=box[h][n][m]
                    day = max(day,m)
                       
        print(day-1)
