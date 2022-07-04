import java.util.ArrayList;

public class School {
    ArrayList<Department>departments=new ArrayList<>();
    double fee=100;

    public void calculate_fee(String type){
        Department department=new Department();
        if (type.equals(department.unyt)){
            double pay=department.unyt+fee;
            System.out.println("You have the Albanian program , so you pay:  "+ pay);
        }
        else if (type.equals(department.suny)){
            double pay2=department.suny+fee;
            System.out.println("You have the American program so you need to pay: "+ pay2);
        }
    }

    public ArrayList<Department> getDepartment(){
        return departments;
    }

    public double getFee(){
        return fee;
    }




}
