public class BinarySearchTree {
    Node root;
    public Node insert(Node node,Student data)
    {
        if(node==null)
        {
            node = new Node(data);
            if(root == null)
            {
                root = node;
            }
            return node;
        }
        if(data.getTotalMarks()<node.student.totalMarks)
            node.left = insert(node.left,data);
        else if(data.getTotalMarks()>node.student.totalMarks)
            node.right = insert(node.right,data);
        return node;
    }
    public void traversal(Node node,Direction direction)
    {
        if(direction.equals(Direction.INORDER))
        {
            if(node!=null)
            {
                traversal(node.left,Direction.INORDER);
                System.out.println(node.student);
                traversal(node.right,Direction.INORDER);
            }
        }
        if(direction.equals(Direction.PREORDER))
        {
            if(node!=null)
            {
                System.out.println(node.student);
                traversal(node.left,Direction.PREORDER);
                traversal(node.right,Direction.PREORDER);
            }
        }
        if(direction.equals(Direction.POSTORDER))
        {
            if(node!=null)
            {
                traversal(node.left,Direction.POSTORDER);
                traversal(node.right,Direction.POSTORDER);
                System.out.println(node.student);
            }
        }

    }
   
    public String search(int totalMarks)
    {
        root = search(root,totalMarks);
        if(root!=null)
            return root.student.studentName;
        else 
            return root.student.studentName;
    }
    private Node search(Node node, int totalMarks)
    {
        if(node == null || node.student.getTotalMarks() == totalMarks)
        {
            return node;
        }
        if(node.student.getTotalMarks()>totalMarks)
            return search(node.right,totalMarks);
        else 
            return search(node.left,totalMarks);
    }

    // public Node deleteItem(Node node,int totalMarks)
    // {
    //     if(node == null)
    //          return null;
    //     if(node.student.totalMarks<totalMarks)
    //         node.left = delete(node.left,totalMarks);
    //     else if(node.student.totalMarks>totalMarks)
    //         node.right = delete(node.right,totalMarks);
    //     else 
    //     {
    //         if(node.left == null) return node.right;
    //         else if(node.right == null) return node.left;
        

    //     node.student.setTotalMarks(minimum(node.right));
    //     node.right = delete(node.right, totalMarks);
    //     }
    //     return node;
    // }
    public void delete(int totalMarks)
    {
        root = delete(root,totalMarks);
    }

    public Node delete(Node node, int totalMarks) {
        if(node == null)
            return null;
        if(totalMarks<node.student.totalMarks)
            node.left = delete(node.left,totalMarks);
        else if(totalMarks>node.student.totalMarks)
            node.right = delete(node.right,totalMarks);
        else {
            //node to be deleted is leaf node, delete the link
            if(node.left == null && node.right == null)
                return null;
            //node has left or right child
            else if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else{
                //node has both right and left children
                //search for the least, by inorder successor
                int minVal = minimum(node.right);
                node.student.setTotalMarks(minVal);
                node.right = delete(node.right, minVal);
        }
        }
        return node;
    }

    private int minimum(Node node)
    {
        //Recursive approach
        // if(node.left!=null)
        //     return minimum(node.left);
        // return node.student.getTotalMarks();
        //iterative approach
        int min = node.student.totalMarks;
        while(node.left!=null)
        {
            min = node.left.student.totalMarks;
            node = node.left;
        }
        return min;
    }
}
