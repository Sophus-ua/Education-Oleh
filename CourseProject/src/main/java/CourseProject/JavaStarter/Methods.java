package CourseProject.JavaStarter;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class Methods {

    /* завдання №1 */
    int getSumDigitsOfNumber(int number) {
        return Stream.iterate(number, n -> n / 10)
                .limit(Integer.toString(number).length())
                .map(n -> n % 10)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /* завдання №2 */
    int getNumberInReverseOrder(int num) {
        int number = num;
        int reverseNumber = 0;

        while (number != 0) {
            reverseNumber *= 10;
            reverseNumber += (number % 10);
            number /= 10;
        }

        return reverseNumber;
    }

    /* завдання №3 */
    int numberOfTheName(String name) {
        Map<Character, Integer> valueOfLetters = new HashMap<>();
        int i = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            i++;
            valueOfLetters.put(letter, i);
        }

        int numberOfTheName = 0;
        char[] charName = name.toLowerCase().toCharArray();
        for (char letter : charName) {
            if(valueOfLetters.containsKey(letter))
                numberOfTheName += valueOfLetters.get(letter);
        }

        return numberOfTheName;
    }

    /* завдання №4 */
    int getSumDigitsOfDate (LocalDate date){
        int sum = 0;
        sum += getSumDigitsOfNumber(date.getYear());
        sum += getSumDigitsOfNumber(date.getMonthValue());
        sum += getSumDigitsOfNumber(date.getDayOfMonth());

        return sum;
    }
}
