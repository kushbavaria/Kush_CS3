package Binary_Tree;

public class Tree2020Runner
{
    public static void main(String[] args){
        
        Tree left = new Tree(80,new Tree(70,null,null),new Tree(85,null,null));
        Tree right = new Tree(100,new Tree(98,null,null),new Tree(120,null,null));
        
        Tree root = new Tree(90,left,right);
        
        System.out.println(root);
        System.out.println(root.getLeft());
        System.out.println(root.getRight());
        

        System.out.println("IN ORDER\n" + root.inOrder(root));
        System.out.println("PRE ORDER\n" + root.preOrder(root));
        System.out.println("POST ORDER\n" + root.postOrder(root));
        System.out.println("REV ORDER\n" + root.revOrder(root));

        System.out.println("Tree Height is\n" + root.getHeight(root));
        System.out.println("Tree Width is\n" + root.getWidth(root));
        System.out.println("Number of Leaves is\n" + root.getNumLeaves(root));
        System.out.println("Number of Nodes is\n" + root.getNumNodes(root));
        System.out.println("Number of Levels is\n" + root.levels(root));
        System.out.println("Tree as a String\n" + root.inOrder(root));

        if(root.isFull(root)){
            System.out.println(" The tree is full");
        }
        else{
            System.out.println(" the tree is not full");
        }
    }
    }

