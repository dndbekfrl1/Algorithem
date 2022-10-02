"""
N: at least 
C: num of city 
cost, weight 
"""
C, N = map(int, input().split())
dp = [1e9] * (C+101) # 얻을 수 있는 고객의 수는 100보다 작거나 같은 자연수
city_w = []
city_c = []
dp[0] = 0
for _ in range(N):
    c, w = map(int, input().split())
    city_w.append(w)
    city_c.append(c)

for i in range(N):
    for j in range(city_w[i], C+100):
        # dp[city_w] = 적어도 k값을 가지는 최소 cost
        dp[j] = min(dp[j], dp[j-city_w[i]]+city_c[i])

for i in range(N):
    for j in range(city_w[i], C+100):
        dp[j] = min(dp[j], dp[j-city_w[i]]+city_c[i])

print(min(dp[C:]))
