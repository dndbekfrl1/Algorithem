#time exceed code
'''
import sys

n,m=map(int,sys.stdin.readline().split())
relation=[[] for _ in range(n+1)]

for _ in range(m):
    a,b=map(int,sys.stdin.readline().split())
    relation[b].append(a)

def hack(i,relation,visited):
    global cnt

    computers=relation[i]
    visited[i]==1
    cnt+=1

    for com in computers:
        if visited[com]==0:
            nextI=com
            hack(nextI,relation,visited)
 
cntarr=[0]*(n+1)

for i in range(1,n+1):
    visited=[0]*(n+1)
    cnt=0
    hack(i,relation,visited)
    cntarr[i]=cnt
  
maxCnt=max(cntarr)
res=""
for i in range(1,n+1):
    if cntarr[i] ==maxCnt:
        res+=str(i)+" "

print(res)
    
''' 
    
import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())
relation =[[]for _ in range(n+1)]

for _ in range (m):
    a,b=map(int,sys.stdin.readline().split())
    relation[b].append(a)


def bfs(i):
    q=deque([i])
    visited=[0]*(n+1)
    visited[i]=1
    cnt=1
    while q:
        computers=relation[q.popleft()]
        for nextI in computers:
            if visited[nextI] ==0:
                q.append(nextI)
                visited[nextI]=1
                cnt+=1
    return cnt

result=[] #max computer's num of hackable computers
max_cnt=-1

for i in range(1,n+1):
    c=bfs(i)
    if max_cnt<c:
        max_cnt=c
        result=[i]
    elif max_cnt==c:
        result.append(i)
        
for r in result:
    print(r, end=" ")


    
