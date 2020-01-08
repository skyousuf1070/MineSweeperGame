import java.util.Scanner;

public class MineSweeperGame {
    private Grid playerGrid;
    private Player player;

    public MineSweeperGame(int size) {
        playerGrid = new Grid(size);
        player = new Player("Tony");
    }

    public void launchGame(String[] mineFields) {
        int size = mineFields.length;
        String[][] actualGrid = new String[size][size];
        for (int gridRowIndex = 0; gridRowIndex < mineFields.length; gridRowIndex++) {
            for (int gridColumnIndex = 0; gridColumnIndex < mineFields.length; gridColumnIndex++) {
                actualGrid[gridRowIndex][gridColumnIndex] = String.valueOf(mineFields[gridRowIndex].charAt(gridColumnIndex));
            }
        }
        while (!playerGrid.isGameCompleted(actualGrid)) {
            player.play(playerGrid);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minefield layout: ");
        String mineFieldLayout = scanner.nextLine();
        String[] mineFields = mineFieldLayout.split(",");
        new MineSweeperGame(mineFields.length).launchGame(mineFields);
    }
}
