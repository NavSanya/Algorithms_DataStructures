import java.io.*;
import java.util.*;

public class SLL
{
    private Node head;

    public SLL()
    {
        head = null;
    }

    public SLL(Node h)
    {
        head = h;
    }

    public void printList()
    {
        if(head == null)
        {
            System.out.println("No List");
            return;
        }

        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.val + "--->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public void addEnd(int newVal)
    {
        Node nn = new Node(newVal, null);
	
        //if there is no list
        if(head == null)
        {
            head = nn;
            return;
        }
            
        //SLL traversal - add at the end of the list
        Node temp = head;
        while(temp.next!= null)
        {
            temp = temp.next;
        }

        temp.next = nn;
    }

    public void addAfter(int newVal, int prevVal)
    {
        Node nn = new Node(newVal, null);
	
        if(head == null)
            return;
        
        Node temp = head;
        while(temp.next != null && temp.val != prevVal)
        {
            temp = temp.next;
        }
        
        if(temp == null)
        {
            System.out.println("Not Present");
            return;
        }
        
        Node newNext = temp.next;
        temp.next = nn;
        nn.next = newNext;
    }
	
	public void deleteFirstInstance(int target)
    {
        Node temp = head;
        Node prev = null;
        int retVal;
        if(head == null)
        {
            return;
        }
    
        while(temp != null)
        {
            if(temp.val == target)
            {
                retVal = temp.val;
                if(temp == head)
                {
                    head = head.next;
                    break;
                }
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteAllInstances(int target)
    {
        Node temp = head;
        Node prev = null;

        if(head == null)
        {
            return;
        }

        while(temp != null)
        {
            if(temp.val == target)
            {
                if(temp == head)
                {
                    head = head.next;
                }
                else
                {
                prev.next = temp.next;
                }
            }
            prev = temp;
            temp = temp.next;
	    }
    }

    public void deleteFront()
    {
        if(head == null)
        {
            return;
        }

        head = head.next;
    }

    public void deleteEnd()
    {
        if(head == null)
        {
            return;
        }

        Node temp = head;
        Node prev = null;
        while(temp.next!=null)
        {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }
}




