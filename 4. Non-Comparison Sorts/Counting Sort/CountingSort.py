import random


def initializeArrayWithRandomNumbers(n):
    myList = []
    myList.append(0)
    for i in range(1, n):
        myList.append(random.randint(0, n))
    return myList


def countingSort(myList):
    n = len(myList)
    outList = [0] * n
    maxvalue = max(myList)
    cumFreq = [0] * (maxvalue + 1)

    for i in range(n):
        cumFreq[myList[i]] += 1

    for i in range(1, maxvalue+1):
        cumFreq[i] += cumFreq[i - 1]

    for i in range(n - 1, -1, -1):
        outList[cumFreq[myList[i]]-1] = myList[i]
        cumFreq[myList[i]] -= 1

    return outList


size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Counting Sort**********")
myList = countingSort(myList)
print(myList)
