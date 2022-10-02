'''
n + 1: 퇴사
'''
import sys 

n = int(sys.stdin.readline())
schedule = [0 for _ in range(n+1)]
memo = [0 for _ in range(n+2)] # [1, n+1]
res = -1
w = 0

for i in range(1, n+1):
    t, p = list(map(int, sys.stdin.readline().split()))
    schedule[i] = [t, p]

for i in range(1, n+1):
    t, p = schedule[i]
    w = max(w, memo[i])
    if i+t > n+1: continue
    memo[i+t] = max(memo[i+t], w+p)
    
print(max(memo))