import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;

public class college {
    public static void main(String[] args) throws Exception{
        college daiict  =  new college();

    }
    public LinkedList<student> fillData(String fileName) throws Exception{
        FileReader fr=new FileReader(fileName);
        BufferedReader br=new BufferedReader(fr);

        LinkedList<student> studentList = new LinkedList<student>();

        String line = br.readLine();
        while(!line.equals("-1")){
            String[] str = line.trim().split("\\t+");
            if(str[0].equals("")){
                break;
            }
            int index = Integer.parseInt(str[0]);
            long id = Long.parseLong(str[1]);
            String name = str[3];
            Double cpi = Double.parseDouble(str[2]);

            studentList.add(new student(index,id,name,cpi));

            line = br.readLine();
        }



        br.close();
        fr.close();

        return studentList;
    }
    public void printStudentData(LinkedList<student> studentList){
        Iterator<student> itr=studentList.iterator();
        while(itr.hasNext()){
            student student = itr.next();
            System.out.println(student.getIndex()+" "+student.getId() +" "+student.getCpi()+" "+student.getName());
        }
    }
    public RedBlackTree2<Integer> getTreeBasedOnIndex(LinkedList<student> studentList){
        RedBlackTree2<Integer> indexTree = new RedBlackTree2<Integer>();
        for(student s : studentList){
            Integer index = s.getIndex();
            indexTree.insert(new Pair<Integer>(s,index));
        }
        return indexTree;
    }

    public RedBlackTree2<Long> getTreeBasedOnStudentId(LinkedList<student> studentList){
        RedBlackTree2<Long> idTree = new RedBlackTree2<Long>();
        for(student s : studentList){
            Long id = s.getId();
            idTree.insert(new Pair<Long>(s,id));
        }
        return idTree;
    }
    public RedBlackTree2<String> getTreeBasedOnName(LinkedList<student> studentList){
        RedBlackTree2<String> nameTree = new RedBlackTree2<String>();
        for(student s : studentList){
            String name = s.getName();
            nameTree.insert(new Pair<String>(s,name));
        }
        return nameTree;
    }

}
