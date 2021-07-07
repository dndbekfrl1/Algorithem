import sys

n,m = map(int, input().split())
arrN=list(map(int,sys.stdin.readline().split()))
addlist = [0]*n

addlist[0]=arrN[0]
for i in range(1,n):
    addlist[i]=arrN[i]+addlist[i-1]

for t in range(m):
    i,j=map(int,sys.stdin.readline().split())
    if i==1: res=addlist[j-1]
    else: res=addlist[j-1]-addlist[i-1]+arrN[i-1]
    print(res)

    

    
