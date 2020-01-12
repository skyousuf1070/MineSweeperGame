import java.util.Scanner;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Yousuf";
    }

    public String play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter option: ");
//        option will something which looks like this o(row,column) or f(row,column)
        String option = scanner.nextLine();
        return option;
    }
}
