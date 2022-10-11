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
	
def binarySearch(myList, target, low, high):
	if low>high:
		return -1
	mid = int((low + high) / 2)
	if target == myList[mid]:
		return mid
	if target < myList[mid]:
		return binarySearch(myList, target, low, mid)
	if target > myList[mid]:
		return binarySearch(myList, target, mid+1, high)
	
size = 10
print("Array that needs to be searched through")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Binary Search**********")
myList.sort()
tar = random.randint(0,size)
print ("Sorted Array")
print(myList)
print("Value to be found: ", tar)
myPos = binarySearch(myList, tar, 0, len(myList)-1)
print("Value present on Index: ", myPos)