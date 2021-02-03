public class DoublyLinkedList {
    public Node startPtr;
    public void insertBegin(int data)
    {
        Node newNode = new Node(data);
        if(startPtr == null)
        {
            startPtr = newNode;
            startPtr.previous = null;
        }
        else
        {
            newNode.next = startPtr;
            startPtr.previous = newNode;
            startPtr = newNode;
        }

    }
    public void insertEnd(int data)
    {
        Node newNode = new Node(data);
        Node temp = null;
        if(startPtr == null)
        {
            startPtr = newNode;
            startPtr.previous = null;
        }
        else{
            temp = startPtr;
            //goto the end of the list
            while(temp.next!=null)
            {
                temp = temp.next;
            } 

            // reached end of the list
            // reassign the pointers
            temp.next = newNode;
            newNode.previous = temp;
            newNode.next = null;
        }
    }
    public void delete(int data)
    {
        Node current = startPtr;
        //keep track of the elements of the list
        Node temp = null;
        while(current!=null && current.data!=data)
        {
            temp = current;
            current = current.next;
        }
        if(current == null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        //the item to be deleted is not the first element
        if(temp!=null)
            temp.next = current.next;
        //if item is the first element
        else
            startPtr = startPtr.next;
        //if item is not the last element
        if(current.next != null)
            current.next.previous = temp;
    }
    public void forwardTraversal()
    {
        Node current = startPtr;
        if(current == null)
            return;
        while(current != null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public void reverseTraversal()
    {
        Node current = startPtr;
        while(current.next != null)
        {
            current = current.next;
        }
        // reached the end of the list
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.previous;
        }

    }
}
