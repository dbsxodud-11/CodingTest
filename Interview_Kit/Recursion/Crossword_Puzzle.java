package Interview_Kit.Recursion;

import java.io.*;
import java.util.*;

public class Crossword_Puzzle {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {

        //Prepare a word list
        String[] word_list = words.split(";");
        boolean[] is_used = new boolean[word_list.length];
        char[][] cross_word = new char[crossword.length][crossword[0].length()];
        for(int i=0; i<crossword.length; i++){
            for(int j=0; j<crossword[0].length(); j++){
                cross_word[i][j] = crossword[i].charAt(j);
            }
        }
        cross_word = solvePuzzle(cross_word, word_list, is_used);
        String[] answer = new String[cross_word.length];
        for(int i=0; i<cross_word.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<cross_word[0].length; j++){
                sb.append(cross_word[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private static char[][] solvePuzzle(char[][] crossword, String[] word_list, boolean[] is_used){
        for(int i=0; i<crossword.length; i++){
            for(int j=0; j<crossword[0].length; j++){
                if(crossword[i][j] != '-') continue;
                else{
                    if(i != crossword.length-1 && crossword[i+1][j] == '-'){
                        //Vertical
                        int wordLength = 0;
                        while(i != crossword.length && crossword[i][j] == '-'){
                            wordLength++;
                            i++;
                        }
                        for(int l=0; l<word_list.length; l++){
                            if(is_used[l]) continue;
                            String word = word_list[l];
                            if(wordLength == word.length()){
                                for(int k=0; k<wordLength; k++){
                                    if(j != 0 && crossword[i-wordLength+k][j-1] == '-') continue;
                                    else if(j != crossword[0].length-1 && crossword[i-wordLength+k][j+1] == '-') continue;
                                    crossword[i-wordLength+k][j] = word.charAt(k);
                                }
                                is_used[l] = true;
                                break;
                            }
                        }
                        return solvePuzzle(crossword, word_list, is_used);
                    }
                    if(j != crossword[0].length-1 && crossword[i][j+1] == '-'){
                        int wordLength = 0;
                        while(j != crossword[0].length && crossword[i][j] == '-'){
                            wordLength++;
                            j++;
                        }
                        for(int l=0; l<word_list.length; l++){
                            if(is_used[l]) continue;
                            String word = word_list[l];
                            if(wordLength == word.length()){
                                for(int k=0; k<wordLength; k++){
                                    if(i != 0 && crossword[i-1][j-wordLength+k] == '-') continue;
                                    else if(i != crossword[0].length-1 && crossword[i+1][j-wordLength+k] == '-') continue;
                                    crossword[i][j-wordLength+k] = word.charAt(k);
                                }
                                is_used[l] = true;
                                break;
                            }
                        }
                        return solvePuzzle(crossword, word_list, is_used);
                    }
                }
            }
        }
        return crossword;
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
