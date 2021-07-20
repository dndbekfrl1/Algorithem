n,k=map(int,input().split())
res=0

while n>=k:
    if n%k==0:
        n=n//k
        res+=1
    else:
        n=n-1
        res+=1
while n>1:
    n-=1
    res+=1
print(res)
