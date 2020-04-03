array = input()

for i in range(9, -1, -1):
    for j in array:
        if int(j) == i:
            print(i, end='')