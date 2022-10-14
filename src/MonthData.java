import java.util.Random;

public class MonthData {
    int[] stepsPerDay;


    public MonthData() {
        stepsPerDay = new int[30];
    }

    public int getStepPerDay(int day) {
        return stepsPerDay[day];
    }

    public void setStepPerDay(int day, int steps) {
        stepsPerDay[day] = steps;
    }

}
