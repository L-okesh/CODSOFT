import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class Quizbhaiquizz {

    public static void main(String[] args) {
        String[] questions = {
                "1. In which year did India win their 2nd Champions Trophy?: ",
                "2. Who was the winner of the first ICC T20 World Cup?: ",
                "3. Who holds the record for the highest individual score in ODI cricket?: ",
                "4. Which cricket team has won the ICC World Cup the most times?",
                "5. Can RCB ever win the IPL?"
        };

        String[][] options = {
                {"A. 2011", "B. 2004", "C. 2006", "D. 2013"},
                {"A. England", "B. India", "C. Australia", "D. New Zealand"},
                {"A. Rohit Sharma", "B. Virat Kohli", "C. Ricky Ponting", "D. AB de Villiers"},
                {"A. England", "B. Australia", "C. India", "D. West Indies"},
                {"A. EE sala cup namde ", "B. Agle sala cup namde ", "C. bowling toh theek krlein pehle", "D. meko kya bro, mai toh CSK vala hu"}
        };

        char[] answers = {'D', 'B', 'A', 'B','D'};

        int size = questions.length;
        char guess = ' ';
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            System.out.println("***************$$$$$$$$$$$$*************");
            System.out.println(questions[i]);
            System.out.println("***************$$$$$$$$$$$$*************");

            for (String option : options[i]) {
                System.out.println(option);
            }

            AtomicBoolean answered = new AtomicBoolean(false);
            final int questionindex = i;
            Timer time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered.get()) {
                        System.out.println("\nTime's up!");
                        System.out.println("Correct Answer: " + answers[questionindex]);
                        answered.set(true);
                    }
                }
            }, 10000);

            String input = scanner.nextLine();
            if (!input.isEmpty() && !answered.get()) {
                guess = Character.toUpperCase(input.charAt(0));
                answered.set(true);
                time.cancel();

                if (guess == answers[questionindex]) {
                    System.out.println("<<<<<<< CORRECT >>>>>>>");
                    score++;
                } else {
                    System.out.println("<<<<<<< WRONG! >>>>>>>");
                    System.out.println("Correct Answer: " + answers[questionindex]);
                }
            } else if (!answered.get()) {
                time.cancel();
                System.out.println("No input detected. Moving to the next question.");
                System.out.println("Correct Answer: " + answers[questionindex]);
            }
        }

        System.out.println("***************10 karooddd!!!!****************");
        System.out.println("*      <<<<<     RESULTS    >>>>>       *");
        System.out.println("***************10 karooddd!!!!****************");
        System.out.println("CORRECT GUESSES: " + score);
        System.out.println("# of QUESTIONS: " + size);
        System.out.println("SCORE: " + ((score / (double) size) * 100) + "%");

        scanner.close();
    }
}