import java.util.ArrayList;
import java.util.Locale;

public class listOfTeacher {
    private ArrayList<teacher> list;

    public listOfTeacher() {
        list = new ArrayList<teacher>();
    }

    public void setList(ArrayList<teacher> list) {
        this.list = list;
    }

    public  boolean addTeacher(teacher T){
        if(!list.contains(T)){
            list.add(T);
            return true;
        }
        return  false;
    }

    public ArrayList<teacher> getList() {
        return list;
    }

    public boolean removeTeacher(int index){
        if(index > 0 && index < list.size()){
            list.remove(index);
            return true;
        }
        return false;
    }
    public ArrayList<teacher> search(String str){
        ArrayList<teacher> result = new ArrayList<teacher>();
        for(teacher T : list){
            if(T.getName().contains(str))
                result.add(T);
        }
        return result;
    }
    public  ArrayList<teacher> search(double Salary){
        ArrayList<teacher> result = new ArrayList<teacher>();
        for(teacher T : list){
            if(T.salary() > Salary)
                result.add(T);
        }
    return result;
    }
}
