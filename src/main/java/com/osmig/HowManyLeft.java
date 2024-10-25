package com.osmig;

import java.util.Random;
import java.util.Scanner;

public class HowManyLeft {
     // [ #, #, #, #, #, #, #, # , # ]
    // 3 -> first player
    // [ #, #, #, #, #, # ]
    // 2 -> ai move
    //[ #, #, #, #]
    //player - 1
    // n - x % 4
    static Random generator = new Random();
    private static int n = 13;
    private static Scanner scanner = new Scanner(System.in);
    static String marbles = " marbles";
    static int aimove = 0;
    static int playerMove;

    public static int aiMove(int n){
        for(int i = 1; i<=3 ; i++){
            if((n - i) % 4 == 0){
                return i;
            }
        }

        return generator.nextInt(1, 3);
    }

    public static boolean checkValidInPut(int move){
        if (move > 0 && move <= 3){
            return true;
        }else {
            return false;
        }
    }

    public static int askInput(){
        System.out.print("You: ");
        playerMove = scanner.nextInt();// input is 1
        scanner.nextLine();
        return playerMove;
    }

    public static void playMarbles(){
        System.out.println("\n        - Marbles game - " +
                "\nThere are 13 marbles at start, " +
                "\nyou can take 1 to 3 marbles per turn," +
                "\nwhoever takes the last marbles wins!");

        while (n > 0 ){

            System.out.println("\nAvailable: " + n);

            do {
                playerMove = askInput();
            }while (checkValidInPut(playerMove) == false);
            //playerMove = askInput();


            if(n - playerMove == 0){
                System.out.println("You win!");
                n = 13;
                break;
            }

            n -= playerMove; // n = 12

            System.out.println("\nAvailable: " + n);

            aimove = aiMove(n);
            if(n - aimove == 0){
                System.out.println("Dex ex machina wins!");
                n = 13;
                break;
            }

            n -= aimove;
            if(aimove < 2) { marbles = " marble"; }
            // ai returns -1 n -> 11
            System.out.println("Dex ex machina: " + aimove);

        }
    }

    public static void main(String[] args) {
        // int x = aiMove(11);
        // System.out.println(x);
        // print game rules
        // blablabla
        do {
            playMarbles();
            System.out.print("\nWanna play again? (y/n) ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("n")){
                System.out.println("\nYou suck!");
                break;
            }
        }while (true);
    }


}
