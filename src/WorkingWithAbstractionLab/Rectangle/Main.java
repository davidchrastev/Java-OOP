package WorkingWithAbstractionLab.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        //създаваме две точки с получените кординати
        Point bottomLeft = new Point(bottomLeftX,bottomLeftY);
        Point topRight = new Point(topRightX,topRightY);
        //създаваме си правоъгълник
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int countPoints = Integer.parseInt(scanner.nextLine());

        for (int pointCount = 0; pointCount < countPoints; pointCount++) {
            int[] checkCoordinates = Arrays.stream
                            (scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            //четем кординати ,които трябва да проверим
            int x = checkCoordinates[0];
            int y = checkCoordinates[1];
            //създаваме точката ,която трябва да проверим
            Point toCheck = new Point(x,y);
            //проверяваме дали е вътре и принтираме съответно
            //true или false
            if (rectangle.contains(toCheck)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        }

    }
}
