public class SingleLinkedList {
    Node startPtr = null;

    public void insert(Word data){
        Node newNode = new Node(data);
        if(startPtr == null){
            startPtr = newNode;
            startPtr.next = null;
        }
        else{
            Node current = startPtr;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }

    }

    public void traverse(){
        Node current = startPtr;
        while(current!=null){
            System.out.println(current.data.getWord()+" -> " +current.data.getOccurance());
            current = current.next;
        }
    }

    public void removeDuplicates(){
        Node current = null, temp = null, dup = null;
        current = startPtr;

        while(current != null && current.next != null){
            temp = current;
            int count = 0;
            while(temp.next != null){
                if((current.data.getWord()).equals(temp.next.data.getWord())){
                    dup = temp.next;
                    temp.next = temp.next.next;
                    System.gc();
                    count = count+1;
                }
                else {
                    temp = temp.next;
                }
            }
            current.data.setOccurance(count+1);
            current = current.next;
        }
    }

    Node paritionLast(Node start, Node end){
        if(start == end || start == null || end == null){
            return start;
        }
        Node pivot_prev = start;
        Node current = start;
        Word pivot = end.data;

        while(start != end){
            if((start.data.getWord()).compareTo(pivot.getWord()) < 0){
                pivot_prev = current;
                Word temp = current.data;
                current.data = start.data;
                start.data = temp;
                current = current.next;
            }
            start = start.next;
        }

        Word temp = current.data;
        current.data = pivot;
        end.data = temp;

        return pivot_prev;
    }

    void quickSort(Node start, Node end){
        if(start == end)
            return;
        
        Node pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);
        if( pivot_prev != null && pivot_prev == start )
            quickSort(pivot_prev.next, end);
        else if(pivot_prev != null && pivot_prev.next != null)
            quickSort(pivot_prev.next.next, end);
    }

    public void sort(){
        Node current = startPtr, index = null;
        Word temp;

        if(startPtr == null){
            return;
        }
        else{
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data.getWord().compareTo(index.data.getWord())>0){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void sortReverse(){
        Node current = startPtr, index = null;
        Word temp;

        if(startPtr == null){
            return;
        }
        else{
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data.getWord().compareTo(index.data.getWord())<0){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void showFrequentWords(){
        Node current = startPtr, index = null;
        Word temp;

        if(startPtr == null){
            return;
        }
        else{
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data.getOccurance() == index.data.getOccurance()){
                        if(current.data.getWord().compareTo(index.data.getWord())<0){
                            temp = current.data;
                            current.data = index.data;
                            index.data = temp;
                        }
                    }
                    else if(current.data.getOccurance() < index.data.getOccurance()){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }        
    }

}
