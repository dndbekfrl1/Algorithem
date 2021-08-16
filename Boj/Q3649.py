"""
버블 정렬 n^2
비교 또한 일일히 하나씩 맞춰가며 중첩반복문으로 비교하는 것이 아니라 탐색 알고리즘으로

비교할 대상을 최소화시켜야합니다.



"""
import sys
input=sys.stdin.readline
while True:
    try:
        x = int(input())*10000000 #cm
        n = int(input())
        legos=[]
        for _ in range(n):legos.append(int(input()))
        legos=sorted(legos)
        l=0
        r=n-1
        l1=0
        l2=0
        isDanger=True

        while l<r:
            m=(l+r)//2
            a_lego=legos[l]
            b_lego=legos[r]

            if a_lego+b_lego ==x:
                l1=a_lego
                l2=b_lego
                isDanger=False
                break
            elif a_lego+b_lego<x:l+=1
            else:r-=1

        if isDanger:print("danger")
        else:print("yes",l1,l2)
        
    except:
        break
                
            
            
            
    
    
