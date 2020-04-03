n, c = list(map(int, input().split(' ')))

data = []
for _ in range(n):
     data.append(int(input()))
data.sort()

start = data[1] - data[0]
end = data[-1] - data[0]
result = 0

while(start <= end):
    mid = (start + end) // 2 # mid는 가장 인접한 두 공유기 사이의 거리(Gap)을 의미합니다.
    value = data[0]
    count = 1
    for i in range(1, len(data)): # 현재의 mid 값을 이용해 공유기를 설치 해보기
        if data[i] >= value + mid:
            value = data[i]
            count += 1
    if count >= c: # C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시킵니다.
        start = mid + 1
        result = mid # 최적의 결과를 저장합니다.
    else: # C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시킵니다.
        end = mid - 1

print(result)