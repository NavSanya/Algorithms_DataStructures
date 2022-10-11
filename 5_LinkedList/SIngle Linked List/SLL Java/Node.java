public class Node 
{
    int val;
    Node next;

    Node()
    {
        val = 0;
        next = null;
    }

    Node(int v, Node n)
    {
        val = v;
        next = n;
    }
}
