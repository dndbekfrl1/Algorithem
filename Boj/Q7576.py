"""
left, right, front, behind
0 -> 1
-1 = null
"""
from collections import deque

dx = [-1,1,0,0]
dy = [0, 0,-1,1]

M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]

q = deque()

day=0
isDone = True

def go_time():
    while q:
        cury, curx = q.popleft()
        for i in range(4):
            nextx= curx+dx[i]
            nexty= cury+dy[i]

            if(0<=nextx <M and 0<= nexty <N and box[nexty][nextx]==0):
                if box[nexty][nextx]==0:
                    q.append([nexty,nextx])
                    box[nexty][nextx]=box[cury][curx]+1

    
for n in range(N):
    for m in range(M):
        if box[n][m] == 0:
            isDone=False
        if box[n][m]==1:
            q.append([n,m])

if isDone:
    day=0
    print(day)
    
else:
    go_time()

    for n in range(N):
        for m in range(M):
            if box[n][m]==0:
                day = -1
                isDone = True
                break

    if isDone:
        day = -1
        print(day)

    else:
        for n in range(N):
            for m in range(M):
                 day = max(day,box[n][m])
        print(day-1)



            
