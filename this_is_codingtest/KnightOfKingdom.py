direction=[[2,1],[2,-1],[-2,1],[-2,-1],[1,2],[1,-2],[-1,2],[-1,-2]]
location=input()
row=int(location[1])
col=int(ord(location[0])-ord('a')+1)

res =0
for i in range(len(direction)):
    nrow=row+direction[i][0]
    ncol=col+direction[i][1]

    if 0<=nrow and nrow<=8 and 1<=ncol and ncol<=8:
        res+=1
print(res)
