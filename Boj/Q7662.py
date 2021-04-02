"""
D 1 -> drop max
D -1 -> drop min
I -> add

print(max min)
"""
import heapq
import sys;read=sys.stdin.readline

T=int(input())
for t in range(T):
    k=int(input())
    max_heap=[]
    min_heap=[]
    visit=[False]*1_000_001
    
    for index in range(k):
        order = read().split()

        if order[0] =='I':
            heapq.heappush(min_heap, (int(order[1]),index))
            heapq.heappush(max_heap,(int(order[1])*-1,index))
            visit[index]=True
            
        
        elif order[1] =='1':
            while max_heap and not visit[max_heap[0][1]]:
                 heapq.heappop(max_heap)
            if max_heap:
                visit[max_heap[0][1]]=False
                heapq.heappop(max_heap)
                
        else:
            while min_heap and not visit[min_heap[0][1]]:
                heapq.heappop(min_heap)
            if min_heap:
                visit[min_heap[0][1]]=False
                heapq.heappop(min_heap)
                
    while max_heap and not visit[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not visit[min_heap[0][1]]:
        heapq.heappop(min_heap)

    if max_heap and min_heap:print(-max_heap[0][0], min_heap[0][0])
    else:print('EMPTY')

