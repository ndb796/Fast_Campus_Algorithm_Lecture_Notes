from collections import deque

n, k = map(int, input().split())
a = list(map(int, input().split()))
visited = set(a)

# 모든 샘터의 왼쪽, 오른쪽에 대하여 확인
q = deque()
for i in a:
    # (거리, 위치)를 큐에 삽입
    q.append((1, i - 1))
    q.append((1, i + 1))

count = 0
result = 0

# BFS 수행 (K채의 집이 배치될 때까지)
while count < k:
    distance, now = q.popleft()
    # 해당 위치에 샘터 혹은 집이 존재한다면 무시
    if now in visited:
        continue
    visited.add(now)
    # 해당 위치에 집을 배치
    result += distance
    # 그 위치의 왼쪽, 오른쪽에 대하여 다시 확인
    q.append((distance + 1, now - 1))
    q.append((distance + 1, now + 1))
    count += 1

print(result)