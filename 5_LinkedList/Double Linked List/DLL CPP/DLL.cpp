#include "DLL.hpp"

DLL::DLL()
{
        head = nullptr;
        tail = nullptr;
}

DLL::DLL(Node* h)
{
        head = h;
        tail = h;
}

void DLL::printList()
{
        if(head == nullptr)
        {
                cout<<"No List\n";
                return;
        }
        Node* temp = head;
        while(temp->next != nullptr)
        {
                cout<<temp->val<<"<---->";
                temp = temp->next;
        }
        cout<<temp->val;
        cout<<endl;

        //cout<<"HEAD="<<head->val<<"\tTAIL="<<tail->val<<endl;
}

void DLL::printRevList()
{
        if(tail == nullptr)
        {
                cout<<"No List\n";
                return;
        }
        Node* temp = tail;
        while(temp->prev != nullptr)
        {
                cout<<temp->val<<"<---->";
                temp = temp->prev;
        }
        cout<<temp->val;
        cout<<endl;
}

void DLL::addEnd(int newVal)
{
        Node* nn = new Node(newVal);

        //if there is no list
        if(head == nullptr)
	{
		head = nn;
                tail = nn;
		return;
	}
	

	Node* temp = tail;
        nn->prev = temp;
	temp->next = nn;
        tail = nn;
}

void DLL::addAfter(int newVal, int prevVal)
{
        Node* nn = new Node(newVal);

        if(head==nullptr)
                return;
        
        Node* tempStart = head;
        Node* tempEnd = tail;
        while(tempStart != tempEnd->next && (tempStart->val != prevVal || tempEnd->val != prevVal))
        {
                tempStart = tempStart->next;
                tempEnd = tempEnd->prev;
        }

        if(tempStart == tempEnd->next)
        {
                cout<<"Not Present"<<endl;
		return;
        }

        if(tempStart->val == prevVal)
        {
                Node* newNext = tempStart->next;
	        tempStart->next = nn;
	        nn->next = newNext;

        }

        if (tempEnd->val == prevVal)
        {
                Node* newNext = tempEnd->next;
	        tempEnd->next = nn;
	        nn->next = newNext;
        }
        
}

void DLL::addBefore(int newVal, int nextVal)
{
        Node* nn = new Node(newVal);

        if(head==nullptr)
                return;
        
        Node* tempStart = head;
        Node* tempEnd = tail;
        while(tempStart != tempEnd->prev && (tempStart->val != nextVal || tempEnd->val != nextVal))
        {
                tempStart = tempStart->next;
                tempEnd = tempEnd->prev;
        }

        if(tempStart == tempEnd->prev)
        {
                cout<<"Not Present"<<endl;
		return;
        }

        if(tempStart->val == nextVal)
        {
                Node* newPrev = tempStart->prev;
	        tempStart->prev = nn;
	        nn->prev = newPrev;
        }

        if (tempEnd->val == nextVal)
        {
                Node* newPrev = tempEnd->prev;
	        tempEnd->prev = nn;
	        nn->prev = newPrev;
        }
        
}



int main()
{
	cout<<"The Double Liked List\n";
    	DLL obj;
	obj.addEnd(7);
	obj.addEnd(9);
	obj.addEnd(10);
	obj.addEnd(1);
	obj.addEnd(0);
	obj.addEnd(9);
	obj.addEnd(2);
	obj.addEnd(4);
	obj.printList();
        cout<<"Reverse List\n";
        obj.printRevList();

	cout<<"Add 10 after 7\n";
	obj.addAfter(10,7);
	obj.printList();

	// cout<<"Add 3 after 9\n";
	// obj.addAfter(3,9);
	// obj.printList();

	// cout<<"Sort List\n";
	// obj.sortSLL();
	// obj.printList();

	// cout<<"Delete front\n";
	// obj.deleteFront();
	// obj.printList();

	// cout<<"Delete end\n";
	// obj.deleteEnd();
	// obj.printList();

	// cout<<"Delete the first instance of 9\n";
	// obj.deleteFirstInstance(9);
	// obj.printList();

	// cout<<"Delete all instances of 10\n";
	// obj.deleteAllInstances(10);
	// obj.printList();
    
    	return 0;
}