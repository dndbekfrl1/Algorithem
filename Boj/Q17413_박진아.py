S = input()
is_tag = False

reversed_str = ''
res = [] 

for s in S:
    if s == '<':
        is_tag = True
        tag_str = ''
        res.append(reversed_str.rstrip())
        reversed_str = ''   

    if is_tag:
        tag_str += s
        if s == '>': 
            is_tag = False
            res.append(tag_str)
    else:
        if s == ' ':
            res.append(reversed_str.rstrip())
            res.append(' ')
            reversed_str = ''
        reversed_str = s + reversed_str

if not reversed_str == '': res.append(reversed_str)
print(''.join(res))


