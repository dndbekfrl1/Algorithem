import sys

n,k=map(int,sys.stdin.readline().split())
coins=[]
for i in range(0,n):
    coins.append(int(sys.stdin.readline()))
res=0
if n==1:
    res=k//coins[0]
else:
    for i in range(n-1,-1,-1):
        coin = coins[i]
        if coin <=k:
            res+=k//coin
            k=k%coin
print(res)
