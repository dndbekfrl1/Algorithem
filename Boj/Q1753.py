# bfs -> time exceed code
'''
import sys
from collections import deque

v,e= map(int,sys.stdin.readline().split())
start=int(sys.stdin.readline()) #start v
relation = [[] for _ in range(v+1)]
INF = 100000000
dp = [INF]*(v+1)

def bfs(node):
    q=deque([node])
    dp[node]=0
    
    while q:
        pre_node=q.popleft()
        graph = relation[pre_node]
        for g in graph:
            next_node = g[0]
            weight=g[1]
            #dp[next_node]=min(dp[next_node],dp[pre_node]+weight)
            if dp[next_node] > dp[pre_node]+weight:
                dp[next_node]=dp[pre_node]+weight
                q.append(next_node)

for _ in range(e):
    u,vv,w=map(int,sys.stdin.readline().split())
    relation[u].append((vv,w))

bfs(start)

for i in range(1,v+1):
    if i==start:print(0)
    else:
        if dp[i]==INF:print("INF")
        else: print(dp[i])
''' 



import sys
from heapq import heappush, heappop

v,e= map(int,sys.stdin.readline().split())
start=int(sys.stdin.readline()) #start v
relation = [[] for _ in range(v+1)]
INF= 100000000
heap=[]
dp=[INF]*(v+1)

for _ in range(e):
    u,vv,w=map(int,sys.stdin.readline().split())
    relation[u].append([vv,w])

def dijkstra(node):
    dp[node]=0
    heappush(heap,(0,node))

    while heap:
        pre_weight,pre_node = heappop(heap)

        for next_node,weight in relation[pre_node]:
            next_weight=weight+pre_weight
            if next_weight <dp[next_node]:
                dp[next_node]=next_weight
                heappush(heap,(next_weight,next_node))
        
dijkstra(start)
for i in range(1,v+1):
    if i==start:
        print(0)
    else:
        if dp[i]==INF:print("INF")
        else: print(dp[i])
    

