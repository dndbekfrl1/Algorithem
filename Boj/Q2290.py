s,n = input().split()
s=int(s)
row=(s+2)
col=2*s+3
arr=[]

def top(num):
    for i in range(1,s+1):
        num[0][i]="-"

def lt(num):
    for i in range(1,1+s):
        num[i][0]="|"

def mid(num):
    for i in range(1,s+1):
        num[s+1][i]="-"

def lb(num):
    for i in range(s+2,2*s+2):
        num[i][0]="|"

def rt(num):
    for i in range(1,1+s):
        num[i][-1]="|"

def rb(num):
    for i in range(s+2,2*s+2):
        num[i][-1]="|"

def bottom(num):
    for i in range(1,s+1):
        num[col-1][i]="-"

for i in range(len(n)):
    x=int(n[i])
    num=[ [' '] * row for _ in range(col)]

    if x in [2,3,5,6,7,8,9,0]:
        top(num)
    if x in [4,5,6,8,9,0]:
        lt(num)
    if x in [1,2,3,4,7,8,9,0]:
        rt(num)
    if x in [2,3,4,5,6,8,9]:
        mid(num)
    if x in [2,6,8,0]:
        lb(num)
    if x in [1,3,4,5,6,7,8,9,0]:
        rb(num)
    if x in [2,3,5,6,8,9,0]:
        bottom(num)

    arr.append(num)

ans=[[]for _ in range(col)]

for i in range(0,col):
    string=""
    for j in range(len(arr)):
        ans[i]+=arr[j][i]
        ans[i].append(" ")

for c_arr in ans:
    print(''.join(c_arr))
