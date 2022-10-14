public class Validator {


    public boolean validateDay(int day) {
        return (day >= 1 & day <= 30);
    }

    public boolean validateMonth(int month){
        return (month >= 1 & month <= 12);
    }

    public boolean validateSteps(int steps){
        return steps>=0;
    }

}
