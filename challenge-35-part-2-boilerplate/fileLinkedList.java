public class fileLinkedList {
    fileNode startPtr = null;

    public void insert(TextFileAnalyzer data){
        fileNode newNode = new fileNode(data);
        if(startPtr == null){
            startPtr = newNode;
            startPtr.next = null;
        }
        else{
            fileNode current = startPtr;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }

    }

    public void traverse(){
        fileNode current = startPtr;
        while(current!=null){
            System.out.println("TimeStamp of the file " +current.data.getFilename()+ " is: " +current.data.getTimeStamp());
            System.out.println("Number of words present in " +current.data.getFilename()+ " are: " +current.data.getNoOfWords());
            System.out.println("Number of characters present in " +current.data.getFilename()+ " are: " +current.data.getNoOfCharacters());
            System.out.println("Most frequent word with n letters where 1 <= n <= 15 in " +current.data.getFilename()+ " are: ");
            current.data.wordList.removeDuplicates();
            current.data.wordList.printFrequentWords();
            System.out.println("Number of words whose length is >15 letters in " +current.data.getFilename()+ " are: " +current.data.getNoOfLongwords());
            current.data.wordList.sort();
            current.data.wordList.traverse();
            current = current.next;
        }
    }
}
