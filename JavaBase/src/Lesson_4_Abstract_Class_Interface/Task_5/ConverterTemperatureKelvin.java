package Lesson_4_Abstract_Class_Interface.Task_5;

class ConverterTemperatureKelvin extends ConverterTemperature {
    @Override
    void convert(double t) {
        System.out.println("Конвертація в Кельвіни: " + (t + 273.15));
    }
}
