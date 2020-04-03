n = int(input())

data = []
for _ in range(n):
    data.append(int(input()))
data.sort()

for x in data:
    print(x)