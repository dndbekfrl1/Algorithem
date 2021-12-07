s, n = map(int, input().split())
arr = list(map(int, input().split()))

index = 0
ans = 0
odd = 0
even = 0

for i in range(s):
    start = i
    res = 0

    print(i)
    while index < s and odd <= n:

        if arr[index] % 2 == 0:
            even += 1
        else:
            odd += 1
        print(index, " odd:", odd, " even:", even)
        index += 1
        if start == 0 and index == s:
            res = even
            break

    # 백
    if odd == n + 1:
        ans = max(ans, even)

    if arr[start] % 2 == 1:
        odd -= 1
    else:
        even -= 1

print(ans)
