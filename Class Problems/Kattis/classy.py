def classy():
    n = int(input())

    dict = {}
    maxLen = 0
    for i in range(n):
        l = input().split(": ")
        k = l[0]
        tempS = l[1].split(" ")
        classes = list(tempS[0].split("-"))
        classes = [scores[i] for i in classes]
        classes = classes[::-1]
        maxLen = max(maxLen, len(classes))

        dict[k] = classes

    finalDict = {}

    for key, value in (dict.items()):
        score = 0
        li = [i for i in value]
        score = sum(li)
        score += (maxLen-len(value))*5
        finalDict[key] = score

    tempL = list(finalDict.items())
    tempL.sort()
    sortedFinal = sorted(tempL, key=lambda x: (x[1]), reverse=True)
    return sortedFinal

t = int(input())
scores = {"upper": 10, "middle": 5, "lower": 1}
for i in range(t):
    ans = classy()
    for i, tuple in enumerate(ans):
        print(tuple[0])
    print("="*30)


# sortedDict = dict(sorted(finalDict.items(), key=lambda item: item[1]))
# print(t)
# print(n)
# print(dict)
# print(finalDict)
# print("Sorted Dict: ", sortedFinal)
#dict.items()
#finalDict.items()
