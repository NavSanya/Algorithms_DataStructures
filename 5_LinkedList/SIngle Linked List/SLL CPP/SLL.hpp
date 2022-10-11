#include <iostream>
using namespace std;

class Node
{
	public:
	int val;
	Node* next;
	
	Node(int v = 0, Node* n = nullptr)
	{
		val = v;
		next = n;
	}
};

class SLL
{
	private:
	Node* head;
	
	public:
	
	//Default Constructor
	SLL();
	//Parameterized constructor
	SLL(Node* h);
	//print Linked List
	void printList();
	//Swap values of two nodes
	void swap(Node*a, Node*b);
	//add at the end of the list
	void addEnd(int newVal);
	//add after the specified value
	void addAfter(int newVal, int prevVal);
	//delete a node of a specific value (first instance) and return it
	int deleteFirstInstance(int target);
	//delete a node of a specific value (all instances)
	void deleteAllInstances(int target);
	//delete from the head/front of the list
	void deleteFront();
	//delete from the end of the list
	void deleteEnd();
	//Sort List (Ascending order) - Bubble Sort
	void sortSLL();
	
};