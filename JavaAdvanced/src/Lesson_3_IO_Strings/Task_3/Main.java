package Lesson_3_IO_Strings.Task_3;

class Main {

    public static void main(String[] args) {
        WorkWithUrlText example = new WorkWithUrlText();

        String url = "http://loveread.me/read_book.php?id=12167&p=6" ;
        String startText = "Скорее всего, она будет жить" ;
        String finishText = "Я ведь переезжаю обратно в наш дом." ;

        String paragraph = example.recordingTextFromSite(url,startText,finishText);
        String[] textForWork = example.textSeparation(paragraph);

        System.out.println("\033[1;35mПерша половина тексту:\033[0m");
        example.displayingSentences(textForWork[0]);
        System.out.println("\n\033[1;35mДруга половина тексту:\033[0m");
        example.displayingSentences(textForWork[1]);
    }
}
