#include "MaxHeapsCPlusPlus.hpp"

int main()
{
	initializeList(20);
	cout<<"Original Array\n";
	printList();
	
	cout<<"Build Max Heap\n";
	BuildMaxHeap();
	printList();
	
	cout<<"Heap Sort\n";
	HeapSort();
	printList();
	
	cout<<"Extract Max\n";
	cout<<extractMax()<<endl;
	
	cout<<"Increase Key\n";
	increaseKey(8, 87);
	printList();
	
	cout<<"Insert Value\n";
	insertVal(16);
	printList();
	
	cout<<"Heap Sort\n";
	HeapSort();
	printList();
}