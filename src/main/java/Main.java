import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random(LocalDateTime.now().getSecond());

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем прогу");
        logger.log("Просим пользователя ввести входные данные для списка");
        int listSize = getNumber("Введите размер списка: ");
        int topValue = getNumber("Введите верхнюю границу для значений:");
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int threshold = getNumber("Введите порог для фильтра:");
        logger.log("Запускаем фильтрацию");
        List<Integer> numList = generateList(listSize, topValue);
        Filter filter = new Filter(threshold);
        List<Integer> filteredList = filter.filterOut(numList);
        printResult(filteredList);
    }

    private static void printResult(List<Integer> filteredList) {
        Logger.getInstance().log("Выводим результат на экран");
        System.out.println("Отфильтрованный список:");
        System.out.println(filteredList);
    }

    private static List<Integer> generateList(int listSize, int topValue) {
        List<Integer> numList = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            numList.add(rand.nextInt(topValue));
        }
        return numList;
    }

    private static int getNumber(String question){
        while (true) {
            System.out.println(question);
            try {
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num <= 0) {
                    System.out.println("should be > 0");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println("smth went wrong");
                continue;
            }
        }
    }
}
