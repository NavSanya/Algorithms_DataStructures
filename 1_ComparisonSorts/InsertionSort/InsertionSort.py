import random
 
"""
 creating an array of size n
 initializing the arry with random values
"""
def initializeArrayWithRandomNumbers(n):
    myList = []
    for i in range(n):
        myList.append(random.randint(0,n))
    return myList
	
def insertionSort(myList):
	for i in range(len(myList)):
		key = myList[i]
		j=i-1
		while j >= 0 and myList[j] > key:
			myList[j+1] = myList[j]
			j = j-1
		myList[j+1] = key
	return myList

size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Insertion Sort**********")
myList = insertionSort(myList)
print(myList)