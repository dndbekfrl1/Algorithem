'''
각 동전 사용 제한 x 
k원

OUTPUT:
k원이 되는 set(경우의 수)

dp[2n] = [2n-1, n]
dp[2n-1] = [2n-2, (2n-1)/2]

if dp[1] == 1:
    dp[1, all] += 1
'''
'''
n, k = map(int, input().split())
memo = [0] * (k+1)

for _ in range(n):
    coin = int(input())
    memo[coin] += 1

for i in range(2, k+1):
    # 짝수
    if i % 2 == 0:
        for j in range(i-1, (i//2)-2, -1):
            memo[i] += memo[j] + memo[i-j]
    # 홀수
    else:
        for j in range(i-1, (i//2), -1):
            memo[i] += memo[j] + memo[i-j]

print(memo)
'''
n, k = map(int, input().split())
coins = []
for _ in range(n): coins.append(int(input()))
memo = [0] * (k+1)
memo[0] = 1
for coin in coins:
    for i in range(1, k+1):
        if i-coin >= 0:
            memo[i] += memo[i-coin]

print(memo[k])