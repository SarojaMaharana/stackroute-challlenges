public class wordSingleLinkedList {
    wordNode startPtr = null;

    public void insert(Word data){
        wordNode newNode = new wordNode(data);
        if(startPtr == null){
            startPtr = newNode;
            startPtr.next = null;
        }
        else{
            wordNode current = startPtr;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }

    }

    public void traverse(){
        wordNode current = startPtr;
        while(current!=null){
            System.out.println(current.data.getWord()+" -> " +current.data.getOccurance());
            current = current.next;
        }
    }

    public void removeDuplicates(){
        wordNode current = null, temp = null, dup = null;
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

    wordNode paritionLast(wordNode start, wordNode end){
        if(start == end || start == null || end == null){
            return start;
        }
        wordNode pivot_prev = start;
        wordNode current = start;
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

    void quickSort(wordNode start, wordNode end){
        if(start == end)
            return;
        
        wordNode pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);
        if( pivot_prev != null && pivot_prev == start )
            quickSort(pivot_prev.next, end);
        else if(pivot_prev != null && pivot_prev.next != null)
            quickSort(pivot_prev.next.next, end);
    }

    public void sort(){
        wordNode current = startPtr, index = null;
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
        wordNode current = startPtr, index = null;
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
        wordNode current = startPtr, index = null;
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

    public int noOfWords(){
        int length = 0;
        wordNode current = startPtr;
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

    public void printFrequentWords(){
        int maxOccurence = 0;
        wordNode current = startPtr;
        if(startPtr == null)
            return;
        else{
            while(current!=null)
            {
                if(maxOccurence < current.data.getOccurance())
                    maxOccurence = current.data.getOccurance();
                current = current.next;
            }
        }
        current = startPtr;

        while(current!=null)
            {
                if(maxOccurence == current.data.getOccurance())
                    System.out.println(current.data.getWord()+" -> " +current.data.getOccurance());
                current = current.next;
            }
    }

}
