from collections import deque

n, m = map(int, input().split())
x, y = map(int, input().split())

# 모든 상대편 말의 위치를 저장
enemy = []
for i in range(m):
    a, b = map(int, input().split())
    enemy.append((a, b))

# 보드 전체를 -1으로 초기화
board = [[-1] * (n + 1) for _ in range(n + 1)]
# 나이트가 이동할 수 있는 8가지의 위치
dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

# 현재 위치를 큐에 삽입
q = deque()
q.append((x, y))
# 현재 위치에 대한 최소 이동 수는 0
board[x][y] = 0

# 보드의 모든 위치에 대하여 최소 이동 수를 계산
while q:
    x, y = q.popleft()
    # 8가지 위치를 각각 확인
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        # 해당 위치로 이동할 수 있는 경우
        if 1 <= nx and nx <= n and 1 <= ny and ny <= n:
            # 방문한 적 없다면, 그 위치로의 최소 이동 수 계산
            if board[nx][ny] == -1:
                board[nx][ny] = board[x][y] + 1
                q.append((nx, ny))

# 모든 상대편 말까지의 최소 이동 수 출력
for a, b in enemy:
    print(board[a][b], end=' ')