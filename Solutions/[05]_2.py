n = int(input())

array = []
for _ in range(n):
    x, y = map(int, input().split(' '))
    array.append((x, y))
array = sorted(array)

for i in array:
    print(i[0], i[1])