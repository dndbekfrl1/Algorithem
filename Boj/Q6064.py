T = int(input())

for t in range(T):
    M,N,x,y = map(int, input().split())
    index = 0

    if y==N:
        y=0
    
    while True:
        if (M*index+x)%N == y :
            ans = M*index+x
            print(ans)
            break
        if(M*index+x)>M*N:
            ans=-1
            print(ans)
            break
        index+=1

        
    
