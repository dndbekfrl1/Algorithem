'''
https://pacific-ocean.tistory.com/197
'''
    
T = int(input())
for _ in range(T):
    n = int(input())
    stickers = []
    for _ in range(2):
        tmp = list(map(int, input().split()))
        stickers.append(tmp)

    for i in range(1, n):
        if i == 1:
            stickers[0][i] += stickers[1][i-1]
            stickers[1][i] += stickers[0][i-1]
        else:
            stickers[0][i] += max(stickers[1][i-1], stickers[0][i-2], stickers[1][i-2])
            stickers[1][i] += max(stickers[0][i-1], stickers[1][i-2], stickers[0][i-2])
        
    print(max(stickers[0][n-1], stickers[1][n-1]))
    
