"""
why time exceed?

if dp[cur] < weight:continue
check if current cost is small enough

"""
import sys
from heapq import heappush, heappop
inf = sys.maxsize

def dijkstra(start,end):
    heap = []
    heappush(heap,(start,0))
    dp=[inf for _ in range(n+1)]
    dp[start]=0
    while heap:
        cur, weight = heappop(heap)

        if dp[cur] < weight:
            continue
        
        for next_node, next_weight in graph[cur]:
            cost = weight+next_weight
            if dp[next_node]>cost:
                dp[next_node]=cost
                heappush(heap,(next_node,cost))

    return dp[end]
        

input= sys.stdin.readline
n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
for i in range(m):
    start,end,cost = map(int,input().split())
    graph[start].append((end,cost))
    
start,end=map(int,input().split())
print(dijkstra(start,end))
    
