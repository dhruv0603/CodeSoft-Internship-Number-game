import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    // Variables
    int levelChoice,guessNumber,score=0;
    int chance=0;
    int gameChance=0;
    public int[] level={0,1,2,3,4,5};
    public int[] levelChance={20,18,14,12,10,8};

    // About game 
    public static void about() {
        System.out.println("          Guess the number game          ");
        System.out.println("This game starts in such a way that computer generates a RANDOM number between 1 and 100 and ask the user to guess the number in limited amout of chances and adding this it provide the score to  the player based on that...");
        System.out.println("          Thank you          ");
    }

    // Main Menu
    public static void mainMenu() {
        System.out.println("******************** Random Number ********************");
        System.out.println("*               1. About game                         *");
        System.out.println("*               2. Select Level                       *");
        System.out.println("*               3. Classic Start                      *");
        System.out.println("*               4. Score Card                         *");
        System.out.println("*               5. Exit                               *");
        System.out.println("*******************************************************");
        System.out.println("Enter your Choice : ");
    }
    public static void main(String[] args) {
        RandomNumber r =new RandomNumber();
        while(true) {
            // Generating the number 
            Random random = new Random();
            int randomNumber=random.nextInt(100);

            mainMenu();
        try(Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();

            if(choice==1) {
                about();
            }

            else if(choice==2) {
                for(int i=0;i<6;i++) {
                    System.out.print(" "+r.level[i]);
                }
                System.out.println();
                System.out.println("Enter the level : ");
                r.levelChoice=sc.nextInt();        // Level selected
                    System.out.println("      You are at level "+r.levelChoice);
                    r.gameChance=r.levelChance[r.levelChoice];
                    boolean flag = true;
                    for(int i=0;i<r.gameChance;i++) {
                        System.out.println("Enter the guess Number : ");
                        r.guessNumber=sc.nextInt();
                        r.chance++;
                        if(r.guessNumber==randomNumber) {
                            System.out.println("Congratulations! You have guess the number in "+r.chance+"  Chance");
                            flag=false;
                            r.score++;
                            break;
                        }
                        else if (r.guessNumber>randomNumber) {
                            System.out.println("Guess is too high");
                        }
                        else if(r.guessNumber<randomNumber) {
                            System.out.println("Guess is too Low");
                        }
                    }
                    if(flag==true) {
                        System.out.println("---------------------You Loss--------------------");
                    } 

            }
            else if(choice==3) {
                boolean flag=true;
                for(int i=0;i<20;i++) {
                    System.out.println("Enter the guess Number : ");
                    r.guessNumber=sc.nextInt();
                    r.chance++;
                    if(r.guessNumber==randomNumber) {
                        System.out.println("Congratulations! You have guess the number in "+r.chance+" Chance");
                        flag=false;
                        r.score++;
                        break;
                    }
                    else if (r.guessNumber>randomNumber) {
                        System.out.println("Guess is too high");
                    }
                    else if(r.guessNumber<randomNumber) {
                        System.out.println("Guess is too Low");
                    }
                    }
                if(flag==true) {
                        System.out.println("---------------------You Loss--------------------");
                }
            }
            else if(choice==4) {
                System.out.println("Your score is "+r.score);
            }
            else if(choice==5) {
                break;
            }
            else {
                System.out.println("Wrong choice");
            }
        }
    }
}
}
