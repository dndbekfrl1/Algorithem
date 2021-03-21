import sys

n= int(sys.stdin.readline())
color_paper=[list(map(int,sys.stdin.readline().split())) for _ in range(n)]

white=0
blue=0

def cutPaper(row, col, w, h):
    if isDone(row,col,w,h):
        return
    else:
        cutPaper(row,col,w/2,h/2)
        cutPaper(row+w/2,col,w/2,h/2)
        cutPaper(row,col+h/2,w/2,h/2)
        cutPaper(row+w/2,col+h/2,w/2,h/2)
        
    

def isDone(row, col, w, h):
    data = color_paper[row][col]
    global blue, white
    
    for x in range(row,row+w):
        for y in range(col,col+h):
            if(data!=color_paper[x][y]):
                return False
    if data==1:
        blue+=1
    else:
        white+=1
    return True


cutPaper(0,0,n,n)
print(white)
print(blue)
