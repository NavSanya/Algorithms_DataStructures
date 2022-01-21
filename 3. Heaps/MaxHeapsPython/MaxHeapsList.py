import random

myList = []

def initializeList(n):
	myList.append(int(inf))
	for i in range(n-1):
        myList.append(random.randint(0,n))

def LeftChild(i):
	return 2*i
	
def RightChild(i):
	return (2*i)+1

def Parent(i):
	return i/2
	
def MaxHeapify(i, n):
	l = LeftChild(i)
	r = RightChild(i)
	if l<n and myList[l]>myList[i]:
		largest = l
	else 
		largest = i
	if r<n and myList[r]>myList[largest]:
		largest = r
	
	if largest /= i:
		myList[i], myList[largest] = myList[largest], myList[i]
		MaxHeapify(largest, n)

def BuildMaxHeap(n):
