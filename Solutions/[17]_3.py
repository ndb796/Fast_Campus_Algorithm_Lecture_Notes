n = int(input())
array = []

for _ in range(n):
    array.append(int(input()))
    
# 오름차순 정렬 수행
array.sort()

# 불만도의 합 계산
result = 0
for i in range(1, len(array) + 1):
    result += abs(i - array[i - 1])

print(result)