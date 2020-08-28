from itertools import permutations

n = int(input())
nList = list(map(int, input().split()))
cList = list(permutations(nList))
maxans = 0
for c in cList:
    ans = 0
    for i in range(n-1):
        ans += abs(c[i]-c[i+1])
    if ans > maxans:
        maxans = ans
print(maxans)
