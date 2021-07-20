n=int(input())


direction = input().split()
x=1
y=1
dx=[0,0,-1,1]
dy=[-1,1,0,0]
direc=['U','D','L','R']

for i in range(len(direction)):
    nx=0
    ny=0
    for j in range(4):
        if direction[i]==direc[j]:
            nx=dx[j]+x
            ny=dy[j]+y
    if 1<= nx and nx<=n and 1<= ny and ny<=n:
        x=nx
        y=ny
        
print(y,x)
        
        
