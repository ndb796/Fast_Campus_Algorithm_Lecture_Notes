document = input()
word = input()
index = 0
result = 0

while len(document) - index >= len(word):
    # 문서에서 보고 있는 단어가 찾고자 하는 단어인 경우
    if document[index:index + len(word)] == word:
        result += 1
        index += len(word)
    else:
        index += 1

print(result)