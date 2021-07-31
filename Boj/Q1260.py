import sys
from collections import deque

n,m,v=map(int, sys.stdin.readline().split())
input_map=[[0 for _ in range(n+1)]for _ in range(n+1)]


for i in range(m):
    x, y = map(int, sys.stdin.readline().split())
    input_map[x][y]=input_map[y][x]=1
    
dx = [0,0,1,-1]
dy=[1,-1,0,0]

def dfs(V,visited):
    visited[V]=1
    print(V,end=" ")
    for j in range(1,n+1):
        if input_map[V][j] ==1 and visited[j] ==0:
            dfs(j,visited)

def bfs(V,visited):
    q=deque()
    q.append(V)
    visited[V]=1

    while q:
        v = q.popleft()
        print(v,end=" ")
        for j in range(1,n+1):
            if input_map[v][j]==1 and visited[j] ==0:
                q.append(j)
                visited[j]=1
            
visited=[0 for _ in range(n+1)]    
dfs(v,visited)
print()
visited=[0 for _ in range(n+1)]
bfs(v,visited)
    


