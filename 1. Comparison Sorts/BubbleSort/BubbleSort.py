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
	
def bubbleSort(myList):
	for i in range(len(myList)):
		for j in range(len(myList)-1, i, -1):
			if myList[j] < myList[j-1]:
				temp = myList[j]
				myList[j] = myList[j-1]
				myList[j-1] = temp
	return myList

size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Bubble Sort**********")
myList = bubbleSort(myList)
print(myList)
	


