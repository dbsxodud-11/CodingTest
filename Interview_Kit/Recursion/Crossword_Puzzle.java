package Interview_Kit.Recursion;

import java.io.*;
import java.util.*;

public class Crossword_Puzzle {

    // Complete the crosswordPuzzle function below.
    public static String[][] answer;
    static String[] crosswordPuzzle(String[] crossword, String words) {

        //Prepare a word list
        String[] word_list = words.split(";");
        String[][] cross_word = new String[crossword.length][crossword[0].length()];
        for(int i=0; i<crossword.length; i++){
            for(int j=0; j<crossword[0].length(); j++){
                cross_word[i][j] = Character.toString(crossword[i].charAt(j));
            }
        }
        solvePuzzle(cross_word, word_list, 0);
        String[] result = new String[answer.length];
        for(int i=0; i<cross_word.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<answer[0].length; j++){
                sb.append(answer[i][j]);
            }
            result[i] = sb.toString();
        }
        return result;
    }


    private static void solvePuzzle(String[][] crossword, String[] word_list, int index){
        if(answer != null) return;
        if(index < word_list.length){
            String word = word_list[index];
            int maxStart = crossword.length - word.length();
            String[][] temp = new String[10][10];
            //1. Horizontal
            for(int i=0; i<crossword.length; i++){
                for(int j=0; j<=maxStart; j++){
                    temp = checkHorizontal(i, j, crossword, word);
                    if(!temp[0][0].equals("x")){
                        solvePuzzle(temp, word_list, index+1);
                    }
                }
            }
            //2. Vertical
            for(int j=0; j<crossword.length; j++){
                for(int i=0; i<=maxStart; i++){
                    temp = checkVertical(i, j, crossword, word);
                    if(!temp[0][0].equals("x")){
                        solvePuzzle(temp, word_list, index+1);
                    }
                }
            }
        }else{
            answer = crossword;
            return;
        }
    }

    private static String[][] checkHorizontal(int i, int j, String[][] crossword, String word){
        String[][] temp = new String[crossword.length][crossword[0].length];
        for(int a=0; a<crossword.length; a++){
            for(int b=0; b<crossword.length; b++){
                temp[a][b] = crossword[a][b];
            }
        }
        for(int index=0; index<word.length(); index++){
            //System.out.println(crossword[i][j+index] + " " + word.charAt(index));
            if(crossword[i][j+index].equals("-") || crossword[i][j+index].equals(Character.toString(word.charAt(index)))){
                temp[i][j+index] = Character.toString(word.charAt(index));
            }else{
                temp[0][0] = "x";
                return temp;
            }
        }
        return temp;
    }

    private static String[][] checkVertical(int i, int j, String[][] crossword, String word){
        String[][] temp = new String[crossword.length][crossword[0].length];
        for(int a=0; a<crossword.length; a++){
            for(int b=0; b<crossword.length; b++){
                temp[a][b] = crossword[a][b];
            }
        }
        for(int index=0; index<word.length(); index++){
            //System.out.println(crossword[i][j+index] + " " + word.charAt(index));
            if(crossword[i+index][j].equals("-") || crossword[i+index][j].equals(Character.toString(word.charAt(index)))){
               temp[i+index][j] = Character.toString(word.charAt(index));
            }else{
                temp[0][0] = "x";
                return temp;
            }
        }
        return temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(result[i]);
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.println();
                //bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
