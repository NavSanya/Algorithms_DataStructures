import random
import numpy as np
myList = []

def initializeList(n):
	myList.append(np.inf)
	for i in range(n-1):
		myList.append(random.randint(0,n))

def LeftChild(i):
	return 2 * i
	
def RightChild(i):
	return (2 * i) + 1

def Parent(i):
	return i // 2
	
def MaxHeapify(i, n):
	l = LeftChild(i)
	r = RightChild(i)
	if l < n and myList[l] > myList[i]:
		largest = l
	else:
		largest = i
	if r < n and myList[r] > myList[largest]:
		largest = r
	if largest != i:
		myList[i], myList[largest] = myList[largest], myList[i]
		MaxHeapify(largest, n)

def BuildMaxHeap():
        n = len(myList)
        for i in range (n//2, 0, -1):
                MaxHeapify(i, n)

def HeapSort():
        n = len(myList)
        BuildMaxHeap()
        for i in range (n - 1, 1, -1):
                myList[1], myList[i] = myList[i], myList[1]
                MaxHeapify(1, i - 1)

def extractMax():
        n = len(myList)
        if n < 1:
                print("Underflow\n")
                return -999
        BuildMaxHeap()
        max = myList[1]
        myList[1] = myList[n-1]
        MaxHeapify(1, n-1)
        return max
 
def increaseKey(i, key):
        if key < myList[i]:
                print("New key smaller than current key\n")
        myList[i] = key
        while i > 1 and myList[Parent(i)] < myList[i]:
                myList[Parent(i)], myList[i] = myList[i], myList[Parent(i)]
                i = Parent(i)
                
def insertVal(key):
        n = len(myList)
        myList.append(key)
        increaseKey(n, key)        


