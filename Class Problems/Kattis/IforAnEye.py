def charConversion(word):
    list1 = list(word)
    list1Len = len(list1)
    index = 0
    while (index < list1Len - 1):
        if (index < list1Len - 3 and word[index:index+4] in conversionRules["four char"]):
            list1[index] = conversionRules["four char"][word[index:index+4]]
            list1[index+1] = 'useless'
            list1[index+2] = 'useless'
            list1[index+3] = 'useless'
            index += 4
        elif (index < list1Len - 2 and word[index:index+3] in conversionRules["three char"]):
            list1[index] = conversionRules["three char"][word[index:index+3]]
            list1[index+1] = 'useless'
            list1[index+2] = 'useless'
            index += 3
        elif (word[index:index+2] in conversionRules["two char"]):
            list1[index] = conversionRules["two char"][word[index:index+2]]
            list1[index+1] = 'useless'
            index += 2
        else:
            index += 1

    return ''.join((c for c in list1 if c != 'useless'))

n = int(input())

conversionRules = {
    "two char": {
        'at': '@',
        'to': '2',
        'be': 'b',
        'oh': 'o',

        'At': '@',
        'To': '2',
        'Be': 'B',
        'Oh': 'O'
    },
    "three char": {
        'and': '&',
        'one': '1',
        'won': '1',
        'too': '2',
        'two': '2',
        'for': '4',
        'bea': 'b',
        'bee': 'b',
        'sea': 'c',
        'see': 'c',
        'eye': 'i',
        'owe': 'o',
        'are': 'r',
        'you': 'u',
        'why': 'y',

        'And': '&',
        'One': '1',
        'Won': '1',
        'Too': '2',
        'Two': '2',
        'For': '4',
        'Bea': 'B',
        'Bee': 'B',
        'Sea': 'C',
        'See': 'C',
        'Eye': 'I',
        'Owe': 'O',
        'Are': 'R',
        'You': 'U',
        'Why': 'Y'
    },
    "four char": {
        'four': '4',

        'Four': '4'
    }
}

for i in range(n):
    # for word in input().split():
    #     print(" ".join(charConversion(word)))
    print(" ".join((charConversion(word) for word in input().split())))


