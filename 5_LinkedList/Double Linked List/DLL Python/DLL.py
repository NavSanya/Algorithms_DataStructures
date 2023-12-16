class NodeDLL:
    def __init__(self, val, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class DLL:
    def __init__(self):
        self.head = None
        self.tail = None

    def print_list(self):
        if not self.head:
            print("No List")
            return

        temp = self.head
        while temp.next:
            print(f"{temp.val} <---->", end="")
            temp = temp.next
        print(temp.val)

    def print_rev_list(self):
        if not self.tail:
            print("No List")
            return

        temp = self.tail
        while temp.prev:
            print(f"{temp.val} <---->", end="")
            temp = temp.prev
        print(temp.val)

    def add_end(self, new_val):
        nn = NodeDLL(new_val, None, None)

        if not self.head:
            self.head = nn
            self.tail = nn
            return

        temp = self.tail
        nn.prev = temp
        temp.next = nn
        self.tail = nn

    def add_after(self, new_val, prev_val):
        nn = NodeDLL(new_val, None, None)

        if not self.head:
            return

        temp_start = self.head
        while temp_start.next and temp_start.val != prev_val:
            temp_start = temp_start.next

        new_next = temp_start.next
        temp_start.next = nn
        nn.next = new_next
        nn.prev = temp_start
        if new_next:
            new_next.prev = nn

    def add_before(self, new_val, next_val):
        nn = NodeDLL(new_val, None, None)

        if not self.head:
            return

        temp_end = self.tail
        while temp_end.prev and temp_end.val != next_val:
            temp_end = temp_end.prev

        nn.prev = temp_end.prev
        temp_end.prev = nn
        nn.next = temp_end
        if nn.prev:
            nn.prev.next = nn

    def delete_first_instance(self, target):
        if not self.head:
            return -9999

        temp = self.head
        while temp and temp.val != target:
            temp = temp.next

        if not temp:
            print("Not Present")
            return -9999

        if temp.prev:
            temp.prev.next = temp.next
        if temp.next:
            temp.next.prev = temp.prev

        return temp.val

    def delete_all_instances(self, target):
        if not self.head:
            return

        temp = self.head
        while temp:
            if temp.val == target:
                if temp == self.head:
                    self.head = self.head.next
                    if self.head:
                        self.head.prev = None
                else:
                    temp.prev.next = temp.next
                    if temp.next:
                        temp.next.prev = temp.prev
            temp = temp.next

    def delete_front(self):
        if self.head:
            self.head = self.head.next
            if self.head:
                self.head.prev = None

    def delete_end(self):
        if self.tail:
            self.tail = self.tail.prev
            if self.tail:
                self.tail.next = None

    def swap(self, a, b):
        temp = a.val
        a.val = b.val
        b.val = temp

    def sort_dll(self):
        if not self.head:
            return

        i = self.head
        while i != self.tail.next:
            j = i.next
            while j != self.tail.next:
                if i.val > j.val:
                    self.swap(i, j)
                j = j.next
            i = i.next


# Example usage:
if __name__ == "__main__":
    print("The Double Linked List")
    obj_dll = DLL()

    obj_dll.add_end(7)
    obj_dll.add_end(9)
    obj_dll.add_end(10)
    obj_dll.add_end(1)
    obj_dll.add_end(0)
    obj_dll.add_end(9)
    obj_dll.add_end(2)
    obj_dll.add_end(4)
    obj_dll.print_list()

    print("The Reverse List")
    obj_dll.print_rev_list()

    print("Add 10 after 7")
    obj_dll.add_after(10, 7)
    obj_dll.print_list()

    print("Add 3 before 9")
    obj_dll.add_before(3, 9)
    obj_dll.print_list()

    print("Delete front")
    obj_dll.delete_front()
    obj_dll.print_list()

    print("Delete end")
    obj_dll.delete_end()
    obj_dll.print_list()

    print("Delete the first instance of 9")
    obj_dll.delete_first_instance(9)
    obj_dll.print_list()

    print("Delete all instances of 10")
    obj_dll.delete_all_instances(10)
    obj_dll.print_list()

    print("Sort List")
    obj_dll.sort_dll()
    obj_dll.print_list()
