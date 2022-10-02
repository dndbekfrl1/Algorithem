n = int(input())
ropes = []
for _ in range(n): 
    ropes.append(int(input()))
ropes.sort(reverse=True)
answer = -1
for idx in range(n):
    weight = ropes[idx] * (idx+1)
    answer = max(answer, weight)

print(answer)
