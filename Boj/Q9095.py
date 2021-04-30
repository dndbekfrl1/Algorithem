T = int(input())

def add(num,cur):
    if(cur>num):
        return 0
    if(cur==num):
        return 1
    now=0
    
    now+=add(num,cur+1)
    now+=add(num,cur+2)
    now+=add(num,cur+3)
        
    return now

for t in range(T):
    num = int(input())
    res=0

    res=add(num,0)
    print(res)

    
    
