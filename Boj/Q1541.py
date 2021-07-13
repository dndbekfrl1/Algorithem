import sys

arr = sys.stdin.readline().split("-")
num=[]
init=0
res=0

for i in arr:
    tmp=0
    plus = i.split("+")
    for n in plus:
        tmp +=int(n)
    num.append(tmp)
    
init=num[0]
for n in num:
    res -= n
res=res+init*2
print(res)
    
        
    
