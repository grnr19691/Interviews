package Trees.BinarySearchTrees;

import java.util.*;

/**
 * Created by grnr1 on 5/28/2016.
 */
public class TreeTraversal
{
    public void recursivePreOrderTraversal(Node root)
    {
        if(root != null) 
        {
            System.out.print(root.val+" ");
            recursivePreOrderTraversal(root.left);
            recursivePreOrderTraversal(root.right);
        }
    }
    public void recursiveInOrderTraversal(Node root)
    {
        if(root != null)
        {
            recursiveInOrderTraversal(root.left);
            System.out.print(root.val+" ");
            recursiveInOrderTraversal(root.right);
        }
    }
    public void recursivePostOrderTraversal(Node root)
    {
        if(root!=null)
        {
            recursivePostOrderTraversal(root.left);
            recursivePostOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }
    public void iterativePreOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current;
        stack.push(root);

        while (! stack.isEmpty() )
        {
            current = stack.pop();
            System.out.print(current.val + " ");

            if (current.right != null)
            {
                stack.push(current.right);
            }

            if (current.left != null)
            {
                stack.push(current.left);
            }
        }
    }
    public void iterativeInOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current=root;
        {
            while ( !stack.isEmpty() || current != null)
            {
                if(current != null)
                {
                    stack.push(current);
                    current = current.left;
                }
                else
                {
                    current = stack.pop();
                    System.out.print(current.val+" ");
                    current = current.right;
                }
            }
        }

    }
    public void iterativePostOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node temp;
        while ( !stack.isEmpty() || current != null)
        {
            if(current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                temp = stack.peek().right;
                if(temp == null)
                {
                    // from current we only go to left
                    // temp is last printed value
                    temp = stack.pop();
                    System.out.print(temp.val+" ");
                    // condition inside while loop means if the last printed value is right element of stack's top element enter loop
                    while ( !stack.isEmpty() && temp == stack.peek().right)
                    {
                        temp = stack.pop();
                        System.out.print(temp.val+" ");
                    }
                }
                else
                {
                    current = temp;
                }
            }
        }
    }
    public void iterativeLevelOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Node current;
        queue.add(root);

        while (! queue.isEmpty() )
        {
            current = queue.remove();
            System.out.print(current.val+" ");

            if(current.left != null)
            {
                queue.add(current.left);
            }
            if(current.right != null)
            {
                queue.add(current.right);
            }

        }
    }
}
