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

    //Gives Human a position in the game grid
    public void spawnHuman() {
        human.setVPos(this.height - 1);
        human.setHPos(random.nextInt(this.length));
        gameGrid[human.getVPos()][human.getHPos()] = human;
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

    //Creates a goblin and gives a position on game grid
    public void spawnGoblins() {
        Goblin goblin = new Goblin();
        goblin.setVPos(0);
        goblin.setHPos(random.nextInt(this.length));
        goblins.add(goblin);
        for(Goblin g : goblins) {
            gameGrid[g.getVPos()][g.getHPos()] = g;
        }
    }

    public void moveGoblins() {
        for (Goblin goblin : goblins) {
            int move = random.nextInt(4);
            //Current position of this goblin changed to - (Dash)
            gameGrid[goblin.getVPos()][goblin.getHPos()] = '-';
            //Setting the new position of Goblin
            switch (move) {
                case 0:
                    if (goblin.getVPos() == 0) {
                        break;
                    } else {
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = '-';
                        goblin.setVPos(goblin.getVPos() - 1);
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = goblin;
                    }
                    break;
                case 1:
                    if (goblin.getHPos() == 0) {
                        break;
                    }
                    else {
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = '-';
                        goblin.setHPos(goblin.getHPos() - 1);
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = goblin;
                    }
                    break;
                case 2:
                    if (goblin.getVPos() == this.height - 1) {
                        break;
                    }
                    else {
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = '-';
                        goblin.setVPos(goblin.getVPos() + 1);
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = goblin;
                    }
                    break;
                case 3:
                    if (goblin.getHPos() == this.length - 1) {
                        break;
                    }
                    else {
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = '-';
                        goblin.setHPos(goblin.getHPos() + 1);
                        gameGrid[goblin.getVPos()][goblin.getHPos()] = goblin;
                    }
                    break;
            }
        }
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
