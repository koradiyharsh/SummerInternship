import java.util.LinkedList;
import java.util.Queue;

class node2
{
    char data;
    node2 leftchild;
    node2 rightchild;

    node2(char ch)
    {
        data = ch;
        this.leftchild = null;
        this.rightchild = null;
    }

}
public class QueueTraversal
{
    node2 root;

    public void BFStraveral(node2 root)
    {

        Queue<node2> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            node2 temp = queue.peek();
            queue.poll();
            System.out.print(temp.data+" ");
            if(temp.leftchild!=null)
                queue.add(temp.leftchild);
            if(temp.rightchild!=null)
                queue.add(temp.rightchild);
        }
    }
    public static void main(String[] args)
    {
     QueueTraversal traversal = new QueueTraversal();
     traversal.root = new node2('A');
     traversal.root.leftchild  = new node2('B');
     traversal.root.rightchild = new node2('C');
     traversal.root.leftchild.leftchild = new node2('D');
     traversal.root.leftchild.rightchild = new node2('E');
     traversal.root.rightchild.leftchild = new node2('F');
     traversal.root.rightchild.rightchild = new node2('G');

     traversal.BFStraveral(traversal.root);

    }
}
