def countSmallNumber(direction):
    #left to right
    if direction == 1:
        m=0
        for i in range(0,n):
            tmp=[]
            for j in range(0,i):
                if arr[i]>arr[j]:
                    tmp.append(dp[j][m])
            if tmp:
                dp[i][m]=max(tmp)+dp[i][m]
                
    #right to left
    if direction == -1:
        m=1
        for i in range(n-2,-1,-1):
            tmp=[]
            for j in range(i,n):
                if arr[i]>arr[j]:
                    tmp.append(dp[j][m])
            if tmp:
                dp[i][m]=max(tmp)+dp[i][m]

n = int(input())
arr=list(map(int,input().split()))
dp = [[1,1] for _ in range(n)]

countSmallNumber(1)
countSmallNumber(-1)

ans = 1
for i in range (n):
    ans=max(ans,dp[i][0]+dp[i][1])

print(ans-1)
    
    
    
            
            

        
        
        

