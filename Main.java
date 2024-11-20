import java.util.Random;
import java.util.Scanner;

public class Main implements Contract {

    //Attributes of the Main class
    int socialAptitude = 0;
    String name;
    Random rand = new Random();
    //Responses possible in the examine method
    private static String[] examineResponses = {
        "It's seen better days.",
        "It's stunning!",
        "it's not much, but it's something!"};

    //Attributes for text color, to make text displays in terminal more interesting
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    
    /**
     * Undo method
     */
    public void undo(){
        System.out.println("There is no undoing. Learn to live with the consequences of your actions.");
    }

    /**
     * Examine method
     * @param item - item to examine
     */
    public void examine(String item){
        //Message about examining the item
        System.out.println("Now examining a " + item + "...");
        //A random number is chosen from 1-3
        int number = rand.nextInt(3);
        //The corresponding message in examineResponses is printed
        System.out.println(examineResponses[number]);
    }

    /**
     * Method to grab an item
     * @param item - item to be grabbed
     */
    public void grab(String item){
        //Message that an item has been grabbed
        System.out.println("You now have a " + item + "!");
    }

    /**
     * Walk method
     * @param direction - direction to walk
     * @return - boolean if walking is possible
     */
    public boolean walk(String direction){
        //Message that character is walking
        System.out.println("🚶 Now walking " + direction + " ... 🚶");
        return true;
    }

    /**
     * Fly method
     * Params are coordinates to fly to
     * @param x
     * @param y
     * @return - boolean if flying is possible
     */
    public boolean fly(int x, int y){
        //Message that you can't fly
        System.out.println("Sike. You can't fly — this is college, not fantasy land.");
        //Return that flying is not possible
        return false;
    }

    /**
     * Shrink method
     * @return - social aptitude after shrinking
     */
    public Number shrink(){
        //Reduce social aptitude levels by 1-3
        socialAptitude -= rand.nextInt(1, 3);
        //Return this shrunken level
        return socialAptitude;
    }

    /**
     * Rest method
     */
    public void rest(){
        //Print rest message
        System.out.println("Let sleep wash over you... 😴");
        //Exit program
        System.exit(0);
    }

    /**
     * Drop method
     * @param item - item to drop
     * @return - text to return
     */
    public String drop(String item){
        //Return that an item is being dropped
        return "Unloading " + item + "... ";
    }

    /**
     * Grow method
     * @return - returns increased social aptitude
     */
    public Number grow(){
        //Increase social aptitude level by between 1 and 4 points
        socialAptitude += rand.nextInt(1, 4);
        //Return this increased level
        return socialAptitude;
    }

    /**
     * Use method
     * @param item - item to use
     */
    public void use(String item){
        //Print that an item is being used
        System.out.println("Using " + item + "...");
    }


