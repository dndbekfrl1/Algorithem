import sys

n = int(sys.stdin.readline())
narr = list(map(int,sys.stdin.readline().split()))
p = [0]*n

narr=sorted(narr)

res=0
p[0]=narr[0]
res+=p[0]

for i in range(1,n):
    p[i]=narr[i]+p[i-1]
    res += p[i]
    
print(res)
