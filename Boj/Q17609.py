import sys
t = int(sys.stdin.readline())


def checkWithDelete(string,left,right):
    while left<right:
        if string[left] == string[right]:
            left+=1
            right-=1
        else:
            return False
    return True

def check(string,left,right):
    while left<right:
        if string[left]==string[right]:
            left+=1
            right-=1
        else:
            left_side=check(string,left+1,right)
            right_side=check(string,left,right-1)

            if left_side == True or right_side == True:return 1
            else: return 2
    return 0
    
            

for _ in range(t):
    string = sys.stdin.readline().strip()
    left=0
    right=len(string)-1

    res=check(string,left,right)
    print(res)
                
