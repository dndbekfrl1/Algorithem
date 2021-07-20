n,m,k=map(int,input().split())
narr=[]
narr=list(map(int,input().split()))
narr=sorted(narr)
res=0

max_num = narr[-1]
min_num = narr[-2]

cnt=0
total=0
while True:
    for i in range (k):
        if total ==m: break
        res+=max_num
        total+=1
    if total==m: break
    res+=min_num
    total+=1
  
    

print(res)
