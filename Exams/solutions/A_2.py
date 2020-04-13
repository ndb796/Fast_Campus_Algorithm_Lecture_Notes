n, k = map(int, input().split())
a = list(map(int, input().split()))
result = 0

def dfs(x):
    global result
    # n보다 작거나 같은 자연수에 대해서만 확인
    if x > n:
        return
    # K의 원소로만 구성된 가장 큰 수를 저장
    result = max(x, result)
    for i in a:
        # K의 원소로만 구성된 모든 수를 탐색
        dfs(x * 10 + i)

dfs(0)
print(result)