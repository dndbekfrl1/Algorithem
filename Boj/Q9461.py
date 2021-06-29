T = int(input())
ans = [0,1,1,1,2,2]+[0]*96
for i in range(T):
    n = int(input())
    res = 0
    if n<=5:
        res = ans[n]
    else:
        for j in range(6,n+1):
            ans[j]=ans[j-5]+ans[j-1]
        res = ans[n]
    print(res)
    
        
        
        
