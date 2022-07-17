#include "SLL.hpp"

SLL::SLL()
{
	head = nullptr;
}
	
SLL::SLL(Node* h)
{
	head = h;
}

void SLL::printList()
{
	if(head==nullptr)
	{
		cout<<"No List\n";
		return;
	}
	Node* temp  = head;
	while(temp->next!= nullptr)
	{
		cout<<temp->val<<"--->";
		temp = temp->next;
	}
	cout<<temp->val;
	cout<<endl;
}
	
void SLL::addEnd(int newVal)
{
	Node* nn = new Node(newVal);
	
	//if there is no list
	if(head == nullptr)
	{
		head = nn;
		return;
	}
		
	//SLL traversal - add at the end of the list
	Node* temp = head;
	while(temp->next!= nullptr)
	{
		temp = temp->next;
	}

	temp->next = nn;
}

void SLL::addAfter(int newVal, int prevVal)
{
	Node* nn = new Node(newVal);
	
	if(head == nullptr)
		return;
	
	Node* temp = head;
	while(temp->next != nullptr && temp->val != prevVal)
	{
		temp = temp->next;
	}
	
	if(temp == nullptr)
	{
		cout<<"Not Present"<<endl;
		return;
	}
	
	Node* newNext = temp->next;
	temp->next = nn;
	nn->next = newNext;
}

int SLL::deleteFirstInstance(int target)
{
	Node* temp = head;
	Node* prev;
	Node* toDelete;
	int retVal;
	if(head == nullptr)
	{
		return -9999;
	}

	while(temp != nullptr)
	{
		if(temp->val == target)
		{
			retVal = temp->val;
			toDelete = temp;
			if(temp == head)
			{
				head = head->next;
				break;
			}
			prev->next = temp->next;
			break;
		}
		prev = temp;
		temp = temp->next;
	}
	return retVal;;
}

void SLL::deleteAllInstances(int target)
{
	Node* temp = head;
	Node* prev;
	Node* toDelete;

	if(head == nullptr)
	{
		return;
	}

	while(temp != nullptr)
	{
		if(temp->val == target)
		{
			toDelete = temp;
			if(temp == head)
			{
				head = head->next;
			}
			else
			{
			prev->next = temp->next;
			}
		}
		prev = temp;
		temp = temp->next;
	}
}

void SLL::deleteFront()
{
	if(head == nullptr)
	{
		return;
	}

	Node* toDelete = head;
	head = head->next;
}

void SLL::deleteEnd()
{
	if(head == nullptr)
	{
		return;
	}

	Node* temp = head;
	Node* prev;
	while(temp->next!=nullptr)
	{
		prev = temp;
		temp = temp->next;
	}
	prev->next = nullptr;
}

void SLL::swap(Node*a, Node*b)
{
	int temp = a->val;
	a->val = b->val;
	b->val = temp;
}

void SLL:: sortSLL()
{
	if(head == nullptr)
	{
		return;
	}

	Node* end;
	Node* i = head;
	Node* j;
	while(i!=nullptr)
	{
		j = i->next;
		while (j!=nullptr)
		{
			if(i->val > j->val)
			{
				swap(i, j);
			}
			j = j->next;
		}
		i = i->next;
	}

}

int main()
{
	cout<<"The Single Liked List\n";
    SLL obj;
	obj.addEnd(7);
	obj.addEnd(9);
	obj.addEnd(10);
	obj.addEnd(1);
	obj.addEnd(0);
	obj.addEnd(9);
	obj.addEnd(2);
	obj.addEnd(4);
	obj.printList();

	cout<<"Add 10 after 7\n";
	obj.addAfter(10,7);
	obj.printList();

	cout<<"Add 3 after 9\n";
	obj.addAfter(3,9);
	obj.printList();

	cout<<"Delete front\n";
	obj.deleteFront();
	obj.printList();

	cout<<"Delete end\n";
	obj.deleteEnd();
	obj.printList();

	cout<<"Delete the first instance of 9\n";
	obj.deleteFirstInstance(9);
	obj.printList();

	cout<<"Delete all instances of 10\n";
	obj.deleteAllInstances(10);
	obj.printList();
    
    return 0;
}

