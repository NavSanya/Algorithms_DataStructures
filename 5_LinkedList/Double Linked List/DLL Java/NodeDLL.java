public class NodeDLL {
        int val;
        NodeDLL next;
        NodeDLL prev;

        NodeDLL() {
                val = 0;
                next = null;
                prev = null;
        }

        NodeDLL(int v, NodeDLL n, NodeDLL p) {
                val = v;
                next = n;
                prev = p;

        }
}
