n, k = map(int, input().split())
array = list(map(int, input().split()))
array = sorted(array)
print(array[k - 1])