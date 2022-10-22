import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {
    String word;
    private char[] wordArray;
    private int tries;
    private ArrayList<Character> lettersguessed;
    private char[] correct;
    int score;
    
    public static void main(String[]args){
        System.out.println();
        Hangman hg = new Hangman();
        char again = 'y';
        hg.setScore();
        Scanner user_input = new Scanner(System.in);
        char guess;
        while(again == 'y'){
            hg.setup();
            boolean complete = false;
            while(hg.getTries()> 0 && !complete){
                guess = user_input.next().charAt(0);
                hg.addGuess(guess);
                if(!hg.checker(guess)){
                    hg.loseTry();
                }
                hg.gameCreator();
                if(hg.gameComplete()){
                    complete = true;
                }
            }
            if(hg.getTries() == 0){
                hg.wordPrinter();
                System.out.println("I am sorry but you lost. Type y if you would like to try again. If not, then press any key.");
            }else{
                hg.scoreWon();
                hg.gameCreator();
                System.out.println("You won!!! Type y if you would like to try again. If not, then press any key.");
            }
            again = user_input.next().charAt(0);
        }
    }
    
    public boolean checker(char guess){
        boolean checker = false;
        for(int i = 0; i<wordArray.length; i++){
            if(wordArray[i] == guess){
                correct[i] = guess;
                checker = true;
            }
        }
        return checker;
    }
    
    public char[] charcreater(){
        word = wordChooser();
        wordArray = word.toCharArray();
        return wordArray;
    }
    public static String wordChooser(){
        String[] dict = WordList.getWords("M:\\Documents\\NetBeansProjects\\ReadingFiles\\src\\words.txt");
        return dict[(int)(Math.random() * ((113735) + 1))];
    }
    
    public void numberOfTries(){
        if(word.length() < 5){
            tries = 5;
        }else if(word.length() < 7){
            tries = 8;
        }else if(word.length() < 11){
            tries = 10;
        }else{
            tries = 15;
        }
    }
    public void setScore(){
        score = 0;
    }
    public void scoreWon(){
        score++;
    }
    public boolean gameComplete(){
        for(int i = 0; i<correct.length; i++){
            if(correct[i] != wordArray[i]){
                return false;
            }
        }
        return true;
    }
    public void gameCreator(){
        for(int i = 0; i<49; i++){
            System.out.println();
        }
        System.out.println("You have correctly guessed the word: " + score + " times.");
        System.out.println("You have " + tries + " tries left in this round.");
        for(int i = 0; i<correct.length; i++){
            System.out.print(correct[i] + " ");
        }
        System.out.println();
        guessPrinter();
    }
    public void addGuess(char c){
        lettersguessed.add(c);
    }
    public void loseTry(){
        tries--;
    }
    public int getTries(){
        return tries;
    }
    public void setup(){
        for(int i = 0; i<49; i++){
            System.out.println();
        }
        charcreater();
        numberOfTries();
        correct = new char[wordArray.length];
        System.out.println("Your got " + score + " words correct.");
        System.out.println("You have " + tries + " guesses to guess the word. You win if you solve the word with " + tries + " or less letters wrong.");
        for(int i = 0; i<wordArray.length; i++){
            System.out.print("_" + " ");
            correct[i] = '_';
        }
        System.out.println();
        lettersguessed = new ArrayList<>();
    }
    public void wordPrinter(){
        System.out.println();
        System.out.println("The word is: " + word + ".");
    }
    public void guessPrinter(){
        System.out.print("Letters guessed:");
        for (Character lettersguessed1 : lettersguessed) {
            System.out.print(" " + lettersguessed1);
        }
        System.out.println();
    }
}