import sys
from collections import deque
m,n=map(int,sys.stdin.readline().split())
#m 세로 
factory = [[0 for _ in range(n+1)] for _ in range(m+1)]


for i in range(1,m+1):
    u_input=list(map(int,sys.stdin.readline().split()))
    for j in range(1,n+1):
        factory[i][j]=u_input[j-1]
        
start_row, start_col, start_direc = map(int,sys.stdin.readline().split())
end_row, end_col, end_direc = map(int,sys.stdin.readline().split())


'''
def goK(pre_row,pre_col,k,cur_direc):
    next_row=pre_row
    next_col=pre_col
    #east
    if cur_direc == 1:next_col+=k
    #west
    elif cur_direc ==2:next_col-=k
    #south
    elif cur_direc ==3:next_row+=k
    #north
    elif cur_direc ==4:next_row-=k

    if 1<=next_row and next_row <=m and 1<=next_col and next_col <= n:
        if factory[next_row][next_col]==0:
            if visited[next_row][next_col][cur_direc]==0:   

    if visited[next_row][next_col][cur_direc]==0:
        if memo[next_row][next_col][cur_direc] > memo[pre_row][pre_col][cur_direc]+1:
            visited[next_row][next_col][cur_direc]=1
            memo[next_row][next_col][cur_direc]=memo[pre_row][pre_col][cur_direc]+1
            q.append((next_row,next_col,cur_direc))

def turn(cur_row,cur_col,cur_direc,d,cnt):
    next_direc=cur_direc

    if d==0:
        if cur_direc==4: next_direc=cur_direc-3
        elif cur_direc==1:next_direc=cur_direc+2
        elif cur_direc==3:next_direc=cur_direc-1
        elif cur_direc==2:next_direc=cur_direc+2
    else:
        if cur_direc==4: next_direc=cur_direc-2
        elif cur_direc==1:next_direc=cur_direc+3
        elif cur_direc==3:next_direc=cur_direc-2
        elif cur_direc==2:next_direc=cur_direc+1

    if (cur_row,cur_col,next_direc,cnt+1) not in visited:
         q.append((cur_row,cur_col,next_direc,cnt+1))
         visited.add((cur_row,cur_col,next_direc,cnt+1))
'''   



  
def bfs(start_row,start_col,start_direc):
    q.append((start_row, start_col,start_direc,0))
    while q:
        cur_row, cur_col,cur_direc,cnt = q.popleft()

        if cur_row == end_row and cur_col ==end_col and cur_direc==end_direc:
            print(cnt)
            return
        
        for k in range(1,4):
            next_row=cur_row+drow[cur_direc]*k
            next_col=cur_col+dcol[cur_direc]*k

            if 1<=next_row and next_row <=m and 1<=next_col and next_col <= n and factory[next_row][next_col]==0:
                    if (next_row,next_col,cur_direc,cnt+1) not in visited:
                        q.append((next_row,next_col,cur_direc,cnt+1))
                        visited.add((next_row,next_col,cur_direc,cnt+1))
            else:
                break
            
        for d in range(0,2):
            next_direc=cur_direc

            if d==0:
                if cur_direc==4: next_direc=cur_direc-3
                elif cur_direc==1:next_direc=cur_direc+2
                elif cur_direc==3:next_direc=cur_direc-1
                elif cur_direc==2:next_direc=cur_direc+2
            else:
                if cur_direc==4: next_direc=cur_direc-2
                elif cur_direc==1:next_direc=cur_direc+3
                elif cur_direc==3:next_direc=cur_direc-2
                elif cur_direc==2:next_direc=cur_direc+1
                
            if (cur_row,cur_col,next_direc,cnt+1) not in visited:
                q.append((cur_row,cur_col,next_direc,cnt+1))
                visited.add((cur_row,cur_col,next_direc,cnt+1))
         
    
q=deque()
drow=[0,0,0,1,-1]
dcol=[0,1,-1,0,0]
visited=set()
bfs(start_row,start_col,start_direc)  

