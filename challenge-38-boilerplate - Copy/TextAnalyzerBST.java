public class TextAnalyzerBST {
    WordNode root;

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

    public WordNode search(Word word)
    {
        root = search(root,word.getWord());
        if(root!=null)
            return root;
        else 
            return root;
    }
    private WordNode search(WordNode node, String word)
    {
        if(node == null || node.data.getWord().compareTo(word) == 0)
        {
            return node;
        }
        if(node.data.getWord().compareTo(word) > 0)
            return search(node.right,word);
        else 
            return search(node.left,word);
    }

    public void traversal(WordNode node){
        if(node!=null)
        {
            traversal(node.left);
            System.out.println(node.data.getWord()+ "->" +node.data.getOccurance());
            traversal(node.right);
        }
    }
}
