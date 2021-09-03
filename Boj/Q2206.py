"""
1,1 -> n,m
shortest

crack -> 1

dijkstra


"""
import sys
from collections import deque

dx=[0,0,-1,1]
dy=[1,-1,0,0]

def bfs():
    memo= [[[0,0] for _ in range(m+1)] for _ in range(n+1)]
    q=deque()
    """
    memo[j][i][0] - crack 0
    memo[j][i][1] - crack 1
    """
    memo[1][1][0] = 1
    q.append((1,1,0))
    while q:
        cury,curx,crack = q.popleft()
        
        for i in range(4):
            nexty=cury+dy[i]
            nextx=curx+dx[i]
            
            if 1<=nextx and nextx<=m and 1<=nexty and nexty<=n and memo[nexty][nextx][crack]==0:
                #print("next",nexty,nextx,"crack",crack)
                #do crack
                if graph[nexty][nextx]==1 and crack ==0:
                    #print("crack")
                    memo[nexty][nextx][crack+1]= memo[cury][curx][crack]+1
                    q.append((nexty,nextx,crack+1))
                elif graph[nexty][nextx] == 0:
                    memo[nexty][nextx][crack]=memo[cury][curx][crack]+1
                    q.append((nexty,nextx,crack))
                
                

                #for row in memo :print(row)
                #print()
    return memo[n][m]
    
input = sys.stdin.readline
n,m = map(int,input().split())
graph=[[0 for _ in range(m+1)] for _ in range(n+1)]
for i in range(1,n+1):
    u_input =input().rstrip()
    for x in range(len(u_input)):
        graph[i][x+1]=int(u_input[x])

    
res = bfs()
print(res)
resM = max(res)
resm = min(res)

if resm ==0 and resM ==0: print(-1)
elif resm ==0: print(resM)
else: print(resm)
