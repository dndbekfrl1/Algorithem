import heapq
import sys

n = int(input())
q = []
for i in range(n):
    x=int(sys.stdin.readline())
    res=0
    # del max
    if x==0:
        if len(q)==0:
            res=0
            print(res)
        else:
            res=-heapq.heappop(q)
            print(res)
    else:
        x=-x
        heapq.heappush(q,x)
        
    
    
