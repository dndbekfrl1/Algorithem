"""
2
3
hat headgear
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face
"""
T = int(input())

for t in range(T):
    n=int(input())
    clothes=[]
    for i in range(n):
        name, kind=input().split()
        clothes.append(kind)
    clothes_num=[]
    clothes_set=set(clothes)
    for j in clothes_set:
        clothes_num.append(clothes.count(j)+1)
    ans = 1
    for j in clothes_num:
        ans*=j
    print(ans-1)
        
    

    
