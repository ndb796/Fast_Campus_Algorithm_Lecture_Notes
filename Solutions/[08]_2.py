n = int(input())
result = 0
k = 1

while n != 0: # 모든 새가 날아갈 때까지
    if k > n:
        k = 1
    n -= k
    k += 1
    result += 1

print(result)