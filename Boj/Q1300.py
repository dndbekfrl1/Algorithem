n = int(input())
k = int(input())
l=1
r=n*n
res=0

while(l<=r):
    cnt=0
    m=(l+r)//2
    for i in range(1,n+1): cnt=cnt+min((m//i),n)
    if cnt<k:l=m+1
    else:
        res=m
        r=m-1
print(res)

"""
1) n=3 일때, 다음과 같다.
1*(1,2,3) -> [1,2,3]
2*(1,2,3) -> [2,4,6]
3*(1,2,3) -> [3,6,9]

2) l=1, r=9 (3*3) m=5 (l+r)//2 일때
m보다 작은 수를 카운트 한다.
1*(1,2,3) -> 3개 (1,2,3)
2*(1,2,3) -> 2개 (2,4)
cnt=5개

즉, 현재 범위에서 k번째 수(7)에 미치지 못한다

cnt(5) < k(7)이므로
l=m+1 를 한다.

3) l=6 r=9 m=7
m보다 작은 수를 카운트 한다.
1*(1,2,3) -> 3개 (1,2,3)
2*(1,2,3) -> 3개 (2,4,6)
3*(1,2,3) -> 2개 (3,6)
cnt = 8개

현재 범위에서 k번째 수(7)보다 많이 카운트했다

cnt(8) > k(7)이므로
r=m-1를 한다
이때 res = m을 한다.

4) l=6 r=6 m=6
cnt(6) < k(7)이므로
l=m+1=7>r 이므로 종료한다.

5)
print(res)를 한다
"""
    
