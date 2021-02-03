public class TextAnalyzerBST {
    WordNode root;
    int maxOccurance = 0;

    public WordNode insert(WordNode node, Word data){
        if(node==null){
            node = new WordNode(data);
            if(root == null){
                root = node;
            }
            return node;
        }
        if(data.getWord().compareTo(node.data.getWord()) < 0)
            node.left = insert(node.left,data);
        else if(data.getWord().compareTo(node.data.getWord()) > 0)
            node.right = insert(node.right,data);
        
        return node;
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

    public void traversal(WordNode node){
        if(node!=null)
        {
            traversal(node.left);
            System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            if(node.data.getOccurance()>maxOccurance)
                maxOccurance = node.data.getOccurance();
            traversal(node.right);
        }
    }
    
    public void reverseTraversal(WordNode node){
        if(node!=null){
            reverseTraversal(node.right);
            System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            reverseTraversal(node.left);
        }
    }

    public void toFlat(WordNode node){
        if(node == null || node.left == null || node.right == null)
            return;
        if(node.left != null){
            toFlat(node.left);
            WordNode tempRight = node.left;
            node.right = node.left;
            node.left = null;
            WordNode t = node.right;
            while(t.right != null){
                t = t.right;
            }
            t.right = tempRight;
        }
        toFlat(node.right);
    }

    public void flatSort(){
        WordNode current;
        boolean check;
        do{
            check = false;
            current = root;
            while(current.right!=null){
                if(current.data.getOccurance() < current.right.data.getOccurance()){
                    Word temp = current.right.data;
                    current.right.data = current.data;
                    current.data = temp;
                    check = true;
                }
                current = current.right;
            }
        }while(check == true);
    }

    public void showFrequentWords(WordNode node){
        if(node!=null)
        {
            showFrequentWords(node.left);
            if(node.data.getOccurance() == maxOccurance)
                System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            showFrequentWords(node.right);
        }
    }

    public int getMaxOccurance() {
        return maxOccurance;
    }

    public void setMaxOccurance(int maxOccurance) {
        this.maxOccurance = maxOccurance;
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

    
}
