"""
black -> block
white -> can go

min num of black to white



bfs?

"""
import sys
from heapq import heappush, heappop
inf = sys.maxsize

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def dijkstra(x,y):
    dp=[[inf for _ in range(n+1)] for _ in range(n+1)]
    dp[y][x]=0
    heap=[]
    heappush(heap,(x,y,0)) #nodex,nodey,crack

    while heap:
        curx,cury,crack = heappop(heap)
        for i in range(4):
            next_x = dx[i] + curx
            next_y = dy[i] + cury
            if 1<=next_x and next_x <=n and 1<=next_y and next_y <=n:
                next_crack=crack
                
                if maze[next_y][next_x] == 0:
                    next_crack+=1
                if dp[next_y][next_x] > next_crack:
                    dp[next_y][next_x] = next_crack
                    heappush(heap,(next_x,next_y,next_crack))

    return dp[n][n]
                

input = sys.stdin.readline
n= int(input())
maze = [[] for _ in range(n+1) ]

for i in range(1,n+1):
    row = list(map(int, input().rstrip()))
    row.insert(0,0)
    maze[i]=row

print(dijkstra(1,1))
