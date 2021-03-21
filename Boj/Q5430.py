from collections import deque
from sys import stdin, stdout

T = int(stdin.readline())
for _ in range(T):
    p = stdin.readline().rstrip()
    n = stdin.readline().rstrip()
    arr = stdin.readline().rstrip()[1:-1].split(',')
  
    if n=='0':
        arr=deque()
    else:
        arr=deque(arr)
        
    isR = False
    isError=False

    for func in p:
        if func == 'R':
            isR= not isR
        else:
            if len(arr) == 0:
                isError=True
                
            if(isError):
                print('error')
                break
            
            else:
                if isR:
                    arr.pop()
                else:
                    arr.popleft()

    if not isError:
        if isR:
            arr.reverse()

        print('[',end='')
        for i in range(len(arr)):
            print(arr[i],end='')
            if i!=len(arr)-1:
                print(',',end='')
        print(']')

