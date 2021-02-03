public class SinglyLinkedListImpl {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertBegininning(3);
        sl.insertBegininning(13);
        sl.insertBegininning(31);
        sl.insertBegininning(33);
        sl.insertBegininning(23);

        sl.insertEnd(54);
        sl.insertEnd(55);
        sl.insertEnd(56);
        sl.insertEnd(44);
        sl.insertEnd(66);
        
        sl.traverse();
        System.out.println("\nThe size of the list is : "+sl.getSize());
        System.out.println("The index of element: "+sl.getIndex(66));
        
        sl.insertMid(55, 2);
        System.out.println();
        sl.delete(13);
        sl.traverse();
    }
}
