import java.util.LinkedList;
import java.util.Queue;

public class GraphicMapXO {
    int poleSize = 3;

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

    private Queue<String> queueForMap(Figures[][] mapArray) {
        Queue<String> queue = new LinkedList<>();

        String[][] plotArray = new String[poleSize][poleSize];

        int count = 1;
        for (int i = 0; i < poleSize; i++) {
            for (int j = 0; j < poleSize; j++) {
                String strCount = Integer.toString(count);
                plotArray[i][j] = strCount;
                count++;
            }
        }

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

    private void printGameLine(Queue<String> q) {
        String[] array = new String[poleSize * 2 - 1];
        String s = " | ";
        for (int i = 1; i < poleSize * 2 - 1; i = i + 2) {
            array[i] = s;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = q.poll();
            }
            System.out.print(array[i]);
        }

        System.out.println();
    }
}
