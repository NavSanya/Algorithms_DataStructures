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
        while(temp != tail)
        {
                cout<<temp->val<<"<---->";
                temp = temp->next;
        }
        cout<<temp->val;
        cout<<endl;

        // cout<<"HEAD="<<head->val<<"\tTAIL="<<tail->val<<endl;
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
        while(tempStart->next != nullptr && tempStart->val != prevVal)
        {
                tempStart = tempStart->next;
                // tempEnd = tempEnd->prev;
        }


        Node* newNext = tempStart->next;
	tempStart->next = nn;
	nn->next = newNext;
        nn->prev = tempStart;
        nn->next->prev = nn;
       
}

void DLL::addBefore(int newVal, int nextVal)
{
        Node* nn = new Node(newVal);

        if(head==nullptr)
                return;
        
        Node* tempEnd = tail;
        while(tempEnd->prev != nullptr && tempEnd->val != nextVal)
        {
                tempEnd = tempEnd->prev;
        }

        if(tempEnd == nullptr)
        {
                cout<<"Not Present"<<endl;
		return;
        }
        
        nn->prev = tempEnd->prev;
        tempEnd->prev = nn;
        nn->next = tempEnd;
        nn->prev->next = nn;
       
}

int DLL:: deleteFirstInstance(int target)
{
        if(head == nullptr)
                return -9999;
        
        Node* temp = head;
        while(temp != nullptr && temp->val != target)
        {
                temp = temp->next;
        }

        if(temp == nullptr)
        {
                cout<<"Not Present"<<endl;
		return -9999;
        }

        temp->prev->next = temp->next;
        temp->next->prev = temp->prev;



        return temp->val;
}

void DLL:: deleteAllInstances(int target)
{
        if(head == nullptr)
                return;
        
        Node* temp = head;
        while(temp != nullptr)
        {
                if(temp->val == target)
                {
                        if(temp == head)
                        {
                                head = head->next;
                        }
                        else
                        {
                                temp->prev->next = temp->next;
                                temp->next->prev = temp->prev;
                        }
                }
                temp = temp->next;
        }

}

void DLL::deleteFront()
{
        if(head == nullptr)
	{
		return;
	}

	head = head->next;
}

void DLL::deleteEnd()
{
        if(tail == nullptr)
	{
		return;
	}

	tail = tail->prev;
}

void DLL::swap(Node* a, Node* b)
{
        int temp = a->val;
	a->val = b->val;
	b->val = temp;
}

void DLL:: sortDLL()
{
        if(head == nullptr)
	{
		return;
	}

	Node* i = head;
	Node* j;
	while(i != tail->next)
	{
		j = i->next;
		while (j != tail->next)
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

	cout<<"Add 3 before 9\n";
	obj.addBefore(3,9);
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

        cout<<"Sort List\n";
	obj.sortDLL();
	obj.printList();
    
    	return 0;
}