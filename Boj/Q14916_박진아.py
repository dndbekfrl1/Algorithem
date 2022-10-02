coin = int(input())
answer = -1
cnt = 0

for c in range(coin//5 , -1, -1):
    rest = coin - 5 * c
    if int(rest % 2) == 0 :
        answer = c + rest // 2
        break
 
print(answer)