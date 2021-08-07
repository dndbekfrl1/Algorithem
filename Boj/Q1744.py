n = int(input())
arr=[]
minus=0
plus=0
for _ in range(n):
    num = int(input())
    arr.append(num)
    if num <=0: minus+=1
    else: plus+=1
arr.sort()
ans=0

for i in range(0,minus,2):
    f = arr[i]
    num=f
    if i+1 < minus:
        s = arr[i+1]
        num = num*s
    ans+=num

for i in range(n-1,n-plus-1,-2):
    f=arr[i]
    num=f
    if i-1 >= n-plus :
        s=arr[i-1]
        if f==s==1:num =2
        else:
            num = max(num*s,num+s)
    ans+=num
print(ans)

    
    
'''
whyrano.............
'''
