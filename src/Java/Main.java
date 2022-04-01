import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String TEXT_RED = "\u001B[31m";
        final String TEXT_GREEN = "\u001B[32m";
        final String TEXT_RESET = "\u001B[0m";
        Human human = new Human();
        Land land = new Land(30, 10, human);
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        char input;

        //"Title Screen"
        System.out.println(TEXT_GREEN + "                                                                           Humans VS Goblins");
        System.out.println(TEXT_RED + "                                                The land is being invaded by goblins! Kill as many as you can to survive!" + TEXT_RESET);
        System.out.println();
        System.out.println();


        land.spawnHuman();
        while (playing) {
            System.out.println(land);
            System.out.println("Move using 'w'(up), 'a'(left), 's'(down), 'd'(right) and press enter ");
            input = getInput(scanner);
            land.moveHuman(input);
        }
    }

    //Gets input from the user if input is valid
    private static char getInput(Scanner scanner) {
        char input;
        try {
            input = scanner.nextLine().charAt(0);
            return input;
        }
        catch (Exception e) {
            System.out.println("Invalid input please try again!");
            return getInput(scanner);
        }
    }
}
