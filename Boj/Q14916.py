n=int(input())
ans = 100000

if n%2 ==0:
    ans = n//2

for i in range (1,n//5+1):
    n_tmp = n
    n_tmp -= i*5
    if n_tmp % 2 ==0:
        ans = min(ans,i+n_tmp//2)

if ans == 100000: ans = -1
print(ans)
