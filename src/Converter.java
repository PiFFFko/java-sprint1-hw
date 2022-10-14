public class Converter {

    //1 шаг = 75 см
    double stepsToKilometersRate = 0.00075;
    //1 шаг = 50 калорий, 1 калория = 1000 килокалорий
    double stepsToKilocalorieRate = 0.05;

    public double convertStepsToKilometers(int steps) {
        return steps * stepsToKilometersRate;
    }

    public double convertStepsToCalorie(int steps) {
        return steps * stepsToKilocalorieRate;
    }

}
