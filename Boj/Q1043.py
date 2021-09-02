"""
max num of party
->Oops consider only sequential ^^;

import sys
input = sys.stdin.readline

n,m=map(int,input().split())
input_ = list(map(int,input().split()))
know_num = input_[0]
know_man = []
party = [[] for _ in range(m+1)]
if know_num !=0: know_man = input_[1:]
know_man = set(know_man)

for i in range(1,m+1):
    input_=list(map(int,input().split()))
    party[i] = input_[1:]
    
    for index in range(1,len(input_)):
        if input_[index] in know_man:
            print(input_,input_[index],set(input_[1:]))
            know_man=know_man.union(set(input_[1:]))
            print(know_man)
            break
        
res=m
for i in range(1,m+1):
    for p in party[i]:
        if p in know_man:
            print(p)
            res-=1
            break
print(res)

dfs ....
T.T?
"""
import sys
input = sys.stdin.readline

def dfs(node):
    for next_node in range(1,n+1):
        if graph[node][next_node]==1 and next_node not in know_man:
            know_man.add(next_node)
            dfs(next_node)
    



n,m=map(int,input().split())
input_ = list(map(int,input().split()))
graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
party = [[] for _ in range(m+1)]
num = input_[0]
know = input_[1:]
know_man = set()
res=m
for i in range(1,m+1):
    input_=list(map(int,input().split()))
    people = input_[1:]
    party[i] = people
    for i in people:
        for j in people:
            graph[i][j]=1

for man in know:
    know_man.add(man)
    dfs(man)

for p in party:
    for m in p:
        if m in know_man:
           
            res-=1
            break

print(res)
