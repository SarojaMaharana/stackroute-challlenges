public class FrequencyTree {
    WordNode root;
    
    public WordNode insert(WordNode node, Word data){
        if(node==null){
            node = new WordNode(data);
            if(root == null){
                root = node;
            }
            return node;
        }
        if(data.getOccurance() < node.data.getOccurance())
            node.left = insert(node.left,data);
        else if(data.getOccurance() < node.data.getOccurance())
            node.right = insert(node.right,data);
        
        return node;
    }

    public void traversal(WordNode node){
        if(node!=null){
            traversal(node.right);
            System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            traversal(node.left);
        }
    }

    public boolean searchTree(WordNode node, String key){
        boolean check = false;
        if(node == null)
            return false;
        if(node.data.wordCompare(key) == true)
            return true;
        else{
            if(node.data.getWord().compareTo(key) > 0){
                check = searchTree(node.left, key);
                return check;
            }
            else{
                check = searchTree(node.right, key);
            }
            return check;
        }
    }
}
