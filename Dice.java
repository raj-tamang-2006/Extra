import java.util.*;

public class Dice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("How many times do you wanna roll a dice?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(1, 7);
            System.out.println("In the Roll "+(i+1));
            image(value);
        }

        sc.close();
    }

    public static void image(int a) {
        switch (a) {
            case 1 -> System.out.println("""
                _____________
                |           |
                |     O     |
                |           |
                _____________
                """);

            case 2 -> System.out.println("""
                _____________
                |           |
                |  O     O  |
                |           |
                _____________
                """);

            case 3 -> System.out.println("""
                _____________
                |           |
                | O   O   O |
                |           |
                _____________
                """);

            case 4 -> System.out.println("""
                _____________
                | O       O |
                |           |
                | O       O |
                _____________
                """);

            case 5 -> System.out.println("""
                _____________
                | O       O |
                |     O     |
                | O       O |
                _____________
                """);

            case 6 -> System.out.println("""
                _____________
                | O       O |
                | O       O |
                | O       O |
                _____________
                """);
        }
    }
}


/*
Output

How many times do you wanna roll a dice?
3
In the Roll 1
_____________
| O       O |
|     O     |
| O       O |
_____________

In the Roll 2
_____________
|           |
|  O     O  |
|           |
_____________

In the Roll 3
_____________
|           |
| O   O   O |
|           |
_____________

*/