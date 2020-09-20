package Algorithms.Implementation;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Grading_Students {
    
    public static List<Integer> gradingStudents(List<Integer> grades){

        List<Integer> answer = new LinkedList<>();
        for(int grade: grades){
            //1. multiple of 5
            if(grade % 5 == 0) answer.add(grade);
            //2. less than 38
            else if(grade < 38) answer.add(grade);
            else{
                int quotient = grade/5; //둘 다 int 자료형이기 때문에 몫도 int로 출력됨
                int next_multiple = (quotient+1)*5;
                if(next_multiple - grade < 3) grade = next_multiple;
                answer.add(grade);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine());
        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try{
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim) //trim: 공백제거
          .map(Integer::parseInt) //parseInt: String -> Integer
          .collect(toList());

        List<Integer> result = gradingStudents(grades);

        bufferedWriter.write(result.stream().map(Object::toString)
                                            .collect(joining("\n")) + "\n");
        bufferedReader.close();
        bufferedWriter.close();
    }
}
