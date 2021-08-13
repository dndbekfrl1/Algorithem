n,c = map(int,input().split())
narr=[]
for _ in range(n):narr.append(int(input()))
narr=sorted(narr)

l=1
r=narr[-1]-narr[0]
res=0

while l<=r:
    cnt=1
    mid = (l+r)//2
    prev= narr[0]
    
    for i in range(1,n):
        distance = narr[i]-prev
        if distance >= mid:
            cnt+=1
            prev = narr[i]
    
    if cnt >= c:
        l=mid+1
        res=mid
    else:
        r=mid-1
        

print(res)

"""
문제: 공유기 c를 적절히 설치해야함
가장 인접한 c사이의 거리의 쵀댓값을 구해야함

이분탐색 접근이 난감해 힌트를 많이 참고했다

가장 중요한 것은 공유기 사이의 거리를 고려하는 것이므로
1) l과 r은 narr의 거리값으로 설정해야함!
l=1, r=narr[-1]-narr[0](1과 9의 거리값)
즉 m값은 l과 r의 중간값으로 기준이 되는 거리값이 됨

2) 공유기 사이의 거리를 distance라 할 때,
m<=distance이면 공유기를 설치 할 수 있다.
반대로 m>distance이면 공유기를 설치 할 수 없다.

3)설치한 공유기 수, cnt와 c를 비교해 범위를 고려한다
cnt >= c 이면 l=mid+1, res=mid이디.
res=max(resumed)를 안해도 되는 이유는 
어차피 큰 값인 오른쪽 구역을 탐색할것이기 때문에 필요없다!

"""
