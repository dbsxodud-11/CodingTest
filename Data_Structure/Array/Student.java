package Data_Structure.Array;

public class Student {
    
    private String first;
    private String last;
    private int id_num;
    private double gpa;

    public Student(String name, int id_num, double gpa){
        String[] first_last = name.split(" ");
        this.first = first_last[0];
        this.last = first_last[1];
        this.id_num = id_num;
        this.gpa = gpa;
    }    

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public int getID(){
        return id_num;
    }

    public double getGPA(){
        return gpa;
    }

    public String toString(){
        return first + " " + last + "\t" + id_num + "\t" + gpa;
    }
}
