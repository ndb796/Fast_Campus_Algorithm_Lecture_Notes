# 시간제한이 추가되서 유효한 코드로 변경이 필요합니다
def solve(n, x, y):
    global result
    if n == 1:
        if x == X and y == Y:
            print(result)
        result += 1
        return

    n //= 2
    for i, j in [(x, y), (x, y+n), (x+n, y), (x+n, y+n)]:
        # 가지치기 추가: 4분면 중 1곳만 탐색한다
        if (i <= X < i+n) and (j <= Y < j+n):
            solve(n, i, j)
        else:
            result += n * n


result = 0
N, X, Y = map(int, input().split())
solve(2 ** N, 0, 0)
