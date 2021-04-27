import java.sql.SQLOutput;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        dataHandle handle = new dataHandle();
        listOfTeacher list = new listOfTeacher();
        try {
            list = handle.readList("C:\\Users\\Admin\\IdeaProjects\\UIlearning\\src\\data.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (teacher T:
             list.getList()) {
            System.out.println(T.getName());
        }
    }

}
