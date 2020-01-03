import java.util.Scanner;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Yousuf";
    }

    public void play(Grid grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter option: ");
//        option will something which looks like this o(row,column) or f(row,column)
        String option = scanner.nextLine();
        String action = String.valueOf(option.charAt(0));
        int row = Integer.parseInt(String.valueOf(option.charAt(2)));
        int column = Integer.parseInt(String.valueOf(option.charAt(4)));
        if (!grid.isSet(row,column,action)) {
            System.out.println("OOPS! action undone!");
        } else {
            grid.display();
        }
    }
}
