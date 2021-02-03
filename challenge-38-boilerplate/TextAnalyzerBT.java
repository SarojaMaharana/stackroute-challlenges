public class TextAnalyzerBT {
    WordNode root;

    public WordNode left(WordNode node){
        if(node.left != null)
            return node.left;
        else
            return null;
    }

    public WordNode right(WordNode node){
        if(node.right != null)
            return node.right;
        else
            return null;
    }

    public boolean hasLeft(WordNode node){
        if(node.left != null)
            return true;
        else
            return false;
    }

    public boolean hasRight(WordNode node){
        if(node.right != null)
            return true;
        else
            return false;
    }

    public boolean isInternal(WordNode node){
        if(node.left != null || node.right != null)
            return true;
        else
            return false;
    }

    public boolean isExternal(WordNode node){
        if(node.left == null && node.right == null)
            return true;
        else
            return false;
    }

    public boolean isRoot(WordNode node){
        if(node == root)
            return true;
        else
            return false;
    }

    public int size(){
        return size(root);
    }

    private int size(WordNode node){
        if(node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    public boolean isEmpty(){
        if(root == null)
            return true;
        else
            return false;
    }

    public WordNode insert(WordNode node, Word data){
        if(node == null){
            node = new WordNode(data);
            if(root == null)
                addRoot(node);
            return node;
        }
        if(node.left == null)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    private void addRoot(WordNode node){
        root = node;
    }

    public void traversal(WordNode node){
        if(node!=null){
            traversal(node.left);
            System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            traversal(node.right);
        }
    }

    public WordNode searchNode(WordNode node, String value){
        // boolean flag = false;
        WordNode temp = null;
        if(node == null)
            return null;
        
        // System.out.println(node.data.getWord());
        if(node.data.getWord().equals(value)){
            // flag = true;
            return node;
        }
        if(node != null){
            temp = searchNode(node.left, value);
            if(temp!=null)
                return temp;
        }
        // if(node.left != null)
        temp = searchNode(node.right, value);
        
        return temp;
    }
}
