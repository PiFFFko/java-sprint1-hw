public class Validator {


    public boolean validateDay(int day) {
        return (day >= 1 & day <= Main.amountDays);
    }

    public boolean validateMonth(int month) {
        return (month >= 1 & month <= Main.amountMonth);
    }

    public boolean validateSteps(int steps) {
        return steps >= 0;
    }

}
