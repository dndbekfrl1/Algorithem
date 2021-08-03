
import sys
n = int(sys.stdin.readline())
narr=[]
for _ in range(n):
    word=sys.stdin.readline()
    narr.append(word.rstrip("\n"))

narr.sort(key=lambda x : len(x))

cnt=0

for i in range(0,len(narr)):
    pw =narr[i]
    for j in range(i+1,len(narr)):
        w=narr[j]
        if w.startswith(pw):
            cnt+=1
            break
        
        
print(n-cnt)
    


