import copy

result = []
string = []
visited = []

# 조합(Combination) 함수 구현
def combination(array, length, index):
    # 길이가 length인 모든 조합 찾기
    if len(string) == length:
        result.append(copy.deepcopy(string))
        return
    # 각 원소를 한 번씩만 뽑도록 구성
    for i in range(index, len(array)):
        if i in visited:
            continue
        string.append(array[i])
        visited.append(i)
        combination(array, length, i + 1)
        string.pop()
        visited.pop()

vowels = ('a', 'e', 'i', 'o', 'u')
l, c = map(int, input().split(' '))

# 가능한 암호를 사전식으로 출력해야 하므로 정렬 수행
array = input().split(' ')
array.sort()

combination(array, l, 0)

# 길이가 l인 모든 암호 조합을 확인
for password in result:
    # 모음의 개수를 세기
    count = 0
    for i in password:
        if i in vowels:
            count += 1

    # 최소 한 개의 모음과 최소 두 개의 자음이 있는 경우 출력
    if count >= 1 and count <= l - 2:
        print(''.join(password))