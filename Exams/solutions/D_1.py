n = input()
length = len(n)
sum = 0

# 왼쪽 부분의 자릿수의 합 더하기
for i in range(length // 2):
    sum += int(n[i])

# 오른쪽 부분의 자릿수의 합 빼기
for i in range(length // 2, length):
    sum -= int(n[i])

if sum == 0:
    print("LUCKY")
else:
    print("READY")