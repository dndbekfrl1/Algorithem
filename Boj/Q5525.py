N = int(input())
M = int(input())
S = input()

ans = 0
pattern = 0
i=1

while i<M-1:
    if S[i-1]=='I' and S[i]=='O' and S[i+1]=='I':
        pattern +=1
        if pattern == N:
            ans+=1
            pattern-=1
        i+=1   
    else:
        pattern=0
    i+=1
            
print(ans)
    
    
