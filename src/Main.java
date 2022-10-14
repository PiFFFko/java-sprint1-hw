import java.util.Scanner;

public class Main {

    private static final String ENTER_STEPS_FOR_DAY_MSG_MESSAGE = "1. Ввести количество шагов за определенный день";
    private static final String PRINT_STATISTICS_FOR_MONTH_MESSAGE = "2. Вывести статистику за месяц";
    private static final String CHANGE_STEP_GOAL_MESSAGE = "3. Изменить цель по количеству шагов за день";
    private static final String EXIT_MESSAGE = "4. Выход";
    private static final String ASK_COMMAND_MESSAGE = "Введите необходимую команду";
    private static final String NO_SUCH_COMMAND_MESSAGE = "Такой команды не существует";
        public static void main(String[] args) {
        int command = 0;
        while (true) {
            printMenu();
            command = askCommand();
            switch (command){
                case (1):

                    break;
                case (2):

                    break;
                case (3):

                    break;
                case (4):
                    return;
                default:
                    System.out.println(NO_SUCH_COMMAND_MESSAGE);
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println(ENTER_STEPS_FOR_DAY_MSG_MESSAGE);
        System.out.println(PRINT_STATISTICS_FOR_MONTH_MESSAGE);
        System.out.println(CHANGE_STEP_GOAL_MESSAGE);
        System.out.println(EXIT_MESSAGE);
    }

    private static int askCommand(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASK_COMMAND_MESSAGE);
        int command = scanner.nextInt();
        return command;
    }

}
