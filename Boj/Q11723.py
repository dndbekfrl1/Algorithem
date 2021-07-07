import sys

m = int(input())
s=set()

for i in range(m):
    in_put=sys.stdin.readline().split()
    if len(in_put)==1:
        operator=in_put[0]
    else:
        operator=in_put[0]
        x=int(in_put[1])

    if operator == "add":s.add(x)
    elif operator =="check":
        if x in s: print(1)
        else: print(0)
    elif operator =="remove":
        if x in s:s.remove(x)
    elif operator =="toggle":
        if x in s:s.remove(x)
        else:s.add(x)
    elif operator =="all":s=set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
    else:s=set()
