import java.util.ArrayList;

public class Department {
    double unyt=3600;
    double suny=6700;
    ArrayList<Student>students=new ArrayList<>();
    String subject;

    public Department(){}

    public Department(String sub) {

        this.subject = sub;
    }


    public String getDep(){
        return subject;
    }

    public double getUnyt(){
        return unyt;
    }
    public double getSuny(){
        return suny;
    }
    public double setSuny(double p){
        suny=p;
        return p;
    }

    public double setUnyt(double p){
        unyt=p;
        return p;
    }



    public ArrayList<Student> getStudent(){
        return students;
    }

}
