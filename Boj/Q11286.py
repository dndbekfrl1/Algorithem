import heapq
import sys

n = int(input())
posq = []
negq=[]
for i in range(n):
    x=int(sys.stdin.readline())
    res=0
    # del max
    if x==0:
        if len(posq)+len(negq) ==0:
            res=0
            print(res)
        else:
            plus=2147483648
            minus=-2147483648
            
            if len(posq) !=0:
                plus = heapq.heappop(posq)
                heapq.heappush(posq,plus)
            if len(negq) !=0:
                minus = -heapq.heappop(negq)
                heapq.heappush(negq,-minus)

            if plus == -minus:
                res=minus
                heapq.heappop(negq)
            else:
                if -minus > plus:
                    res=plus
                    heapq.heappop(posq)
                else:
                    res=minus
                    heapq.heappop(negq)
            print(res)
            
    else:
        if x>0:
            heapq.heappush(posq,x)
        else:
            heapq.heappush(negq,-x)
        
    
    
