'''
서류심사 성적과 ㅁ
면접시험 성정 중 
'''
import sys
t = int(sys.stdin.readline())
for i in range(0,t):
    n = int(sys.stdin.readline())
    apply=[]
    res=1
    
    for j in range(0,n):
        doc, interview = map(int, sys.stdin.readline().split())
        apply.append([doc,interview])
    apply=sorted(apply, key=lambda a:a[0])

    A=apply[0]
    for j in range(1,n):
        B=apply[j]
        if A[1] > B[1]:
            res+=1
            A=B
            
    print(res)
                
    
