package com.theironyard;
import java.util.*;

public class DotCom { //DotCom's instance variables
    private ArrayList<String> locationCells; //an ArrayList of cell locations
    private String name; //the DotCom's name

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
        //a setter method
        // that updates the DotCom's location. (Random location provided by
        // the GameHelper placeDotCom() method.)
    }

    public void setName(String n) { //basic setter method
        name = n;
    }

    public String checkYourself(String userInput) {

        String result = "miss";

        int index = locationCells.indexOf(userInput);// The ArrayList indexOf()
        //method in action! If the user guess is one of the entries in the ArrayList,
        // indexOf() will return its ArrayList location. If not, indexOf() will return -1

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : (");
            } else {
                result = "hit";
            } //close if

        }//close if

        return result;

    }//close method

}//close class