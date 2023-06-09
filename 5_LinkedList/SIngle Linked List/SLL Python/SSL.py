class Node:
    def __init__(self, val = None, nn = None):
        self.val = val
        self.next = nn

class SLL:
    def __init__(self):
        self.head = None
        
    def printList(self):
        if self.head is None:
            print("No List")
        temp = self.head
        x = ""
        while temp.next is not None:
            x = x + str(temp.val) + "--->"
            temp = temp.next
        x = x + str(temp.val)
        print(x)
        
    def addEnd(self, newVal):
        nn = Node(newVal)
        if self.head is None:
            self.head = nn
            return
        temp = self.head
        while temp.next is not None:
            temp = temp.next
        temp.next = nn
        
    def addAfter(self, newVal, prevVal):
        nn = Node(newVal)
        if self.head is None:
            return
        temp = self.head
        while temp.next is not None and temp.val is not prevVal:
            temp = temp.next
        
        newNext = temp.next
        temp.next = nn
        nn.next = newNext
        
    def deleteFirstInstance(self, target):
        temp = self.head
        prev = Node(None)
        if self.head is None:
            return
        while temp is not None:
            if temp.val is target:
                if temp is self.head:
                    self.head = self.head.next
                    break
                prev.next = temp.next
                break
            prev = temp
            temp = temp.next
            
    def deleteAllInstances(self, target):
        temp = self.head
        prev = Node(None)
        if self.head is None:
            return
        while temp is not None:
            if temp.val is target:
                if temp is self.head:
                    self.head = self.head.next
                else:
                    prev.next = temp.next
            prev = temp
            temp = temp.next
            
    def deleteFront(self):
        if self.head is None:
            return
        self.head = self.head.next
        
    def deleteEnd(self):
        if self.head is None:
            return
        temp = self.head
        prev = Node(None)
        while temp.next is not None:
            prev = temp
            temp = temp.next
        prev.next = None
    
    def swap(a, b):
        temp = a.val
        a.val = b.val
        b.val = temp
    
    def sortSLL(self):
        if self.head is None:
            return
        x = self.head
        while x is not None:
            y = x.next
            while y is not None:
                if x.val > y.val:
                    x.val, y.val = y.val, x.val
                y = y.next
            x = x.next
    
if __name__ == '__main__':
    print('The Single Linked List')
    obj = SLL()
    
    obj.addEnd(7)
    obj.addEnd(9)
    obj.addEnd(10)
    obj.addEnd(1)
    obj.addEnd(0)
    obj.addEnd(9)
    obj.addEnd(2)
    obj.addEnd(4)
    obj.printList()
    
    print("\nAdd 10 after 7")
    obj.addAfter(10,7)
    obj.printList()

    print("\nAdd 3 after 9")
    obj.addAfter(3,9)
    obj.printList()
    
    print("\nSorted List")
    obj.sortSLL()
    obj.printList()

    print("\nDelete front")
    obj.deleteFront()
    obj.printList()

    print("\nDelete end")
    obj.deleteEnd()
    obj.printList()

    print("\nDelete the first instance of 9")
    obj.deleteFirstInstance(9)
    obj.printList()

    print("\nDelete all instances of 10")
    obj.deleteAllInstances(10)
    obj.printList()