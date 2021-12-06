n, m = map(int, input().split())
money = []
for i in range(n):
    money.append(int(input()))
dp = [10001] * (m + 1)
dp[0] = 0
for i in range(n):
    for j in range(money[i], m + 1):
        if dp[j - money[i]] != 10001:
            dp[j] = min(dp[j], dp[j - money[i]] + 1)
res = -1 if dp[m] == 10001 else dp[m]
print(res)
print(dp)
