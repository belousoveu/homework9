import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        task123();
        task4();

    }

    private static void task123() {
        final int MIN_SALARY = 50_000;
        final int MAX_SALARY = 100_000;
        int[] salary = new int[5];
        int totalSalary = 0;
        Arrays.parallelSetAll(salary, i -> new Random().nextInt(MAX_SALARY - MIN_SALARY + 1) + MIN_SALARY);
        //Справочно. Вывод на экран исходного массива
        System.out.println("Исходный массив заполненный случайным образом целыми числами в диапазоне от 50 000 до 100 000");
        System.out.println(Arrays.toString(salary) + "\n");

        // task1
        for (int i = 0; i < salary.length; totalSalary += salary[i], i++) ;
        System.out.printf("Общая сумма заработной платы за месяц составила %,d рублей.\n", totalSalary);

        // task2
        System.out.printf("Минимальная сумма трат за неделю составила %,d рублей.\n",
                Arrays.stream(salary).min().getAsInt());
        System.out.printf("Максимальная сумма трат за неделю составила %,d рублей.\n",
                Arrays.stream(salary).max().getAsInt());

        //task3
        System.out.printf("Средняя сумма трат за неделю составила %,.2f рублей\n",
                (double) totalSalary / salary.length);
    }

    private static void task4() {
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        StringBuilder resultString= new StringBuilder();

        System.out.println();

        // вывод на экран правильного написания без изменения исходного массива
        for (char symbol:reverseFullName) {
            resultString.insert(0, symbol);
        }
        System.out.println("Вывод результата без изменения исходного массива");
        System.out.println(resultString);

        //Переворачивание массива
        char tempChar;
        for (int i=0; i<= reverseFullName.length/2; i++) {
            tempChar=reverseFullName[i];
            reverseFullName[i]=reverseFullName[reverseFullName.length-i-1];
            reverseFullName[reverseFullName.length-i-1]=tempChar;
        }
        System.out.println("Вывод результата с предварительным \"переворачиванием\" массива");
        System.out.println(new String(reverseFullName));
    }
}