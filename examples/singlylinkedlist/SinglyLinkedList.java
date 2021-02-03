public class SinglyLinkedList {
     Node startPtr = null;
     public void insertBegininning(int data)
    {
        Node newNode = new Node(data);
        if(startPtr == null)
        {
            //the starting node becomes the first element
            startPtr = newNode;
            //the pointer becomes null since it is the only element in the list
            startPtr.next = null;
        }
        else
        {
            //the starting node becomes the next node to the newnode
            newNode.next = startPtr;
            //assign the newNode as the starting node
            startPtr = newNode;
        }
    }

    public void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if(startPtr == null)
        {
            startPtr = newNode;
            startPtr.next = null;
        }
        else
        { //initialize a current pointer that will start iterating from the begininng of the list
            Node current = startPtr;
            // iterate through until next is null
            while(current.next != null)
            {
                current = current.next;
            }
            //once we reach end of the list reassign the pointers
            current.next = newNode;// now the new node is added to the end of the list
            newNode.next = null;
        }
      

    }
    public void insertMid(int data,int pos)
    {
        Node newNode = new Node(data);
        // check if position is not less than 0 or position is not greater than the size of the list
        if(pos < 0 || pos > getSize())
            System.out.println("Invalid position");
            //if pos = 0 ie first element, just realign newNode as first element or node in the LL
        if(pos == 0)
        {
            newNode.next = startPtr;
            startPtr = newNode;
        }
        else{
            Node current = startPtr;
            Node previous = null;
            //a counter to keep track of index
            int i = 0;
            while(i<pos)
            {
                //as long as i the index is less than the pos we have passed, realign the pointers
                //because the elements need to be pushed down to accomodate the new node
                previous = current;
                current = current.next;
                //increment i
                i++;
            }
            //now realign the pointers accordingly
            newNode.next = current;
            previous.next = newNode;

        }
    }
    public int getSize()
    {
        int length = 0;
        Node current = startPtr;
        if(startPtr == null)
            return 0;
        else{
            while(current!=null)
            {
                current = current.next;
                length++;
            }
        }
        return length;
    }
    public int getIndex(int data)
    {
        Node current = startPtr;
        int i = 0;
        boolean flag = false;
        //until current is not null check for equality, if values are equal, then break out
        // the index is reached and return it, else increment i and re iterate until value is found
        while(current!= null)
        {
            if(current.data == data)
            {
                flag = true;
                break;
            }
            else
                flag = false;
            i = i+1;
            current = current.next;

        }
        if(flag)
            return i;
        else
            return -1;
    }
    public void traverse()
    {
        Node current = startPtr;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public void delete(int data)
    {
        Node current = startPtr;
        Node previous = null;
        //if the data to be deleted is the first element of the list
        if(current.data == data)
        {
            startPtr = current.next;
            return;
        }
        else{
            while(current!=null && current.data!=data)
            {
                //since deletion will push the values back on the list, make current as previous node
                // until end of the list
                previous = current;
                current = current.next;
            }
            //if the element is not found at all just return
            if(current == null) return;
            // or else realign the pointer
            //current will hold the element to be deleted so just un plug it 
            previous.next = current.next;
        }
    }

}
