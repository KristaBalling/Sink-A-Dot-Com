package com.theironyard;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    //create the game object
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }//close method
}
