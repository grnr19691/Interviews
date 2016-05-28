package Trees.BinarySearchTrees;

import java.util.ArrayList;

/**
 * Created by grnr1 on 3/28/2016.
 */
public class BinarySearchTree
{
    Node root;

    public boolean isPresent(int val)
    {
        Node cur = root;
        while (cur != null)
        {
            if (cur.val == val)
            {
                return true;
            }
            else if (cur.val > val) {
                cur = cur.left;
            }
            else
            {
                cur = cur.right;
            }
        }
        return false;
    }

    public boolean delete(int val) {
        Node parent = root;
        Node cur = root;
        boolean isLeft = false;
        while (cur.val != val)
        {
            parent = cur;
            if (cur.val > val)
            {
                cur = cur.left;
                isLeft = true;
            }
            else
            {
                cur = cur.right;
                isLeft = false;
            }
            if (cur == null)
            {
                return false;
            }
        }
        if (cur.left == null && cur.right == null)
        {
            if (cur == root)
            {
                root = null;
            }
            if (isLeft)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }
        else if (cur.left != null && cur.right != null)
        {
            Node successor = getInorderSuccessor(cur);
            if (cur == root)
            {
                root = successor;
            }
            else if (isLeft)
            {
                parent.left = successor;
            }
            else
            {
                parent.right = successor;
            }
            successor.left = cur.left;
        }
        else if (cur.left == null)
        {
            if (cur == root)
            {
                root = cur.right;
            }
            else if (isLeft)
            {
                parent.left = cur.right;
            }
            else
            {
                parent.right = cur.right;
            }
        }
        else if (cur.right == null)
        {
            if (cur == root)
            {
                root = cur.left;
            }
            else if (isLeft)
            {
                parent.left = cur.left;
            }
            else
            {
                parent.right = cur.left;
            }
        }
        return true;
    }

    public Node getInorderSuccessor(Node deleteNode)
    {
        Node parent = null;
        Node successor = null;
        Node cur = deleteNode.right;
        while (cur != null)
        {
            parent = successor;
            successor = cur;
            cur = cur.left;
        }
        if (successor != deleteNode.right)
        {
            parent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public void insert(int val)
    {
        Node node = new Node(val);
        if (root == null)
        {
            root = node;
            return;
        }
        Node cur = root;
        Node parent;
        while (true)
        {
            parent = cur;
            if (val < cur.val)
            {
                cur = cur.left;
                if (cur == null)
                {
                    parent.left = node;
                    return;
                }
            }
            else
            {
                cur = cur.right;
                if (cur == null)
                {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public int height(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public void draw(Node root)
    {
        ArrayList<Node> q = new ArrayList();
        ArrayList<Integer> p = new ArrayList();
        ArrayList<Character> c = new ArrayList();
        int numberOfElements;
        int h = height(root);
        q.add(root);
        p.add((int) (Math.pow(2, h + 1) - 2));
        for (int i = 0; p.get(0) != i; i++)
        {
            System.out.print(" ");
        }
        System.out.print(q.get(0).val + "\n");
        if (q.get(0).left != null) {
            q.add(q.get(0).left);
            p.add(p.get(0) - 1);
            c.add('/');
        }
        if (q.get(0).right != null)
        {
            q.add(q.get(0).right);
            p.add(p.get(0) + 1);
            c.add('\\');
        }
        q.remove(0);
        p.remove((0));
        for (int i = 0; i < h; i++)
        {
            numberOfElements = q.size();
            for (int j = 0; j < (int) Math.pow(2, h - i - 1) - 1; j++)
            {
                for (int k = 0, l = 0; l < numberOfElements; k++)
                {
                    if (k == p.get(l)) {
                        System.out.print(c.get(l));
                        if (c.get(l) == '/') {
                            int temp = p.get(l);
                            p.set(l, temp - 1);
                        } else if (c.get(l) == '\\')
                        {
                            int temp = p.get(l);
                            p.set(l, temp + 1);
                        }
                        l++;
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
            for (int k = 0, l = 0; l < numberOfElements; k++)
            {
                if (k == p.get(l))
                {
                    System.out.print(q.get(l).val);
                    if (c.get(l) == '/')
                    {
                        int temp = p.get(l);
                        p.set(l, temp - 1);
                    }
                    else if (c.get(l) == '\\')
                    {
                        int temp = p.get(l);
                        p.set(l, temp + 1);
                    }
                    l++;
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            for (int j = 0; j < numberOfElements; j++)
            {
                if (c.get(0) == '/')
                {
                    int temp = p.get(0);
                    p.set(0, temp + 1);
                }
                else
                {
                    int temp = p.get(0);
                    p.set(0, temp - 1);
                }
                if (q.get(0).left != null)
                {
                    q.add(q.get(0).left);
                    p.add(p.get(0) - 1);
                    c.add('/');
                }
                if (q.get(0).right != null)
                {
                    q.add(q.get(0).right);
                    p.add(p.get(0) + 1);
                    c.add('\\');
                }
                q.remove(0);
                c.remove(0);
                p.remove(0);
            }
        }

    }
}
