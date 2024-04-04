import java.util.LinkedList;
import java.util.Queue;

public class MapXO {
    public void printMap(Figures[][] mapArray) {

        Queue<String> queue = queueForMap(mapArray);

        System.out.println();
        System.out.println("= = = = =");
        System.out.println();
        printGameLine(queue);
        System.out.println("- + - + -");
        printGameLine(queue);
        System.out.println("- + - + -");
        printGameLine(queue);
        System.out.println();
        System.out.println("= = = = =");
        System.out.println();
    }

    private static Queue<String> queueForMap(Figures[][] mapArray) {
        Queue<String> queue = new LinkedList<>();

        String[][] plotArray = {{"1", "2", "3"},{"4", "5", "6"},{"7", "8", "9"}};

        for (int i = 0; i < mapArray[0].length; i++) {
            for (int j = 0; j < mapArray.length; j++) {
                if (mapArray[i][j] == null) {
                    queue.add(plotArray[i][j]);
                } else if (mapArray[i][j] == Figures.CROSS) {
                    queue.add("X");
                } else {
                    queue.add("O");
                }
            }
        }
        return queue;
    }

    private static void printGameLine(Queue<String> q) {
        String[] array = new String[5];
        String s = " | ";
        array[1] = s;
        array[3] = s;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = q.poll();
            }
            System.out.print(array[i]);
        }

        System.out.println();
    }
}
