import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Department department = new Department();
        ArrayList<Student> students = department.getStudent();

        School school1 = new School();
        ArrayList<Department> departments = school1.getDepartment();


        while (true) {
            menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name: ");
                    String name = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getName().equals(name)) {
                            System.out.println("Student already exists !");
                            break;
                        }
                    }
                    System.out.println("Enter id: ");
                    String id = sc.next();
                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter year of studies: ");
                    int year = sc.nextInt();
                    System.out.println("Enter program: ");
                    String program = sc.next();
                    if (!program.equals("suny") && !program.equals("unyt")) {
                        System.out.println("Please enter a valid program : suny/unyt");
                        break;
                    }
                    System.out.println("Enter the gpa: ");
                    double gpa = sc.nextDouble();
                    if (gpa > 4 && gpa < 0) {
                        System.out.println("Enter a valid gpa");
                        break;
                    }

                    Student student = new Student(name, id, age, year, program, gpa);
                    students.add(student);

                    // here is for the file of the student

                    try {
                        File f1 = new File("file" + id + ".txt");
                        if (f1.createNewFile()) {
                            FileWriter writer = new FileWriter("file" + id + ".txt");
                            writer.write("Name: " + name + "\n" +
                                    "Age: " + age + "\n" +
                                    "ID: " + id + "\n" +
                                    "Program: " + program + "\n" +
                                    "GPA: " + gpa);
                            writer.close();

                            System.out.println("\nStudent's file created");

                        } else {
                            System.out.println("\nStudent already exists");

                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Student added into arraylist");
                    break;


                case 2:
                    Student stud = new Student();
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).toString());
                    }

                    System.out.println("Enter the student's id if you want to view the file: ");
                    String s = sc.next();
                    stud.viewStudent(s);
                    break;


                case 3:
                    Student student1 = new Student(); // we need this object so we access the programs
                    System.out.println("Enter ID of the student: ");
                    String n = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(n)) {
                            if (students.get(i).getProgram().equals(student1.program1)) {
                                System.out.println(students.get(i).getName() + " is part of SUNY program");
                            } else if (students.get(i).getProgram().equals(student1.program2)) {
                                System.out.println(students.get(i).getName() + " is part of Local program");
                            } else {
                                System.out.println("Enter the correct program!");
                            }
                        } else {
                            System.out.println("This name does not exist");
                        }
                    }
                    break;


                case 4:
                    Student student2 = new Student();
                    Department department1 = new Department();
                    System.out.println("Enter ID of the student: ");
                    String nm = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(nm)) {
                            if (students.get(i).getProgram().equals(student2.program2)) {
                                System.out.println(students.get(i).getName() + " has to pay $" + department1.unyt);
                            } else if (students.get(i).getProgram().equals(student2.program1)) {
                                System.out.println(students.get(i).getName() + " has to pay $" + department1.unyt);
                            } else {
                                System.out.println("Program not found");
                            }
                        } else {
                            System.out.println("Student not found !");
                        }

                    }
                    break;

                case 5:
                    Student student3 = new Student();
                    Department department2 = new Department();
                    School school = new School();
                    System.out.println("Enter ID of the student to check if he wins a scholarship: ");
                    String d = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(d)) {
                            if (students.get(i).getProgram().equals(student3.program1)) {
                                if (students.get(i).getGpa() >= 3.3) {
                                    double tempcost = department2.setSuny(0);
                                    System.out.println(students.get(i).getName() + " has to pay $" + tempcost);
                                } else if (students.get(i).getGpa() <= 3.2 && students.get(i).getGpa() > 3.15) {
                                    double tempcost = department2.setSuny(department.suny - (0.75 * department.suny));
                                    System.out.println(students.get(i).getName() + " has to pay $" + tempcost);
                                } else if (students.get(i).getGpa() >= 3 && students.get(i).getGpa() <= 3.14) {
                                    double temp = department.setSuny(department2.suny / 2);
                                    System.out.println(students.get(i).getName() + " has to pay $" + temp);
                                } else {
                                    System.out.println("This student can not apply for internship in the SUNY program");
                                }
                            } else {
                                if (students.get(i).getProgram().equals(student3.program2)) {
                                    if (students.get(i).getGpa() >= 3.3) {
                                        double tempcost = department2.setSuny(0);
                                        System.out.println(students.get(i).getName() + " has to pay $" + tempcost);
                                    } else if (students.get(i).getGpa() <= 3.2 && students.get(i).getGpa() > 3.15) {
                                        double tempcost = department2.setSuny(department.unyt - (0.75 * department.unyt));
                                        System.out.println(students.get(i).getName() + " has to pay $" + tempcost);
                                    } else if (students.get(i).getGpa() >= 3 && students.get(i).getGpa() <= 3.14) {
                                        double temp = department.setSuny(department2.unyt / 2);
                                        System.out.println(students.get(i).getName() + " has to pay $" + temp);
                                    } else {
                                        System.out.println("This student can not apply for internship in the SUNY program");
                                    }
                                }
                            }
                        }
                    }

                    break;

                case 6:
                    System.out.println("How many departments do you want to add: ");
                    int j = sc.nextInt();
                    int count = 0;
                    while (count < j) {
                        System.out.println("Enter the department: ");
                        String dep = sc.next();
                        Department dp = new Department(dep);
                        departments.add(dp);
                        count++;
                    }
                    break;

                case 7:
                    System.out.println("The departments are");
                    for (int i = 0; i < departments.size(); i++) {
                        System.out.println(departments.get(i).getDep());
                    }

                    break;

                case 8:

                    System.out.println("Enter ID of the student:  ");
                    String m = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(m)) {
                            System.out.println("Enter name of the department: ");
                            String dp = sc.next();
                            for (int k = 0; k < departments.size(); k++) {
                                if (departments.get(i).getDep().equals(dp)) {
                                    System.out.println("How many subject will you analyze: ");
                                    int sub = sc.nextInt();
                                    if (sub < 0) {
                                        System.out.println("Do not enter negative values!");
                                        sub = sc.nextInt();
                                    }
                                    int l = 0;
                                    double total_points = 0;
                                    double points = 0;
                                    double total_credits = 0;
                                    int count_subject = 0;
                                    while (l < sub) {
                                        System.out.println("Enter name of subject: ");
                                        String subject = sc.next();
                                        count_subject++;
                                        System.out.println("Enter credits for " + subject);
                                        int credits = sc.nextInt();
                                        if (credits < 0 && credits > 8) {
                                            System.out.println("Do not enter negative values for the credits");
                                            credits = sc.nextInt();
                                        }
                                        total_credits += credits;
                                        System.out.println("Enter the grade for the subject " + subject);
                                        String grade = sc.next();
                                        switch (grade) {
                                            case "A":
                                                points = 4 * credits;
                                                break;
                                            case "A-":
                                                points = 3.5 * credits;
                                                break;
                                            case "B+":
                                                points = 3.0 * credits;
                                                break;
                                            case "B":
                                                points = 2.5 * credits;
                                                break;
                                            case "B-":
                                                points = 2.3 * credits;
                                                break;
                                            case "C+":
                                                points = 2 * credits;
                                                break;
                                            case "C":
                                                points = 1.7 * credits;
                                            case "C-":
                                                points = 1.3 * credits;
                                                break;
                                            case "D":
                                                points = 1 * credits;
                                                break;
                                            default:
                                                System.out.println("Input the correct letter grade: ");
                                                break;
                                        }
                                        total_points += points;

                                        l++;
                                    }
                                    double GPA = total_points / total_credits;
                                    students.get(i).setGpa(GPA);
                                    System.out.println("GPA updated!");

                                } else {
                                    System.out.println("Department does not exist!");
                                }
                            }
                        } else {
                            System.out.println("This student is not in the arraylist!");
                            System.out.println("Enter the ID again: ");
                            m = sc.next();
                        }
                    }
                    break;

                case 9:
                    System.out.println("Enter ID for the student to retrieve the gpa: ");
                    String r = sc.next();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equals(r)) {
                            System.out.println("The gpa for " + students.get(i).getName() + " is: " + students.get(i).getGpa());
                        }
                    }
                    break;


                case 10:
                    System.out.println("Enter student's id for deletion: ");
                    String idr = sc.next();
                    File file = new File("file"+idr+".txt");
                    if (file.exists()) {
                        if (file.delete()) {
                            System.out.println("File deleted");
                        } else {
                            System.out.println("Failed to be deleted");
                        }
                    }
                    break;


                case 11:
                    System.out.println("Enter student's ID: ");
                    String dd=sc.next();
                    for (int i=0; i<students.size(); i++){
                        if (students.get(i).getId().equals(dd)){
                            students.remove(i);
                            System.out.println("Student deleted from arraylist");
                        }
                    }
                    break;



                        case 12:
                            Student std = new Student();
                            System.out.println("Enter the student's ID: ");
                            String i = sc.next();
                            try {
                                std.viewStudent(i);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            System.out.print("Please Enter the detail you want to Update :");
                            System.out.print("\nFor Example :\n");
                            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                            String sp = sc.next();
                            System.out.print("Please Enter the Updated Info :");
                            String np = sc.next();
                            try {
                                std.updateStudent(i, sp, np);
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            break;




                        case 0:
                            System.exit(0);

                        default:
                            break;
                    }


            }
        }


        public static void menu () {
            System.out.println("**************MENU**************");
            System.out.println("1: Add student: ");
            System.out.println("2: Show student: ");
            System.out.println("3: Show the program of this student: ");
            System.out.println("4: Enter one name and display the fee of his program:  ");
            System.out.println("5: Check for scholarship by entering name: ");
            System.out.println("6: Enter the department/s : ");
            System.out.println("7: Show departments");
            System.out.println("8: Calculate GPA from scratch: ");
            System.out.println("9: Retrieve GPA: ");
            System.out.println("10: Remove Student's file: ");
            System.out.println("11: Remove Student from arraylist: ");
            System.out.println("12: Update the information of the student in the text file: ");
            System.out.println("0: Exit");


        }


    }

