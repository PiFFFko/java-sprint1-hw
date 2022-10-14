import java.util.Random;

public class MonthData {
    int[] stepsPerDay;


    public MonthData() {
        Random random = new Random();
        stepsPerDay = new int[30];
        for (int i = 0; i < 30; i++){
            stepsPerDay[i] = random.nextInt(15000);
        }
    }

    public int getStepPerDay(int day) {
        return stepsPerDay[day];
    }

}
