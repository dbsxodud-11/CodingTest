package Data_Structure.Array;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    //Comparator
    public static final Comparator<Student> By_ID = new By_ID();
    public static final Comparator<Student> By_First_Name = new By_First_Name();
    public static final Comparator<Student> By_Last_Name = new By_Last_Name();
    public static final Comparator<Student> By_GPA_Ascending = new By_GPA_Ascending();
    public static final Comparator<Student> By_GPA_Descending = new By_GPA_Descending();

    private static class By_ID implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            //return s1.id_num.compareTo(s2.id_num); //compareTo: primitive type에는 사용 불가능 why? primitive type int cannot call method
            if(s1.getID() <= s2.getID()) return -1;
            else return 1;
        }
    }

    private static class By_First_Name implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.getFirst().compareTo(s2.getFirst());
        }
    }

    private static class By_Last_Name implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.getLast().compareTo(s2.getLast());
        }
    }

    private static class By_GPA_Ascending implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            if(s1.getGPA() <= s2.getGPA()) return -1;
            else return 1;
        }
    }

    private static class By_GPA_Descending implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            if(s1.getGPA() > s2.getGPA()) return -1;
            else return 1;
        }
    }

    public static void main(String[] args){

        List<Student> student_list = new LinkedList<>();
        student_list.add(new Student("Jane Air", 20150210, 4.2));
        student_list.add(new Student("Jeremy Rifkin", 20160543, 3.5));
        student_list.add(new Student("Yuval Harari", 20170692, 3.9));
        student_list.add(new Student("Mark Zuckerburg", 20180278, 4.1));
        student_list.add(new Student("Elon Musk", 20170436, 3.4));
        student_list.add(new Student("Jeff Bezos", 20190746, 3.1));
        student_list.add(new Student("Sundar Pichai", 20200136, 4.3));
        student_list.add(new Student("Yun Taeyoung", 20180424, 3.4));

        for(Student student: student_list){
            System.out.println(student.toString());
        }

        System.out.println("-----------------Sorted by ID--------------------");
        Collections.sort(student_list, By_ID);

        for(Student student: student_list){
            System.out.println(student.toString());
        }

        System.out.println("-----------------Sorted by First Name--------------------");
        Collections.sort(student_list, By_First_Name);

        for(Student student: student_list){
            System.out.println(student.toString());
        }

        System.out.println("-----------------Sorted by Last Name--------------------");
        Collections.sort(student_list, By_Last_Name);

        for(Student student: student_list){
            System.out.println(student.toString());
        }

        System.out.println("-----------------Sorted by GPA(Ascending Order)--------------------");
        Collections.sort(student_list, By_GPA_Ascending);

        for(Student student: student_list){
            System.out.println(student.toString());
        }

        System.out.println("-----------------Sorted by GPA(Descending Order)--------------------");
        Collections.sort(student_list, By_GPA_Descending);

        for(Student student: student_list){
            System.out.println(student.toString());
        }
    }
}
