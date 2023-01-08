n = int(input())

dict = {}
for i in range(n):
    dest, year = input().split()
    year = int(year)
    if dest not in dict:
        dict[dest] = []
    dict[dest].append(year)

for key in dict:
    dict[key].sort()

q = int(input())
for i in range(q):
    key, index = input().split()
    index = int(index)
    index = index - 1
    print(dict[key][index])

