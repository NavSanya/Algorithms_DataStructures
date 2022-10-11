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
	
def selectionSort(myList):
	for i in range(len(myList)-1):
		smallest = myList[i]
		smallpos = i
		for j in range(i+1, len(myList)):
			if myList[j] < smallest:
				smallest = myList[j]
				smallpos = j
		temp = myList[i]
		myList[i] = myList[smallpos]
		myList[smallpos] = temp
	return myList

size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Selection Sort**********")
myList = selectionSort(myList)
print(myList)