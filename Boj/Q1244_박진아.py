'''
if male:
    for switch in switches:
        if switch.id % student.id == 0:
            switch.status = !switch.status
    
if female:
    mid = female.id
    diff = 1
    isSwitched = True 

    while True:
        if swtiches[mid-diff].status == switches[mid+diff].status:
            switches[mid-diff].status = !switches[mid-diff].status
            switches[mid+diff].status = !switches[mid+diff].status

            diff += 1
        else:
            isSwitched = False
            break
    
    if isSwitched:
        switches[mid].status = !switches[mid].status

INPUT: 
switch     (n < 100)
status     (1 == on)
students   (n < 100)
gender, id (1 == male, id <= switch)

OUTPUT:
return final switch status
'''

class Switch:
    def __init__(self, id, status):
        self.id = id
        self.status = status

class Student:
    def __init__(self, id, gender):
        self.id = id
        self.gender = gender

switch_n = int(input())
status = list(map(int, input().split()))
switches = [None] # [None, Switch1, Switch2, ...]
for i in range(switch_n):
    switches.append(Switch(i+1,status[i]))
student_n = int(input())
students = []
for i in range(student_n):
    gender, id = list(map(int,input().split()))
    students.append(Student(id, gender))
answer = ''

for student in students:
    # male
    if student.gender == 1:
        for switch in switches:
            if switch == None: continue
            if switch.id % student.id == 0:
                switch.status = 0 if switch.status == 1 else 1
    # female
    else:
        mid = student.id
        distance = 1
        switches[mid].status = 0 if switches[mid].status == 1 else 1

        while True:
            left = mid-distance
            right = mid+distance

            # check range 
            if left < 1 or right > switch_n:
                break

            if switches[left].status == switches[right].status:
                switches[left].status = 0 if switches[left].status == 1 else 1
                switches[right].status = 0 if switches[right].status == 1 else 1
                distance += 1
            else:
                break

for switch in switches:
    if switch == None: continue
    answer+=str(switch.status)+' '
    if switch.id % 20 == 0:
        answer += '\n'

print(answer)
