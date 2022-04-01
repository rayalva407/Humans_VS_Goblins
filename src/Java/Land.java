import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Land {
    final String LEFT_MARGIN = "                                                                    ";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_RESET = "\u001B[0m";
    int length;
    int height;
    Random random = new Random();

    char[][] gameGrid;
    ArrayList<Goblin> goblins = new ArrayList<>();
    Human human;

    //Constructor
    Land(int length, int height, Human human) {
        this.length = length;
        this.height = height;
        this.human = human;

        gameGrid = new char[height][length];

        for (char[] row : gameGrid) {
            Arrays.fill(row, '-');
        }
    }

    //Gives Human a position in the land
    public void spawnHuman() {
        human.setVPos(this.height - 1);
        human.setHPos(random.nextInt(this.length));
    }

    //Moves human to a different position
    public void moveHuman(char input) {
        if (input == 'w') {
            if (human.getVPos() == 0) {
                System.out.println("Out of bounds try going a different direction");
            }
            else {
                human.setVPos(human.getVPos() - 1);
            }
        }
        if (input == 'a') {
            if (human.getHPos() == 0) {
                System.out.println("Out of bounds try going a different direction");
            }
            else {
                human.setHPos(human.getHPos() - 1);
            }
        }
        if (input == 's') {
            if (human.getVPos() == this.height - 1) {
                System.out.println("Out of bounds try going a different direction");
            }
            else {
                human.setVPos(human.getVPos() + 1);
            }
        }
        if (input == 'd') {
            if (human.getHPos() == this.length - 1) {
                System.out.println("Out of bounds try going a different direction");
            }
            else {
                human.setHPos(human.getHPos() + 1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder landStr = new StringBuilder();

        for (int i = 0; i < gameGrid.length; i++) {
            landStr.append(LEFT_MARGIN);
            for (int j = 0; j < gameGrid[i].length; j++) {
                if(i == human.getVPos() && j == human.getHPos()) {
                    landStr.append(TEXT_BLUE).append(human.toString()).append(TEXT_RESET);
                }
                else {
                    landStr.append(gameGrid[i][j]);
                }
            }
            landStr.append("\n");
        }
        return landStr.toString();
    }


}
