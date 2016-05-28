package Search;

/**
 * Created by grnr1 on 5/27/2016.
 */
import java.util.ArrayList;

public class BinarySearch
{
    public static void print(ArrayList<Integer> a)
    {
        System.out.println("Elements in ArrayList are:");
        for(Integer i : a)
        {
            System.out.print(i+" ");
        }
        System.out.print("\n");
    }
    public static int binarySearch(ArrayList<Integer> a,int s,int e,int target)
    {
        System.out.println("Searching for : "+target+" ...");
        int mid=0;
        int m;
        while(s<e)
        {
            m=(s+e)/2+1;
            if(m==e)
            {
                System.out.println("Sorry the requested target is not found. But sending the closest number smaller than target.");
                return a.get(s);
            }
            mid=a.get(m);
            //System.out.println(s+" < "+ e+" : Mid = "+mid + " : mid index = " + m);
            if(target==mid)
            {
                System.out.println("The number is found and sent.");
                return mid;
            }
            else if(target<mid)
            {
                e=m;
            }
            else
            {
                s=m;
            }
        }
        return mid;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> a =  new ArrayList<Integer>();
        a.add(1);
        a.add(7);
        a.add(13);
        a.add(23);
        a.add(38);
        a.add(47);
        a.add(68);
        a.add(98);
        a.add(103);
        System.out.println("Binary Search");
        print(a);
        System.out.print(binarySearch(a,0,a.size()-1,15));
    }

}
