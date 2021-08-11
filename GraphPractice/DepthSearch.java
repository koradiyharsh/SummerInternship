import java.util.Stack;

class node
{
    char data;
    node leftChild;
    node rightChild;

    node(char c)
    {
        data = c;
        this.leftChild = null;
        this.rightChild =null;
    }
}
public class DepthSearch
{
    node searchNode(node root , char goal)
    {
        Stack<node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty())
        {
            node a = stack.peek();
            stack.pop();
            if(a.data == goal)
            {
                return a;
            }
            else
            {
                if(a.leftChild!=null) {
                    stack.push(a.leftChild);
                }
                if (a.rightChild != null) {
                    stack.push(a.rightChild);
                }

            }
        }
        return  null;
    }
    node root;
    public static void main(String[] args)
    {
     DepthSearch search = new DepthSearch();
        search.root = new node('A');
        search.root.leftChild = new node('B');
        search.root.rightChild = new node('C');
        search.root.leftChild.leftChild = new node('D');
        search.root.leftChild.rightChild = new node('E');
        search.root.rightChild.leftChild = new node('F');

       node result =  search.searchNode(search.root , 'T');
       if(result!=null)
       {
           System.out.println("Success ");
       }
       else
       {
           System.out.println("Not Success ");
       }
    }
}
