"""
0 - empty
1 - wall
2 - virus

virus -> u,d,l,r
must build wall- 3

???

힌트봄

"""

import sys
from collections import deque

def bulidWall(cnt):
    if cnt == 3:
        countVirus()
        return
    for i in range(1,n+1):
        for j in range(1,m+1):
            if space[i][j]==0:
                space[i][j]=1
                bulidWall(cnt+1)
                space[i][j]=0


dx = [-1,1,0,0]
dy = [0,0,-1,1]

def countVirus():
    global res
    q=deque()
    visited=[ [ 0 for _ in range(m+1)] for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,m+1):
            if space[i][j]==2:
                q.append((i,j))
    danger =0
    while q:
        cury,curx = q.popleft()
        for i in range(4):
            nexty = cury+dy[i]
            nextx = curx+dx[i]
            if 1<=nexty and nexty<=n and 1<=nextx and nextx <=m:
                if space[nexty][nextx]==0 and visited[nexty][nextx]==0:
                    visited[nexty][nextx]=1
                    danger+=1
                    q.append((nexty,nextx))
                    
    res=min(res,danger)
    
    
input = sys.stdin.readline
n,m=map(int, input().split())
space = [[] for _ in range(n+1)]
res=64
ans=0

for i in range(1,n+1):
    u_input = list(map(int,input().split()))
    u_input.insert(0,0)
    space[i]=u_input

for i in range(1,n+1):
    for j in range(1,m+1):
        if space[i][j]==0:ans+=1
            
bulidWall(0)
print(ans-(res+3))