    public static void main(String[] args) {
        //Create main object
        Main main = new Main();
        //Init scanner to take in input throughout the game
        Scanner input = new Scanner(System.in);
        //Take in the name of the player
        System.out.println("What's your name? ");
        String name = input.nextLine();
        //Print welcome messages/start of game
        System.out.println("Welcome to SMITH COLLEGE ORIENTATION. We've been waiting for you all summer and we're so glad you're finally here!");
        System.out.println("Today, you'll learn what it means to live, study, and love at Smith.");
        System.out.println("Let's get started, shall we?");
        System.out.println("");
        System.out.println("Welcome to THE ITT");
        System.out.println(ANSI_BLUE + "Sarah:" + ANSI_RESET + " Welcome to the ITT! I have your key for you, if you're willing to take the risk.");
        System.out.println("Sarah has a key in her hand. Do you want to... (1) grab OR (2) examine it? [You must enter an int]");
        //Take in int answer
        int intAnswer = input.nextInt(); 
        input.nextLine();
        //If int answer is 2 ('examine'),
        if (intAnswer == 2){
            //examine object
            main.examine("key");
            //ask if the player would like to grab
            System.out.println("Would you like to grab? Input 1 for yes, 2 for no");
            intAnswer = input.nextInt();
            //If they say no,
            if (intAnswer == 2){ 
                //Print that they must grab
                System.out.println("Too bad. This is not an option. You must grab.");
            }
        }
        //Grab key
        main.grab("key");
        //Print transitional text
        System.out.println(ANSI_BLUE + "Sarah:" + ANSI_RESET + " Time to go to your house!");
        System.out.println(ANSI_BLUE + "Sarah:" + ANSI_RESET + "Looks like you're in Duckett. That's to the northeast, on Elm Street");
        System.out.println("Would you like to (1) walk OR (2) fly to your house?");
        intAnswer = input.nextInt();
        //If person wants to fly,
        if (intAnswer == 2){
            //"Fly" to Duckett's coordinates
            System.out.println("Now flying to Duckett's coordinates...");
            main.fly(42, 72);
            //This results in the message that you cannot fly, you must walk
        }
        //Walk to Duckett
        main.walk("northeast");
        //Transitional text
        System.out.println(ANSI_PURPLE + "House President: " + ANSI_RESET + "Welcome to your new home!");
        System.out.println(ANSI_RED + "YOU: " + ANSI_RESET + "You too!");
        //Call shrink to shrink social aptitude
        System.out.println("Oof... That was rough. Your social aptitude level is now " + main.shrink());
        //Transitional text
        System.out.println(ANSI_PURPLE + "House President: " + ANSI_RESET + "Okay...");
        System.out.println(ANSI_PURPLE + "House President: " + ANSI_RESET + "You're on the third floor!");
        System.out.println("Shoot... She thinks you're dumb, doesn't she?");
        System.out.println("Would you like to undo that last interaction? 1 for yes, 2 for no.");
        intAnswer = input.nextInt();
        //If player wants to undo,
        if (intAnswer == 1){
            //Call undo
            main.undo();
        }
        //Go upstairs
        main.walk("upstairs");
        System.out.println("You've never shared a roommate before. Hopefully this is nice!");
        //Open room using use method
        main.use("key");
        //Transitional text
        System.out.println(ANSI_GREEN + "Roommate: " + ANSI_RESET + "Are you " + name + "? It's so nice to meet you!");
        System.out.println(ANSI_GREEN + "Roommate: " + ANSI_RESET + "I've never shared a room before. I hope I can be a good roommate.");
        System.out.println("Wow! She's in the same boat. There's no need to be nervous.");
        System.out.println(ANSI_RED + "YOU: " + ANSI_RESET + "I'm sure you'll be great!");
        System.out.println("You should drop off your key and bags...");
        //Drop off key and bags using drop method
        System.out.println(main.drop("room key") + main.drop("bags"));
        //Display options
        System.out.println("Should you... \n 1) Unpack \n 2) Get lunch with your roommate \n 3) Play an icebreaker with her");
        intAnswer = input.nextInt();
        //Text for each option does not use methods, just text. All have same outcome
        if(intAnswer == 1){
            System.out.println(ANSI_RED + "You: " +ANSI_RESET + "I think I'm gonna unpack.");
            System.out.println(ANSI_GREEN + "Roommate: " + ANSI_RESET + "Cool! Do you want some help?");
            System.out.println("She seems nice! Why not?");
            System.out.println("You both help each other unpack until the wee hours, when the sun sets over Paradise Pond.");
        } if(intAnswer == 2){
            System.out.println("Lunch turns into chatting on the lawn, which turns into dinner.");
            System.out.println("Neither of you unpack, but neither of you care. It's a problem for tomorrow");
        } else{
            System.out.println(ANSI_RED + "You: " +ANSI_RESET + "Want to play two truths and a lie?");
            System.out.println("This works! You and her play ice breakers for most of the day. At one point, your hallmates get in on the game.");
        }
        System.out.println("It's been a weird day, but you can't help but feel that you've grown.");
        //Call grow twice, so number is not negative or 0
        main.grow();
        //Display that social aptitude has grown
        System.out.println("At the end of it, your social aptitude is " + main.grow());
        //Closing messages
        System.out.println("Let's get it even higher tommorow!");
        System.out.println("It's getting late. You should probably rest.");
        System.out.println("See you tomorrow!");
        //Rest method called, game ends
        main.rest();
    }
}
