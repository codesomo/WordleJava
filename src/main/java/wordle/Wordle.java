package wordle;

import java.util.Scanner;

public class Wordle{
    private int numOfAttempt;
    private String secretWord;

    //constructor
    public Wordle(int num, String word){
        this.numOfAttempt = num;
        this.secretWord = word;
    }

    public void game(){
        //create object to get user input
        Scanner input = new Scanner(System.in);
        int remainingAttempt = numOfAttempt;

        while(remainingAttempt > 0){
            //ask for user input
            System.out.println("Attemps remaining out of 6 is "+ remainingAttempt);
            System.out.println("Please enter a guess for the secret word of length 6.");
            String userGuess = input.nextLine();

            //check if user entered a valid input.
            if(userGuess.length() != secretWord.length()){
                System.out.println("Invalid length, the length of the word should be 6.");
                remainingAttempt--;
                continue;
            }

            int correctPosition = 0;
            int wrongPlace = 0;
            //if valid word check if correct position or correct character wrong position
            for(int i = 0; i<secretWord.length(); i++){
                char c = userGuess.charAt(i);
                if(c == secretWord.charAt(i)){
                    //increment position if userguess and secret word match
                    correctPosition++;
                }else if(secretWord.indexOf(c)>=0){
                    //if character present but wrong position
                    wrongPlace++;
                }
            }

            //for valid guess and wrong guess
            if(correctPosition == secretWord.length()){
                System.out.println("You guess it correctly. The secret word is: "+ secretWord);
                break;
            }else{
                System.out.println("Number of Correct positions: "+ correctPosition);
                System.out.println("Number of Correct character wrong position: "+wrongPlace);
                remainingAttempt--;
            }
        }

        if(remainingAttempt == 0){
            System.out.println("You have run out of attempt, the secrete was: "+ secretWord);
        }
    }
}