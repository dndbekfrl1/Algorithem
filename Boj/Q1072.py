x,y = map(int, input().split())
z= int((y*100)/x) #현재 승률 

l=1
r=1000000000 #r의 범위?
res=-1


while(l<=r):
    m = (l+r)//2
    tmpX=x+m
    tmpY=y+m
    tmpZ=int((tmpY*100)/tmpX)

    if tmpZ > z:
        res=m
        r=m-1
    else:
        l=m+1

print(res)

    

"""
29/50 -> 0.58
29/50*100 -> 57.999
2900/50 -> 58.0
2900//50 -> 58

부동소수점....
"""
