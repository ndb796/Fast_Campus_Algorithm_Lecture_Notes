n = int(input())

array = []
for _ in range(n):
    data = input().split(' ')
    array.append((int(data[0]), data[1]))
array = sorted(array, key=lambda x: x[0])

for i in array:
    print(i[0], i[1])