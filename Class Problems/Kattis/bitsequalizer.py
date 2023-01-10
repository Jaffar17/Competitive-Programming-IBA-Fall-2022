cases = int(input())
S = []
T = []
final = []
for i in range(cases):
    S.append(input())
    T.append(input())

for i in range(len(S)):
    diffCount = 0
    count01 = 0
    count10 = 0
    flag = False
    for j in range(len(S[i])):
        s0 = S[i].count("0")
        s1 = S[i].count("1")
        t0 = T[i].count("0")
        t1 = T[i].count("1")

        if (s1 > t1):
            final.append(-1)
            flag = True
            break
        else:
            if (S[i][j] != T[i][j]):
                diffCount += 1
            if (S[i][j] == "0" and T[i][j] == "1"):
                count01 += 1
            if (S[i][j] == "1" and T[i][j] == "0"):
                count10 += 1

    if flag == False:
        final.append(diffCount - min(count01, count10))

for i in range(len(final)):
    print("Case {}: {}".format(i+1, final[i]))


