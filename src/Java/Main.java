import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String TEXT_RED = "\u001B[31m";
        final String TEXT_GREEN = "\u001B[32m";
        final String TEXT_RESET = "\u001B[0m";
        Human human = new Human();
        Goblin goblin = new Goblin();
        Land land = new Land(30, 10, human);
        Scanner scanner = new Scanner(System.in);
        char input;
        boolean playing = true;

        //"Title Screen"
        System.out.println(TEXT_GREEN + "                                                                           Humans VS Goblins");
        System.out.println(TEXT_RED + "                                                The land is being invaded by goblins! Kill as many as you can to survive!" + TEXT_RESET);
        System.out.println();
        System.out.println();


        land.spawnHuman();
        while (playing) {
            System.out.println(land);
            System.out.println("Move using 'w'(up), 'a'(left), 's'(down), 'd'(right) and press enter ");
            input = scanner.nextLine().charAt(0);
            land.moveHuman(input);
        }
    }
}
