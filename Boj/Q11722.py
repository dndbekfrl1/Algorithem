a = int(input())
arr = list(map(int, input().split()))
ans=-1
dp = [1 for i in range(a)]

for i in range(1,a):
    tmp=[]
    for j in range(0,i):
        if arr[i] < arr[j]:
            tmp.append(dp[j])
    if tmp:
        dp[i]+=max(tmp)
        
        
print(max(dp))    
    
    
"""
5

7 5 3 1 10

10 7 5 3 1

"""
