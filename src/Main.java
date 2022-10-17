import java.util.Scanner;

public class Main {

    private static final String ENTER_STEPS_FOR_DAY_MSG_MESSAGE = "1. Ввести количество шагов за определенный день";
    private static final String PRINT_STATISTICS_FOR_MONTH_MESSAGE = "2. Вывести статистику за месяц";
    private static final String CHANGE_STEP_GOAL_MESSAGE = "3. Изменить цель по количеству шагов за день";
    private static final String EXIT_MESSAGE = "4. Выход";
    private static final String ASK_COMMAND_MESSAGE = "Введите необходимую команду";
    private static final String NO_SUCH_COMMAND_MESSAGE = "Такой команды не существует";
    private static final String SET_STEP_GOAL_MESSAGE = "Введите необходимую цель по количеству шагов. Значение цели " +
            "должно быть положительным";
    private static final String CURRENT_STEP_GOAL_MESSAGE = "Ваша текущая цель по шагам ";
    private static final String ENTER_MONTH_MESSAGE = "Введите необходимый номер месяца от 1 до 12";
    private static final String ENTER_DAY_MESSAGE = "Введите номер дня от 1 до 30";
    private static final String ENTER_STEPS_MESSAGE = "Введите количество шагов за день. Кол-во шагов должно быть " +
            "положительным";
    private static final int ENTER_STEPS_FOR_DAY_COMMAND = 1;
    private static final int PRINT_STATISTICS_FOR_MONTH_COMMAND = 2;
    private static final int CHANGE_STEP_GOAL_COMMAND = 3;
    private static final int EXIT_COMMAND = 4;

    private static final String DATA_LINE_PATTERN = "%s день:%s";
    private static final String TOTAL_STEPS_LINE_PATTERN = "Общее количество шагов за %s-й месяц - %s";
    private static final String MAX_STEPS_LINE_PATTERN = "Максимальное количество шагов за %s-й месяц - %s";
    private static final String AVG_STEPS_LINE_PATTERN = "Среднее количество шазгов за %s-й месяц - %s";
    private static final String DISTANCE_LINE_PATTERN = "Пройденная дистанция за %s-й месяц в км - %.2f";
    private static final String BURNED_CALORIE_LINE_PATTERN = "Сожжено килокалорий за %s-й месяц - %.2f";
    private static final String BEST_SERIES_LINE_PATTERN = "Лучшая серия за %s-й месяц - %s";
    private static StepTracker stepTracker = new StepTracker();
    static Scanner scanner = new Scanner(System.in);
    static Validator validator = new Validator();
    static Converter converter = new Converter();
    public static final int AMOUNT_DAYS = 30;
    public static final int AMOUNT_MONTH = 12;

    public static void main(String[] args) {
        int command = 0;
        while (command != EXIT_COMMAND) {
            printMenu();
            command = askCommand();
            detectCommand(command);
        }
    }

    private static void printMenu() {
        System.out.println(ENTER_STEPS_FOR_DAY_MSG_MESSAGE);
        System.out.println(PRINT_STATISTICS_FOR_MONTH_MESSAGE);
        System.out.println(CHANGE_STEP_GOAL_MESSAGE);
        System.out.println(EXIT_MESSAGE);
    }

    private static int askCommand() {
        System.out.println(ASK_COMMAND_MESSAGE);
        int command = scanner.nextInt();
        return command;
    }

    private static void detectCommand(int command) {
        switch (command) {
            case (ENTER_STEPS_FOR_DAY_COMMAND): //Ввести количество шагов за определённый день;
                enterStepsForDay();
                break;
            case (PRINT_STATISTICS_FOR_MONTH_COMMAND): //Напечатать статистику за определённый месяц;
                printStatisticsForMonth();
                break;
            case (CHANGE_STEP_GOAL_COMMAND): //Изменить цель по количеству шагов в день;
                changeStepGoal();
                break;
            case (EXIT_COMMAND):
                break;
            default:
                System.out.println(NO_SUCH_COMMAND_MESSAGE); //Команды не существует
                break;
        }
    }


    //запрашивает у пользователя номер месяца до тех пор, пока не пройдет валидацию
    //Номер месяца от 1 до 12
    public static int askMonth() {
        int month = -1;
        while (!validator.validateMonth(month)) {
            System.out.println(ENTER_MONTH_MESSAGE);
            month = scanner.nextInt();
        }
        return month - 1;
    }

    //запрашивает у пользователя номер дня до тех пор, пока не пройдет валидацию
    //Номер дня от 1 до 30
    public static int askDay() {
        int day = -1;
        while (!validator.validateDay(day)) {
            System.out.println(ENTER_DAY_MESSAGE);
            day = scanner.nextInt();
        }
        return day - 1;
    }

    //askSteps() - запращивать у пользователя кол-во шагов до тех пор, пока не пройдет валидацию
    //количество шагов должно быть неотрицательным
    public static int askSteps() {
        int steps = -1;
        while (!validator.validateSteps(steps)) {
            System.out.println(ENTER_STEPS_MESSAGE);
            steps = scanner.nextInt();
        }
        return steps;
    }

    public static void changeStepGoal() {
        System.out.println(CURRENT_STEP_GOAL_MESSAGE + stepTracker.getStepGoal());
        int goalValue = -1;
        while (!validator.validateSteps(goalValue)) {
            System.out.println(SET_STEP_GOAL_MESSAGE);
            goalValue = scanner.nextInt();
        }
        stepTracker.setStepGoal(goalValue);

    }

    public static void printStatisticsForMonth() {
        int month = askMonth();
        int[] stats = stepTracker.getMonthStats(month);
        int totalSteps = stepTracker.getTotalStepsPerMonth(month);
        int maxSteps = stepTracker.getMaxStepsInMonth(month);
        int avgSteps = stepTracker.getAvgStepsInMonth(month);
        double kilometers = converter.convertStepsToKilometers(totalSteps);
        double burnedKilocalorie = converter.convertStepsToCalorie(totalSteps);
        int bestSeries = stepTracker.getBestSeries(month);
        month++;
        for (int i = 0; i < AMOUNT_DAYS; i++) {
            System.out.print(String.format(DATA_LINE_PATTERN, i + 1, stats[i]));
                if (i<(AMOUNT_DAYS-1)){
                    System.out.print(", ");
                }
        }
        System.out.println();
        System.out.println(String.format(TOTAL_STEPS_LINE_PATTERN, month, totalSteps));
        System.out.println(String.format(MAX_STEPS_LINE_PATTERN, month, maxSteps));
        System.out.println(String.format(AVG_STEPS_LINE_PATTERN, month, avgSteps));
        System.out.println(String.format(DISTANCE_LINE_PATTERN, month, kilometers));
        System.out.println(String.format(BURNED_CALORIE_LINE_PATTERN, month, burnedKilocalorie));
        System.out.println(String.format(BEST_SERIES_LINE_PATTERN, month, bestSeries));
    }

    public static void enterStepsForDay() {
        int month = askMonth();
        int day = askDay();
        int steps = askSteps();
        stepTracker.addDayStats(month, day, steps);
    }

}