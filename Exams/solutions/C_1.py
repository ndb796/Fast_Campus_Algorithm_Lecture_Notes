n, k = map(int, input().split())
count = 0
 
# 0시 0분 0초부터 N시 59분 59초까지의 모든 시각 확인
for h in range(n + 1):
    for m in range(60):
        for s in range(60):
            hour = str(h) if h >= 10 else '0' + str(h)
            minute = str(m) if m >= 10 else '0' + str(m)
            second = str(s) if s >= 10 else '0' + str(s)
            # K가 포함되는 경우 카운트
            if str(k) in hour + minute + second:
                count += 1

print(count)