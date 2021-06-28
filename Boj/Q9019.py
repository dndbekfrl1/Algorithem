from collections import deque
import sys
input=sys.stdin.readline

def bfs(start, end):
    q=deque()
    q.append([start,''])

    while q:
        cur, cmd = q.popleft()
        if end == cur:
            return cmd

        dn = cur*2%10000
        if visit[dn]==0:
            q.append([dn,cmd+'D'])
            visit[dn]=1

        sn = cur-1 if cur!=0 else 9999
        if visit[sn]==0:
            q.append([sn,cmd+'S'])
            visit[sn]=1

        ln=int(cur%1000*10+cur//1000)
        if visit[ln]==0:
            q.append([ln,cmd+'L'])
            visit[ln]=1

        rn=int(cur%10*1000+cur//10)
        if visit[rn]==0:
            q.append([rn,cmd+'R'])
            visit[rn]=1

T = int(input())
for _ in range(T):
    start, end = map(int,input().split(" "))
    visit=[0 for _ in range(10000)]
    print(bfs(start,end))
