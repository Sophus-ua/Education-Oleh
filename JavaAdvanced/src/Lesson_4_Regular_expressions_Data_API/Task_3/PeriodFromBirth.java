package Lesson_4_Regular_expressions_Data_API.Task_3;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

class PeriodFromBirth {
    LocalDate currentDate, birthDate;
    PeriodFromBirth() {
        currentDate = LocalDate.now();
        birthDate = this.fillingDateOfBirth();
    }
    private LocalDate fillingDateOfBirth() {
        Scanner in = new Scanner(System.in);
        int year = 0;
        int month = 0;
        int day = 0;

        for (int i = 1; i < 4; i++) {
            boolean replay = true;
            while (replay) {
                try {
                    if (i == 1) {
                        System.out.println("Введіть рік народження:");
                        year = in.nextInt();
                        int yearCheck = currentDate.getYear() - year;
                        if (yearCheck < 0 || 120 < yearCheck) throw new Exception();
                        replay = false;
                    } else if (i == 2) {
                        System.out.println("Введіть місяць народження порядковим числом:");
                        month = in.nextInt();
                        if (month < 1 || 12 < month) throw new Exception();
                        replay = false;
                    } else {
                        System.out.println("Введіть день народження:");
                        day = in.nextInt();
                        if (day < 1 || 31 < day) throw new Exception();
                        replay = false;
                    }
                } catch (Exception e) {
                    System.err.println("Упсс, Ви ввели невірні данні, спробуйте ще раз:");
                    in.nextLine();
                }
            }
        }
        in.close();
        return LocalDate.of(year, month, day);
    }
    void periodFromBirthShow() {
        LocalTime timeNow = LocalTime.now();
        LocalTime birthTime = LocalTime.of(0, 0, 0);

        Period periodFromBirth = Period.between(birthDate, currentDate);
        Duration durationFromBirth = Duration.between(birthTime, timeNow);

        System.out.printf("Вам виповнилось %d роки(ів), %d місяці(в), %d дні(в), %d годин(и), %d хвилин(и), %d секунд(и)\n", periodFromBirth.getYears(),
                periodFromBirth.getMonths(), periodFromBirth.getDays(), durationFromBirth.toHoursPart(), durationFromBirth.toMinutesPart(), durationFromBirth.toSecondsPart());
    }
}
