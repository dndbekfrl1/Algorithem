"""
참고 https://chaemi720.tistory.com/m/139
"""
def isValidRange(c, r):
    return True if 1<= c and c<=n and 1 <= r and r <= n else False

def seat(id, likes):
    max_likes = -1
    max_empty = -1
    res_c, res_r = -1, -1

    for cur_c in range(1, n+1):
        for cur_r in range(1, n+1):
            if space[cur_c][cur_r] == -1:
                likes_cnt = 0
                empty_cnt = 0

                for i in range(4):
                    next_c = cur_c + dx[i]
                    next_r = cur_r + dy[i]
                    
                    if not isValidRange(next_c, next_r): continue

                    if space[next_c][next_r] in likes:
                        likes_cnt += 1

                    if space[next_c][next_r] == -1:
                        empty_cnt += 1

                # 조건 1. 좋아하는 학생이 인접한 가장 많은 칸 
                # 조건 2. 1을 만족하고 비어있는 칸이 가장 많은 칸
                # 조건 3. 행렬 순서대로 접근
                if likes_cnt > max_likes or (likes_cnt == max_likes and empty_cnt > max_empty):
                    res_c, res_r = cur_c, cur_r
                    max_likes = likes_cnt
                    max_empty = empty_cnt
                    
    space[res_c][res_r] = id
   
def satisfaction():
    total = 0 
    for c in range(1,n+1):
        for r in range(1,n+1):
            likes_cnt = 0
            id = space[c][r]

            for i in range(4):
                next_c = c + dx[i]
                next_r = r + dy[i]
                if not isValidRange(next_c, next_r): continue
                if space[next_c][next_r] in likes[id]:
                    likes_cnt += 1

            if likes_cnt == 0: total += 0
            elif likes_cnt == 1: total += 1
            elif likes_cnt == 2: total += 10
            elif likes_cnt == 3: total += 100
            else: total += 1000

    return total

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
n = int(input())
space = [[-1]*(n+1) for _ in range(n+1)] # init -1
likes = [[] for _ in range(n**2+1)]
for _ in range(n**2):
    studnets = list(map(int, input().split()))
    id = studnets[0]
    likes[id] =  studnets[1:]
    seat(id,likes[id])

print(satisfaction())
