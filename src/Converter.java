public class Converter {

    double stepsToKilometersRate = 0.00075;
    double stepsToCalorieRate = 0.05;

    public double convertStepsToKilometers(int steps){
        return steps*stepsToKilometersRate;
    }

    public double convertStepsToCalorie(int steps){
        return steps*stepsToCalorieRate;
    }

}
