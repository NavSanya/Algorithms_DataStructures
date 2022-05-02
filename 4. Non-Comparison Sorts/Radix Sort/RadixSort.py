import random


def initializeArrayWithRandomNumbers(n):
    listA = [0]
    for i in range(1, n):
        listA.append(random.randint(0, n))
    return listA


def countingSort(array, exp):
    n = len(array)
    outList = [0] * n
    cumFreq = [0] * 10

    for i in range(n):
        place = array[i] // exp
        cumFreq[place % 10] += 1

    for i in range(1, 10):
        cumFreq[i] += cumFreq[i - 1]

    i = n - 1
    while i >= 0:
        place = array[i] // exp
        outList[cumFreq[place % 10] - 1] = array[i]
        cumFreq[place % 10] -= 1
        i -= 1
    return outList


def radixSort(arr):
    m = max(arr)
    exp = 1
    while (m // exp) > 0:
        outList = countingSort(arr, exp)
        exp *= 10
    return outList


size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Radix Sort**********")
myList = radixSort(myList)
print(myList)
