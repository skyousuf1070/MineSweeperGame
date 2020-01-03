public class Grid {
    private int gridSize;
    private String[][] squares;
    int count = 0;

    public Grid(String[][] mineFields) {
        gridSize = mineFields.length;
        squares = new String[gridSize][gridSize];
        for (int gridRowIndex = 0;gridRowIndex<gridSize; gridRowIndex++) {
            for (int gridColumnIndex = 0; gridColumnIndex<gridSize; gridColumnIndex++) {
                squares[gridRowIndex][gridColumnIndex] = "X";
            }
        }
    }

    public boolean isValid(int row, int column) {
        final int GRID_LOWER_LIMIT = 0;
        final int GRID_UPPER_LIMIT = gridSize;
        boolean isRowColumnOutOfGridRange = row < GRID_LOWER_LIMIT || row >= GRID_UPPER_LIMIT || column < GRID_LOWER_LIMIT || column >= GRID_UPPER_LIMIT;
        boolean isCellFilled = squares[row][column].equalsIgnoreCase("O");
        if (isRowColumnOutOfGridRange) {
            System.out.println("Invalid Locations");
            return false;
        } else if (isCellFilled) {
            System.out.println("Current location is already occupied");
            return false;
        }
        return true;
    }

    public boolean isSet(int row, int column, String action) {
//        "O" stands for open the square(row,column)
//        "f" stands for flag the square(row,column)
        if (isValid(row, column)) {
            if (action.equalsIgnoreCase("o")) {
                squares[row][column] = "O";
            } else if (action.equalsIgnoreCase("f")) {
                squares[row][column] = "f";
            } else {
                System.out.println("Invalid Action!");
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isGameCompleted(String[][] actualGrid){
        boolean allOpenedExceptMinedCell = true;
        boolean isMinedCellOpened = false;
        for (int gridRowIndex = 0; gridRowIndex < gridSize; gridRowIndex++) {
            for (int gridColumnIndex = 0; gridColumnIndex < gridSize; gridColumnIndex++) {
                isMinedCellOpened = actualGrid[gridRowIndex][gridColumnIndex].equalsIgnoreCase("m") &&
                                    squares[gridRowIndex][gridColumnIndex].equalsIgnoreCase("o");
                if (isMinedCellOpened) {
                    System.out.println("Oops! you stepped on a mine! Game over!");
                    return true;
                }
                if (squares[gridRowIndex][gridColumnIndex].equalsIgnoreCase("x") ||
                        (squares[gridRowIndex][gridColumnIndex].equalsIgnoreCase("f") &&
                                actualGrid[gridRowIndex][gridColumnIndex].equalsIgnoreCase("x"))) {
                    allOpenedExceptMinedCell = false;
                }
            }
        }
        if (allOpenedExceptMinedCell && !isMinedCellOpened) {
            System.out.println("Wow, you cleared the minefield! Game over!");
            return true;
        }
        return false;
    }
    public void display() {
        for (int gridRowIndex = 0; gridRowIndex < gridSize; gridRowIndex++) {
            for (int gridColumnIndex = 0; gridColumnIndex < gridSize; gridColumnIndex++) {
                System.out.print(squares[gridRowIndex][gridColumnIndex] + " ");
            }
            System.out.println();
        }
    }
}