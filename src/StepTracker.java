public class StepTracker {

    MonthData[] monthData;
    private int stepGoal = 10000;

    public StepTracker() {
        monthData = new MonthData[Main.AMOUNT_MONTH];
        for (int i = 0; i < Main.AMOUNT_MONTH; i++)
            monthData[i] = new MonthData();
    }

    public void setStepGoal(int stepGoal) {
        this.stepGoal = stepGoal;
    }

    public int getStepGoal() {
        return this.stepGoal;
    }

    public void addDayStats(int month, int day, int steps) {
        monthData[month].setStepPerDay(day, steps);
    }

    public int getTotalStepsPerMonth(int month) {
        int steps = 0;
        for (int i = 0; i < Main.AMOUNT_DAYS; i++) {
            steps += monthData[month].getStepPerDay(i);
        }
        return steps;
    }

    public int getMaxStepsInMonth(int month) {
        int maxSteps = 0;
        int steps = 0;
        for (int i = 0; i < Main.AMOUNT_DAYS; i++) {
            steps = monthData[month].getStepPerDay(i);
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    public int getAvgStepsInMonth(int month) {
        int steps = getTotalStepsPerMonth(month);
        int avgSteps = Math.round(steps / Main.AMOUNT_DAYS);
        return avgSteps;
    }


    public int getBestSeries(int month) {
        int bestSeries = 0;
        int curBestSeries = 0;
        int steps;
        for (int i = 0; i < Main.AMOUNT_DAYS; i++) {
            steps = monthData[month].getStepPerDay(i);
            //Если количество шагов превосходит цель, то увеличиваем значение текущей серии и
            //проверяем больше ли она лучшей серии. Если количество шагов меньше, то сбиваем серию
            if (steps >= stepGoal) {
                curBestSeries++;
                if (curBestSeries >= bestSeries) {
                    bestSeries = curBestSeries;
                }
            } else {
                curBestSeries = 0;
            }
        }
        return bestSeries;
    }


    public int[] getMonthStats(int month) {
        return monthData[month].stepsPerDay;
    }


}
