package Stack;

import java.util.Stack;
import static java.lang.System.*;
import java.util.Scanner;

public class StackTester
{
    private Stack<String> stack;

    public StackTester()
    {
        setStack("");
    }

    public StackTester(String line)
    {   
        setStack(line);
    }
    
    public void setStack(String line)
    {
        stack = new Stack<String>();
        Scanner let = new Scanner(line);
        while(let.hasNext())
            stack.push(let.next());
    }

    public void popEmAll()
    {
        while(!stack.isEmpty())
            out.print(stack.pop() + " ");
    }

    public String toString(){
        return stack.toString();
    }
}