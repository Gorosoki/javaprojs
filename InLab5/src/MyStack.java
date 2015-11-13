
import java.util.ArrayList;


/**
 *
 * @author Gavin Goroski
 * @date Feb 12, 2013
 */
public class MyStack
{

    ArrayList<Character> list = new ArrayList<>();
    Character top;
    int currentTop;
    boolean first;
    public MyStack()
    {
        top = ' ';
        first = false;
    }

    // stack operations:
    public void push(char node)
    {
        list.add(node);
    }

    public Character pop()
    {
        if (list.size() > 0)
        {
            top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
        else
        {
            return null;
        }

    }

    public Character peek()
    {
        if (list.size() > 0)
        {
            top = list.get(list.size() - 1);
            return top;
        }
        else
        {
            return null;
        }
    }

}