public class Validator {


    public boolean validateDay(int day) {
        return (day >= 1 & day <= Main.AMOUNT_DAYS);
    }

    public boolean validateMonth(int month) {
        return (month >= 1 & month <= Main.AMOUNT_MONTH);
    }

    public boolean validateSteps(int steps) {
        return steps >= 0;
    }

}
