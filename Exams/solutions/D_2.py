from itertools import permutations

n, k = map(int, input().split())
a = list(map(int, input().split()))
result = 0

# 운동 키트를 이용하는 모든 경우를 계산
for data in permutations(a):
    check = True
    weight = 500
    # 매일매일의 운동 키트를 확인
    for i in data:
        weight += i
        weight -= k
        # 중량이 500보다 낮아지는 날이 있는지 체크
        if weight < 500:
            check = False
            break
    # 매일매일 항상 중량 500 이상이라면, 카운트
    if check:
        result += 1

print(result)