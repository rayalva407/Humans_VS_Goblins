import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Land {
    final String LEFT_MARGIN = "                                                                    ";
    final String TEXT_RESET = "\u001B[0m";
    final String TEXT_RED = "\u001B[31m";
    int length;
    int height;
    Random random = new Random();

    Object[][] gameGrid;
    ArrayList<Goblin> goblins = new ArrayList<>();
    Human human;

    //Constructor
    Land(int length, int height, Human human) {
        this.length = length;
        this.height = height;
        this.human = human;

        gameGrid = new Object[height][length];

        for (Object[] row : gameGrid) {
            Arrays.fill(row, '-');
        }
    }

    //Gives Human a position in the land
    public void spawnHuman() {
        human.setVPos(this.height - 1);
        human.setHPos(random.nextInt(this.length));
        gameGrid[human.getVPos()][human.getHPos()] = human.toString().charAt(0);
    }

    //Moves human to a different position
    public void moveHuman(char input) {
        String message = TEXT_RED + "There is no escape!" + TEXT_RESET;
        switch (input) {
            case 'w':
                if (human.getVPos() == 0) {
                    System.out.println(message);
                } else {
                    gameGrid[human.getVPos()][human.getHPos()] = '-';
                    human.setVPos(human.getVPos() - 1);
                    gameGrid[human.getVPos()][human.getHPos()] = human;
                }
                break;
            case 'a':
                if (human.getHPos() == 0) {
                    System.out.println(message);
                }
                else {
                    gameGrid[human.getVPos()][human.getHPos()] = '-';
                    human.setHPos(human.getHPos() - 1);
                    gameGrid[human.getVPos()][human.getHPos()] = human;
                }
                break;
            case 's':
                if (human.getVPos() == this.height - 1) {
                    System.out.println(message);
                }
                else {
                    gameGrid[human.getVPos()][human.getHPos()] = '-';
                    human.setVPos(human.getVPos() + 1);
                    gameGrid[human.getVPos()][human.getHPos()] = human;
                }
                break;
            case 'd':
                if (human.getHPos() == this.length - 1) {
                    System.out.println(message);
                }
                else {
                    gameGrid[human.getVPos()][human.getHPos()] = '-';
                    human.setHPos(human.getHPos() + 1);
                    gameGrid[human.getVPos()][human.getHPos()] = human;
                }
                break;
            default:
                System.out.println("Invalid input please try again");
        }
    }

    public void spawnGoblin() {

    }



    @Override
    public String toString() {
        StringBuilder landStr = new StringBuilder();

        for (Object[] objects : gameGrid) {
            landStr.append(LEFT_MARGIN);
            for (Object object : objects) {
                landStr.append(object);
            }
            landStr.append("\n");
        }
        return landStr.toString();
    }


}
