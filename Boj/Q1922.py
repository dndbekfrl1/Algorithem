import sys
from heapq import heappush,heappop

input = sys.stdin.readline
n = int(input())
m= int(input())
network = [[] for _ in range(n+1)]
heap=[]
heappush(heap,(0,1))
visited = [False for _ in range(n+1)]
for _ in range(m):
    a,b,c=map(int,input().split())
    network[a].append((b,c))
    network[b].append((a,c))

cnt = 0
res = 0
while heap:
    if cnt == n: break
    w, node = heappop(heap)
    if not visited[node]:
        visited[node]=True
        res += w
        cnt += 1
        
        for n_node, n_w in network[node]:
            
            heappush(heap,(n_w,n_node))
            #print(node,w,heap)
            
    
print(res)
