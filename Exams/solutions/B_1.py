n, k = map(int, input().split())
data = list(map(int, input().split()))

course = []
for i in range(n):
    # (해당 코스의 번호, 해당 코스의 길이)를 입력
    course.append((i + 1, data[i]))
# 왕복 코스를 직선 형태로 표현
course.extend(list(reversed(course)))

# 코스의 길이를 앞에서부터 빼내기
i = 0
while True:
    k -= course[i][1]
    # 지나고 있는 코스 출력 및 종료
    if k < 0:
        print(course[i][0])
        break
    i += 1