n, m = map(int, input().split())

board = []
for _ in range(n):
    board.append(list(map(int, input().split())))
v = [[False] * m for _ in range(n)]

def dfs(x, y):
    # 아래 끝까지 내려 온 경우 0을 반환
    if x == n:
        return 0
    # 오른쪽 끝까지 이동한 경우 아래로 한 칸 내려가기
    if y == m:
        return dfs(x + 1, 0)
    result = 0
    # (x, y)를 기준으로 1번째 모양
    if x + 1 < n and y + 1 < m and v[x][y] + v[x][y + 1] + v[x + 1][y + 1] == 0:
        v[x][y] = v[x][y + 1] = v[x + 1][y + 1] = True
        result = max(result, dfs(x, y + 1) + (board[x][y] + 2 * board[x][y + 1] + board[x + 1][y + 1]))
        v[x][y] = v[x][y + 1] = v[x + 1][y + 1] = False
    # (x, y)를 기준으로 2번째 모양
    if x + 1 < n and y + 1 < m and v[x][y + 1] + v[x + 1][y] + v[x + 1][y + 1] == 0:
        v[x][y + 1] = v[x + 1][y] = v[x + 1][y + 1] = True
        result = max(result, dfs(x, y + 1) + (board[x][y + 1] + board[x + 1][y] + 2 * board[x + 1][y + 1]))
        v[x][y + 1] = v[x + 1][y] = v[x + 1][y + 1] = False
    # (x, y)를 기준으로 3번째 모양
    if x + 1 < n and y + 1 < m and v[x][y] + v[x + 1][y] + v[x + 1][y + 1] == 0:
        v[x][y] = v[x + 1][y] = v[x + 1][y + 1] = True
        result = max(result, dfs(x, y + 1) + (board[x][y] + 2 * board[x + 1][y] + board[x + 1][y + 1]))
        v[x][y] = v[x + 1][y] = v[x + 1][y + 1] = False
    # (x, y)를 기준으로 4번째 모양
    if x + 1 < n and y + 1 < m and v[x][y] + v[x][y + 1] + v[x + 1][y] == 0:
        v[x][y] = v[x][y + 1] = v[x + 1][y] = True
        result = max(result, dfs(x, y + 1) + (2 * board[x][y] + board[x][y + 1] + board[x + 1][y]))
        v[x][y] = v[x][y + 1] = v[x + 1][y] = False
    # 현재 위치를 기준으로 부메랑을 만들지 않는 경우
    result = max(result, dfs(x, y + 1))
    return result

print(dfs(0, 0))