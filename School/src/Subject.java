public class Subject {
    String name;
    int credits;
    double grade;


    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }


    public double getGrade(){
        return grade;
    }

    public double setgrade(double grade2){
        grade=grade2;
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
