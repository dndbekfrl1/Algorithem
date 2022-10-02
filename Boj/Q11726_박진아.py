n = int(input())
dp = [0] * (n+1)
dp[0] = 1

for i in range(1, n+1):
    for b in ([1, 2]):
        if i >= b:
            dp[i] += dp[i-b]

print(dp[n] % 10007)
    