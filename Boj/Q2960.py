n,k=map(int,input().split())
cnt=0
res=0
visited=[0]*(n+1)

def isPrime(i):
    if i==2:return True
    else:
        for num in range(2,i):
            if i%num==0:
                return False
        return True

for i in range(2,n+1):
    if visited[i]==0 and isPrime(i):
        for j in range(i,n+1,i):
            if visited[j]==0:
                visited[j]=1
                cnt+=1
            if cnt == k:
                res=j
                break
    
print(res)
