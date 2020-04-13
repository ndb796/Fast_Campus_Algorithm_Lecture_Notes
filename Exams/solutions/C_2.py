n, m, h = map(int, input().split())
a = []
d = [0] * (h + 1)
for i in range(n):
    a.append(list(map(int, input().split())))

d[0] = 1

# 모든 학생에 대하여 처리
for i in range(n):
    data = []
    # 0부터 h까지의 모든 높이에 대하여 처리
    for j in range(h + 1):
        for k in range(len(a[i])):
            # 현재 학생의 블록으로 특정 높이의 탑을 쌓을 수 있는 경우
            if d[j] != 0 and j + a[i][k] <= h:
                data.append((j + a[i][k], d[j]))
    # 쌓을 수 있는 높이에 대하여, 경우의 수 증가
    for height, value in data:
        d[height] = (d[height] + value) % 10007

print(d[h])