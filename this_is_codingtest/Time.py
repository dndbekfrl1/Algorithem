n = int(input())

res=0
for h in range(0,n+1):
    for m in range(0,60):
        for s in range(0,60):
            if '3' in str(s)+str(m)+str(h):
                res+=1
print(res)
