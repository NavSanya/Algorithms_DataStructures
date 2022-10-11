import random
 
"""
 creating an array of size n
 initializing the array with random values
"""
def initializeArrayWithRandomNumbers(n):
	myList = []
	for i in range(n):
		myList.append(random.randint(0,n))
	return myList
	
def linearSearch(myList, tar):
	for i in range (len(myList)):
		if (myList[i] == tar):
			return i
	return -1

size = 10
print("Array that needs to be searched through")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Linear Search**********")
tar = random.randint(0,size)
print("Value to be found: ", tar)
myPos = linearSearch(myList, tar)
print("Value present on Index: ", myPos)