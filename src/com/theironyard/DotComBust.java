package com.theironyard;
import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        //first make some dot coms and give them locations
        //make three DotCom objects, give 'em names, and stick 'em in the ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        //print brief instructions for user.
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        //repeat for each DotCom in the list
        for (DotCom dotComToSet : dotComsList) {

            //Ask the helper for a DotCom location (an ArrayList of Strings).
            ArrayList<String> newLocation = helper.placeDotCom(3);

            //Call the setter method on this DotCom to
            // give it the location you just got from the helper.
            dotComToSet.setLocationCells(newLocation);

        } //close for loop
    }//close setUpGame method

    public void startPlaying() {
        //as long as the DotCom list in NOT empty (the ! means not)
        //it's the same as (dotComsList.isEmpty == false).
        while(!dotComsList.isEmpty()) {

            //get user input
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess); //call our own checkUserGuess method
        }//close while

        finishGame(); //call our own finishGame method
    }//close startPlaying method

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; //increment number of guesses the user has made

        String result = "miss"; //assume it's a 'miss', unless told otherwise

        for(int x = 0; x < dotComsList.size(); x++) { //repeat with all DotComs
            // in the list

            result = dotComsList.get(x).checkYourself(userGuess); //ask the DotCom
            //to check the user guess, looking for a hit (or kill)

         if (result.equals("hit")) {
             break; //get out of loop early, no point testing the others
         }
          if (result.equals("kill")) {
             dotComsList.remove(x); //this guy's dead, so take him out of the
              //DotComs list then get out of the loop
             break;
          }

        }//close for loop

        System.out.println(result); //print the result for the user
    }//close checkUserGuess method

    private void finishGame() {
        //print a message telling the user how he did in the game
        System.out.println("All dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <+ 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");

        }
    } //close finishGame method


}//close class
