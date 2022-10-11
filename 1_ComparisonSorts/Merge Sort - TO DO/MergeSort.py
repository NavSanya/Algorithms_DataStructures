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

def merge(myList, low, high, mid):
	lengthLeft = mid - low + 1
	lengthRight = high - mid
	
	leftArray = myList[:mid]
	rightArray = myList[mid:]
	
	i = j = 0
	k = low
	while i < len(leftArray) and j < len(rightArray):
		if leftArray[i] <= rightArray[j]:
			myList[k] = leftArray[i]
			i += 1
			k += 1
		else:
			myList[k] = leftArray[j]
			j += 1
			k += 1
	
	while i < len(leftArray):
		myList[k] = leftArray[i]
        ++i
        ++k

	while j < len(rightArray):
		myList[k] = rightArray[j]
        ++j
        ++k
	return myList
	
	
def mergeSort(myList, high, low):
	if low < high:
		mid = (high + low)//2
		myList= mergeSort(myList, high, (mid+1))
    	myList = mergeSort(myList, mid, low)
    	myList = merge(myList, low, high, mid)
	return myList

size = 10
print("Unsorted Array")
myList = initializeArrayWithRandomNumbers(size)
print(myList)

print("**********Merge Sort**********")
myList = mergeSort(myList, size-1, 0)
print(myList)