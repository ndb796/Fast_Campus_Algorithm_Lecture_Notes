import heapq

n, m = map(int, input().split(' '))
array = list(map(int, input().split(' ')))
positive = []
negative = []

# 가장 거리가 먼 책까지의 거리
largest = max(max(array), - min(array))

# 최대 힙(Max Heap)을 위해 원소를 음수로 구성
for i in array:
    # 책의 위치가 양수인 경우
    if i > 0:
        heapq.heappush(positive, -i)
    # 책의 위치가 음수인 경우
    else:
        heapq.heappush(negative, i)

result = 0

while positive:
    # 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
    result += heapq.heappop(positive)
    for _ in range(m - 1):
        if positive:
            heapq.heappop(positive)

while negative:
    # 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
    result += heapq.heappop(negative)
    for _ in range(m - 1):
        if negative:
            heapq.heappop(negative)

# 일반적으로 왕복 거리를 계산하지만, 가장 먼 곳은 편도 거리 계산
print(-result * 2 - largest)