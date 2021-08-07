import sys
r, c = map(int, sys.stdin.readline().split())
cross_words=[]

for j in range(r):
    row=sys.stdin.readline().rstrip()
    split=[]
    for i in range (len(row)):split.append(row[i])
    cross_words.append(split)

m = len(cross_words[0])
res=[]

#row
for i in range(r):
    word=""
    for j in range(m):
        if cross_words[i][j]!="#": word+=cross_words[i][j]
        else:
            if len(word) > 1: res.append(word)
            word=""
    if len(word) > 1 : res.append(word)

#col
for j in range(m):
    word=""
    for i in range(r):
        if cross_words[i][j]!="#": word+=cross_words[i][j]
        else:
            if len(word) >1:res.append(word)
            word=""
    if len(word) > 1: res.append(word)

res.sort()
print(res[0])
