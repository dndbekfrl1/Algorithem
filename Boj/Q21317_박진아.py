"""
e - n+1
ė - n+2
E - k  *only one

min(memo[n-1]+e[n-1], memo[n-2]+E[n-2], memo[n-3]+K)
print(memo[n])
"""
import sys

def dfs(cur, effort, isK):
    global answer

    if effort >= answer: return
    if cur == N: 
        answer = min(effort, answer)
        return
    
    if cur + 1 <= N:
        dfs(cur + 1, effort + e[cur], isK)
    if cur + 2 <= N:
        dfs(cur + 2, effort + E[cur], isK)
    if cur + 3 <= N and not isK:
        dfs(cur + 3, effort + K, True)

N = int(input())
e = [0 for _ in range(N)]
E = [0 for _ in range(N)]
for i in range(1, N):
    x, y = map(int, input().split())
    e[i], E[i] = x, y
K = int(input())

answer = sys.maxsize
dfs(1, 0, False)
print(answer)


    


