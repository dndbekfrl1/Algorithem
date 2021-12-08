
n = int(input())
arr = list(map(int, input().split()))
dp = [-1001 for _ in range(len(arr))]
dp[0] = arr[0]
ans = dp[0]

for i in range(1, len(arr)):
    dp[i] = max(arr[i], dp[i - 1] + arr[i])
    ans = max(ans, dp[i])
print(ans)
