n = int(input())
arr=[0]*1001
arr[0]=1
arr[1]=1
arr[2]=3

if n>=3:
    for i in range(3,n+1):
        arr[i]=arr[i-1]+arr[i-2]*2
        arr[i]=arr[i]%10007
print(arr[n])
