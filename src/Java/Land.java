import java.util.ArrayList;
import java.util.Arrays;

public class Land {

    char[][] gameGrid;
    ArrayList<Goblin> goblins = new ArrayList<>();
    Human human = new Human();

    Land(int length, int height) {
        gameGrid = new char[height][length];

        for (char[] row : gameGrid) {
            Arrays.fill(row, '*');
        }
    }

    @Override
    public String toString() {
        StringBuilder landStr = new StringBuilder();
        for (char[] chars : gameGrid) {
            for (char aChar : chars) {
                landStr.append(aChar);
            }
            landStr.append("\n");
        }
        return landStr.toString();
    }


}
