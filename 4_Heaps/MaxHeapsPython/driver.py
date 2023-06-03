from MaxHeapsList import *
def main():
        initializeList(20)
        print("Original List")
        print(myList)
        
        print("Build Max Heap")
        BuildMaxHeap()
        print(myList)
        
        print("Heap Sort")
        HeapSort()
        print(myList)
        
        print("Extract Max")
        print(extractMax())
        
        print("Increase key")
        increaseKey(8, 87)
        print(myList)
        
        print("Insert Value")
        insertVal(16)
        print(myList)
        
        print("Heap Sort")
        HeapSort()
        print(myList)

if __name__ == "__main__":
        main()