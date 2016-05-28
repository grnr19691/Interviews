package Trees.BinarySearchTrees;

/**
 * Created by grnr1 on 5/28/2016.
 */
public class Test
{
    public static void main(String arg[])
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(22);
        bst.insert(24);
        bst.insert(14);
        bst.insert(65);
        bst.insert(2);
        bst.insert(68);
        bst.insert(125);
        bst.insert(58);
        bst.insert(59);
        bst.draw(bst.root);
        System.out.println(bst.isPresent(2));
        bst.delete(2);
        bst.draw(bst.root);
        System.out.println("Height of BinaryTree is " + bst.height(bst.root));
        bst.draw(bst.root);
    }
}
