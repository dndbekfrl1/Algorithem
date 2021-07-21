import sys
t = int(sys.stdin.readline())
forward=[(0,1),(1,0),(0,-1),(-1,0),(0,1),(1,0),(0,-1),(-1,0),(0,1)]

for i in range(t):
    input_move=sys.stdin.readline().strip()
    x=0
    y=0
    turn=4
    dirx=1 #direction
    diry=1 #direction

    minl=0
    maxr=0
    maxt=0
    minb=0

    res=0
    
    for m in range(len(input_move)):
        if input_move[m]=="F":
            x=(x+forward[turn][0])
            y=(y+forward[turn][1])
        elif input_move[m]=="B":
            x=(x-forward[turn][0])
            y=(y-forward[turn][1])
        elif input_move[m]=="L":
            turn -=1
        else:
            turn +=1
       
        turn = turn %8
        minl=min(minl,x)
        maxr=max(maxr,x)
        minb=min(minb,y)
        maxt=max(maxt,y)
        
    res=(abs(minl)+abs(maxr))*(abs(minb)+abs(maxt))
    print(res)
