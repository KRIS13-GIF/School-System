import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    String id;
    String name;
    int age;
    int year;
    String program;
    String program1="suny";
    double gpa;
    String program2="unyt";
    Subject subject;

    public Student(){

    }

    public Student(String name,String id, int age, int year, String program, double gpa) {
        this.name = name;
        this.id=id;
        this.age = age;
        this.year = year;
        this.program = program;
        this.gpa=gpa;
    }




    public String getId(){
        return id;
    }

    public double getGpa(){
        return gpa;
    }


    public double setGpa(double gpa2){
        gpa=gpa2;
        return gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public String getProgram1(){
        return program1;
    }

    public String getProgram2(){
        return program2;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", year=" + year +
                ", program='" + program + '\'' +
                '}';
    }
    public Subject getSubject(){
        return subject;
    }

    public void createFile()
    {
        Scanner scanner=new Scanner(System.in);
        Student student=new Student();
        student.getInfo();

        try{
            File f1=new File("file" + student.name +" .txt" );
            if (f1.createNewFile()){
                FileWriter writer=new FileWriter("file"+student.name);
                writer.write("Name: "+ student.name+"\n"+
                        "Age: "+ student.age+"\n"+
                        "Program: "+ student.program+"\n"+
                        "GPA: "+ student.gpa);
                writer.close();

                System.out.println("\nStudent has been added");
                System.out.print("\nPress Enter to Continue...");
                scanner.nextLine();
            }
            else {
                System.out.println("\nStudent already exists :(");
                System.out.print("\nPress Enter to Continue...");
                scanner.nextLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = scanner.next();

        boolean flag = true;

        while (flag) {
            System.out.println("Enter age: ");
            age = scanner.nextInt();
            if (age < 0 || age > 80) {
                System.out.println("Enter the correct age");
                age = scanner.nextInt();
            } else {
                flag = false;
            }


            while (flag) {
                System.out.println("Enter program: ");
                program = scanner.next();
                if (!program.equals("unyt") || !program.equals("suny")) {
                    System.out.println("Enter the correct program!");
                    program = scanner.next();
                } else {
                    flag = false;
                }
            }

            while (flag) {

                System.out.println("Enter gpa");
                gpa = scanner.nextDouble();
                if (gpa < 0 || gpa > 4) {
                    System.out.println("Enter the correct GPA");
                    gpa = scanner.nextDouble();
                } else {
                    flag = false;
                }
            }
        }
    }

    public void viewStudent(String s) throws Exception
    {
        File file= new File("file" + s+".txt");
        Scanner scanner=new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }


    public void removeStudent(String id){
        File file=new File("file"+id+".txt");
        if(file.exists())
        {
           if (file.delete()){
               System.out.println("File deleted");
           }
           else {
               System.out.println("Failed to be deleted");
           }
        }


    }

    public void updateStudent(String s,String o,String n) throws IOException
    {
        File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file);
        String fileContext="";
        while (sc.hasNextLine())
        {
            fileContext =fileContext+"\n"+sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file"+s+".txt");
        fileContext = fileContext.replaceAll(o,n);
        myWriter.write(fileContext);
        myWriter.close();

    }

}


