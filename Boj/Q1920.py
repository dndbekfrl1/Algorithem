n = int(input())
Aarr=input().split()
for i in range(n):Aarr[i]=int(Aarr[i])
m=int(input())
marr=input().split()
for i in range(m):marr[i]=int(marr[i])
Aarr=sorted(Aarr)

for x in marr:
    l=0
    r=n-1
    isExist =False
    while(l<=r):
        mid=(l+r)//2
        if Aarr[mid] > x:
            r=mid-1
        elif Aarr[mid] < x:
            l=mid+1
        elif Aarr[mid]==x:
            isExist=True
            break
    if isExist:print(1)
    else:print(0)
