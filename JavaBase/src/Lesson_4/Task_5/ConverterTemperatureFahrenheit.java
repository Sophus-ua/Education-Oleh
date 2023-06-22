package Lesson_4.Task_5;

class ConverterTemperatureFahrenheit extends ConverterTemperature {
    @Override
    void convert(double t) {
        System.out.println("Конвертація в Фаренгейт: " + (t * 1.8 + 32.0));
    }
}
