import sys
from heapq import heappush, heappop 
inf = sys.maxsize

def djikstra(start):
    dp = [inf for i in range(n+1)]
    dp[start]=0
    heap=[]
    heappush(heap,(0,start))
    while heap:
        weight,cur = heappop(heap)
        for next_node, next_weight in graph[cur]:
            w = next_weight + weight
            if dp[next_node]>w:
                dp[next_node]=w
                heappush(heap,[w,next_node])
    return dp
        
    
input = sys.stdin.readline
n,e = map(int, input().split())
graph=[[] for _ in range(n+1)]

for _ in range(e):
    a,b,c = map(int,  input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1, v2 = map(int, input().split())
start = djikstra(1)
v1_ = djikstra(v1)
v2_ = djikstra(v2)

# 1-> v1 -> v2 -> n
# 1-> v2 -> v1 -> n

res = min(start[v1]+v1_[v2]+v2_[n], start[v2]+v2_[v1]+v1_[n])
if res >= inf: res=-1
print(res)

#graph[1] = [(2,3),(3,3)]
#graph[2] = [(1,2)

    
