import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class dataHandle {
    public listOfTeacher readList(String path) throws  Exception{
        listOfTeacher result  = new listOfTeacher();
        File f = new File(path);
        if (f.exists()){
            Scanner in =  new Scanner(f);
            while(in.hasNextLine()){
                String line = in.nextLine();
                String[] data = line.split(",");
                if(data[0].equals("1")){//nếu là giáo viên  biên chế
                    longTermTeacher temp = new longTermTeacher(data[1],data[2],Integer.parseInt(data[3]),data[4],Double.parseDouble(data[5]) );
                    result.addTeacher(temp);
                }
                else{
                data = line.split(",");
                shortTermTeacher temp = new shortTermTeacher("","",0,"",1 );
                temp.setName(data[1]);
                temp.setPhoneNumber(data[2]);
                temp.setStartYear(Integer.parseInt(data[3]));
                temp.setSpecialUnit(data[4]);
                temp.setTeachingTime(Double.parseDouble(data[5]));
                result.addTeacher(temp);
               }
            }
            in.close();
        }
        else f.createNewFile();
        return result;
    }
    public void writeList(String path, listOfTeacher list) throws Exception{
    try(PrintWriter out = new PrintWriter(new FileOutputStream(path),true)){
        String temp;
        for(teacher T : list.getList()){
            if(T instanceof longTermTeacher)
            temp ="1," + T.getName() + "," + T.getPhoneNumber() + "," + T.getStartYear() + "," + T.getSpecialUnit() + "," +((longTermTeacher) T).getBasicPayment();
            else
            temp ="0," + T.getName() + "," + T.getPhoneNumber() + "," + T.getStartYear() + "," + T.getSpecialUnit() + "," + ((shortTermTeacher)T).getTeachingTime();
            out.println(temp);
        }
    }
    }


}
