 

public class Tree 
{
    private int content;
    private Tree left;
    private Tree right; 
    
    public static Tree build_tree(int[] data){
        Tree t = new Tree(data[0], null, null);
        for(int i = 0; i < data.length-1; i++)
            t.add(t, data[i]); 
        return t;
    }
    
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
    
    public Tree getMax(Tree t){
        Tree top = t;
        while(top != null && top.getRight() != null){
            top = top.getRight();
        }
        return top;
    }
    
    public Tree getMin(Tree t){
        Tree top = t;
        while(top != null && top.getLeft() != null){
            top = top.getLeft();
        }
        return top;
    }
    
    public void add(Tree t, int num){
        if(t != null && search(t, num) == null){
            if(num < t.content){
            if(t.getLeft() == null){
                t.left = new Tree(num,null,null);
            }
            else {
                add(t.getLeft(), num);
            }
            }
            else{
                if(t.getRight() == null){
                    t.right = new Tree(num,null,null);
                }
                else{
                    add(t.getRight(), num);
                }
            }   
        }
    }
    
    public Tree search(Tree t, int num){
        if(t != null){
            if(t.content == num){
               return t;
            }
            else if(num < t.content){
               return search(t.getLeft(), num);
            }
            else{
               return search(t.getRight(), num);
            }
        }
        return null;
    }
    
    public void delete(Tree t, int num){
        if(t == null)
            return;
        Tree delete = search(t, num);
        if(delete == null)
            return;
            
        Tree parent = getParent(t, delete.content);
        if(delete.getLeft() == null && delete.getRight() == null){
            if(parent.getLeft() != null && delete.content < parent.content)
                parent.left = null;
            else
                parent.right = null;
            return;
        }
        Tree nS = getMin(delete.getRight()); 
        Tree nSP = getParent(t, nS.content);
        if(nS != null){
            if(nS != nSP.getRight())
                nSP.left = nS.getRight();
        }
        else{
            nS = getMax(delete.getLeft());
            nSP = getParent(t, nS.content);
            if(nS != nSP.getLeft())
                nSP.right = nS.getLeft();
        }
        
        if(delete.getLeft() != nS) {
            nS.left = delete.getLeft();
        }
        if(delete.getRight() != nS)    {
            nS.right = delete.getRight();
        }
        
        System.out.println(parent);
        if(parent.getLeft() != null && delete.content < parent.content){
            parent.left = nS;
        }
        else{
            parent.right = nS;
        }
    }
    
    public void deleteMin(Tree t){
        delete(t, getMin(t).content);
    }
    
    public void deleteMax(Tree t){
        delete(t, getMax(t).content);
    }
    
    public Tree getParent(Tree t, int num){
        if(t != null){
            if(t.getLeft() != null){
                if(t.getLeft().content == num)
                    return t;
                else if(num < t.content)
                    return getParent(t.getLeft(), num);
            }
            if(t.getRight() != null)
                if(t.getRight().content == num)
                    return t;
                else if(num > t.content)
                    return getParent(t.getRight(), num);
        }
                
        return null;
    }
}
