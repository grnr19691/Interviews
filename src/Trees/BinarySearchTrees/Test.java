package Trees.BinarySearchTrees;

import java.util.Scanner;

/**
 * Created by grnr1 on 5/28/2016.
 */
public class Test
{
    public static void main(String arg[])
    {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner in = new Scanner(System.in);
        String selection="";
        TreeTraversal treeTraversal = new TreeTraversal();
        while(! (selection.equals("11") || selection.equals("exit") || selection.equals("stop") || selection.equals("quit") || selection.equals("exit()") || selection.equals("stop()") || selection.equals("quit()")))
        {
            System.out.println("__________________________________________________________________");
            System.out.println("| Select among the options:                                      |");
            System.out.println("|----------------------------------------------------------------|");
            System.out.println("| 0. Insert a sample tree.                                       |");
            System.out.println("| 1. Insert a value into tree.                                   |");
            System.out.println("| 2. Delete a node from tree.                                    |");
            System.out.println("| 3. Check if a val is present in tree.                          |");
            System.out.println("| 4. Draw tree.                                                  |");
            System.out.println("| 5. Print recursive pre-order traversal of tree.                |");
            System.out.println("| 6. Print recursive in-order traversal of tree.                 |");
            System.out.println("| 7. Print recursive post-order traversal of tree.               |");
            System.out.println("| 8. Print iterative pre-order traversal of tree.                |");
            System.out.println("| 9. Print iterative in-order traversal of tree.                 |");
            System.out.println("| 10. Print iterative post-order traversal of tree.              |");
            System.out.println("| 11. Print iterative level-order traversal of tree.             |");
            System.out.println("| 12. Exit this program                                          |");
            System.out.println("|________________________________________________________________|\n");
            System.out.print("Enter input : ");


            selection = in.nextLine();

            switch (selection)
            {
                case "0":
                {
                    System.out.println("Inserting sample node value into tree ...");
                    bst.insert(100);
                    bst.insert(242);
                    bst.insert(14);
                    bst.insert(105);
                    bst.insert(258);
                    bst.insert(68);
                    bst.insert(13);
                    bst.insert(46);
                    bst.insert(590);
                    bst.insert(12);
                    bst.insert(12);
                    System.out.println("Completed inserting.");
                    break;
                }
                case "1":
                {
                    System.out.print("Enter value to be inserted into tree : ");
                    String s = in.nextLine();
                    try
                    {
                        int val = Integer.parseInt(s);
                        bst.insert(val);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Not a number or out of bounds. Try again.");
                        continue;
                    }
                    break;
                }
                case "2":
                {
                    System.out.print("Enter value to be delete a node with that value from tree : ");
                    String s = in.nextLine();
                    try
                    {
                        int val = Integer.parseInt(s);
                        if(bst.delete(val))
                        {
                            System.out.println("The node with value " + val + " is deleted from tree");
                        }
                        else
                        {
                            System.out.println("The value " +val + " is NOT present in tree. So could not delete.");
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Not a number or out of bounds. Try again.");
                        continue;
                    }
                    break;
                }
                case "3":
                {
                    System.out.print("Enter value to check if that number is present in the tree : ");
                    String s = in.nextLine();
                    try
                    {
                        int val = Integer.parseInt(s);
                        if(bst.isPresent(val))
                        {
                            System.out.println("The value is present in tree");
                        }
                        else
                        {
                            System.out.println("The value is NOT present in tree");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println("Not a number or out of bounds. Try again.");
                        continue;
                    }
                    break;
                }
                case "4":
                {
                    System.out.println("Drawing tree structure:");
                    bst.draw(bst.root);
                    break;
                }
                case "5":
                {
                    System.out.println("Printing recursive pre-order traversal:");
                    treeTraversal.recursivePreOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "6":
                {
                    System.out.println("Printing recursive in-order traversal:");
                    treeTraversal.recursiveInOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "7":
                {
                    System.out.println("Printing recursive post-order traversal:");
                    treeTraversal.recursivePostOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "8":
                {
                    System.out.println("Printing iterative pre-order traversal:");
                    treeTraversal.iterativePreOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "9":
                {
                    System.out.println("Printing iterative in-order traversal:");
                    treeTraversal.iterativeInOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "10":
                {
                    System.out.println("Printing iterative post-order traversal:");
                    treeTraversal.iterativePostOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "11":
                {
                    System.out.println("Printing iterative level-order traversal:");
                    treeTraversal.iterativeLevelOrderTraversal(bst.root);
                    System.out.print("\n");
                    break;
                }
                case "12":
                {
                    System.out.println("Exiting program. Bye ...");
                    return;
                }
                default:
                {
                    System.out.println("Invalid input. Please enter correct input");
                }

            }


        }


    }
}
