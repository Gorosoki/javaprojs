
import java.util.*;

/**
 *
 * @author Gavin Goroski
 * @date 2/5/2013
 */
public class MergeLists
{

    public static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2)
    {
        
        
        ArrayList<Integer> merged = new ArrayList<>(30);
//        
//        
//        for(int i = 0; i < l2.size(); i++)
//        {
//            l1.add(l1.size() + i, l2.get(i));
//        }
//        
//       for(int j= 0; j < l1.size(); j++)
//       {
//           if element i of l1 > l2
//                   l2 = temp
//                           set l1 to l2
//                                   then l1 to the temp
//       }
                       
                    
        
//        ArrayList<Integer> merged1 = new ArrayList<>(30);
//        
        
        merged.addAll(l1);
        merged.addAll(l2);
//        merged1.addAll(l1);
//        for (int i = 0; i < 9; i++)
//        {
//            if (l2.get(i) < merged1.get(i))
//            {
//                if (i == 0)
//                {
//                    merged1.add((0), l2.get(i));
//                }
//                else
//                {
//                    merged1.add((i - 1), l2.get(i));
//                }
//            }
//            else if (l2.get(i) < merged1.get(i + 1))
//            {
//                merged1.add(i, l2.get(i));
//            }
//        }
        Collections.sort(merged);
//        for (int i = 0; i < 10; i++)
//        {
//            if (l1.get(i) < l2.get(i))
//            {
//                merged1.add(l1.get(i));
//            }
//            else if (l2.get(i) < l1.get(i))
//            {
//                merged1.add(l2.get(i));
//            }
//        }
//
//
        return merged;
//
    }
//
    public static ArrayList<Integer> makeRandomIncreasingList(int length)
    {
        ArrayList<Integer> templist = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < length; i++)
        {
            x = (int) (Math.random() * 11) + x;
            templist.add(x);
        }
        return templist;
    }

    public static void doMergeTest()
    {
        ArrayList<Integer> list1 = makeRandomIncreasingList(10);
        ArrayList<Integer> list2 = makeRandomIncreasingList(20);
        ArrayList<Integer> mergedList = merge(list1, list2);
        System.out.println("List 1:" + list1);
        System.out.println("List 2:" + list2);
        System.out.println("Merged list:" + mergedList);
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Performing merge test #" + (i + 1) + ":");
            doMergeTest();
        }
    }

}
