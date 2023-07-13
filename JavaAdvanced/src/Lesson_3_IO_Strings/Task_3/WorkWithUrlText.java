package Lesson_3_IO_Strings.Task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class WorkWithUrlText {
    String recordingTextFromSite(String url, String startText, String finishText){
        StringBuilder paragraph = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader bufRd =  new BufferedReader((new InputStreamReader(connection.getInputStream())));
            String receivedText;
            while ((receivedText = bufRd.readLine()) != null){
                if(receivedText.contains(startText)){
                    receivedText = receivedText.replaceAll("<[^>]+>", "");
                    paragraph.append(receivedText);
                }
                if(receivedText.contains(finishText))break;
            }
            bufRd.close();
            connection.disconnect();
        } catch(IOException eIO){
            System.err.println("Помилка зчитування з сайту " + eIO.getMessage());
        }
        return paragraph.toString();
    }
    String[] textSeparation (String text){
        String[] separatedText = new String[2];
        int middleIndex = text.length() /2;
        separatedText[0] = text.substring(0,middleIndex) + "...";
        separatedText[1] = "..." + text.substring(middleIndex);
        return separatedText;
    }
    void displayingSentences (String text){
        String[] sentences = text.split("(?<!\\.)\\.(?!\\.)");
        for (String temp : sentences){
            System.out.println(temp.trim());
        }
    }
}
