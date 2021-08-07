import sys
n = int(sys.stdin.readline())
mettings=[]
for _ in range(n):
    s, e = map(int,sys.stdin.readline().split())
    mettings.append((s,e))
    
mettings=sorted(mettings,key=lambda metting:(metting[1],metting[0]))
ans=1
end=mettings[0][1]

for i in range(1,n):
    next_metting=mettings[i]
    if next_metting[0]>=end:
        ans+=1
        end=next_metting[1]
        
print(ans)
    
    
    
