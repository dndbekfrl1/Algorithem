n,k=map(int,input().split())
coins = []
count=0
for i in range(0,n):
    value = int(input())
    if value<=k:
        coins.append(value)

for i in range(len(coins)):
    coin = coins[len(coins)-i-1]
    count += k//coin
    k = k%coin

print(count)


