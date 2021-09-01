"""
0 - empty
1,2,3,4,5,6 - fish size
9 - baby

can go - baby >= fish
can eat - baby > fish
time +1 - each move

shortes path
get top, left

baby(2) grow +1 - eat num of baby's size

count fish until face empty spcae

"""
import sys
from collections import deque

dx = [-1,1,0,0]
dy=  [0,0,-1,1]

def bfs(starty,startx,size):
    visit =[ [ 0 for _ in range(n+1)] for _ in range(n+1)]
    visit[starty][startx]=1
    memo =[ [ 0 for _ in range(n+1)] for _ in range(n+1)]
    q = deque()
    q.append((starty,startx))
    eat = []
    while q:
        cury,curx = q.popleft()
        for i in range(4):
            nexty = cury + dy[i]
            nextx = curx + dx[i]
            if 1<= nextx and nextx <= n and 1<= nexty and nexty <= n and visit[nexty][nextx]==0:
                #can go?
                if size >= space[nexty][nextx]:
                    q.append((nexty,nextx))
                    visit[nexty][nextx]=1
                    memo[nexty][nextx] = memo[cury][curx]+1
                #can eat?
                if size > space[nexty][nextx] and space[nexty][nextx] !=0:
                    eat.append((nexty,nextx,memo[nexty][nextx]))
    if not eat: return -1,-1,-1
    eat.sort(key = lambda x :(x[2],x[0],x[1]))
    return eat[0][0], eat[0][1], eat[0][2]

input = sys.stdin.readline
n = int(input())
space = [ []for _ in range(n+1)]
for i in range(1,n+1):
    row = list(map(int, input().split()))
    row.insert(0,0)
    space[i]=row
babyx=0
babyy=0
for y in range(1,n+1):
    for x in range(1,n+1):
        if space[y][x] == 9:
            babyx=x
            babyy=y
size=2
sec=0
cnt=0
while True:
    y,x = babyy,babyx
    space[y][x]=0
    babyy,babyx,t = bfs(y,x,size)
    #can't move
    if babyy==-1:break
    #grow
    cnt+=1
    if cnt == size:
        size+=1
        cnt=0
    space[babyy][babyx]=0
    sec +=t

print(sec)
    
