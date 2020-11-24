
public class Tree
{
    private int content;
    private Tree left;
    private Tree right;
    
    public Tree(int c, Tree le, Tree ri){
        content = c;
        left = le;
        right = ri;
    }
    
    public Tree getLeft(){
        return left;
    }
    
    public Tree getRight(){
        return right;
    }
    
    public int getContent(){
        return content;
    }
    
    public  int getNumLeaves(Tree t){
        if(t == null) {
            return 0;
        }

        if(t.getLeft() == null && t.getRight() == null) {
            return 1;
        }
        return getNumLeaves(t.getLeft()) + getNumLeaves(t.getRight());
    }
    public int getHeight(Tree t){
        if(t == null) {
            return 0;
        }
        return levels(t) - 1;
    }
    public  int getNumNodes(Tree t){
        if(t == null) {
            return 0;
        }
        return getNumNodes(t.getLeft()) + getNumNodes(t.getRight()) + 1;
    }

    public int getWidth(Tree t){
        if(t == null) {
            return 0;
        }
        return Math.max(levels(t.getLeft()) + levels(t.getRight()) + 1, Math.max(getWidth(t.getLeft()), getWidth(t.getRight())));
    }
    public boolean isFull(Tree t){
        if(t == null) {
            return true;
        }
        if(t.getLeft() == null && t.getRight() == null) {
            return true;
        }
        if(t.getLeft() != null && t.getRight() != null){
            return isFull(t.getLeft()) && isFull(t.getRight());
        }
        return false;
    }

    public  String preOrder(Tree t){
        if(t == null) {
            return "";
        }
        return " " + t.getContent() + " " + preOrder(t.getLeft()) + preOrder(t.getRight());
    }

    public  String postOrder(Tree t){
        if(t == null) {
            return "";
        }
        return postOrder(t.getLeft()) + postOrder(t.getRight()) + " " + t.getContent() + " ";
    }
    public  int levels(Tree t){
        if(t == null)
            return 0;
        return 1 + Math.max(levels(t.getRight()) , levels(t.getLeft()) );
    }
    
    public String inOrder(Tree t){
        if(t == null)
            return "";
        return inOrder(t.getLeft()) + " " + t.getContent() + " " + inOrder(t.getRight());
    }
    public  String revOrder(Tree t){
        if(t == null) {
            return "";
        }
        return revOrder(t.getRight()) + " " + t.getContent() + " " + revOrder(t.getLeft());
    }
    public String toString(){
        return content + "" ;
    }
}
