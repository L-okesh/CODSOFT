import java.util.*;

public class studentgradecal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, i;
        float[] marks;
        float percent = 0, total = 0;

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        marks = new float[n];

        System.out.print("Please enter marks of " + n + " subjects out of 100 : ");
        for (i = 0; i < n; i++) {
            marks[i] = sc.nextFloat();
        }

        for (i = 0; i < n; i++) {
            total += marks[i];
        }
        System.out.println("***** Total markks is: " +total+ " ***** ");
        percent = total / n;
        System.out.println("***** Percentage: " + percent + " % *****");
        System.out.println("******* Grade according to the marks is : *******");
        if (percent > 85) {
            System.out.println("A grade");
        } else if (percent < 85 && percent >= 75) {
            System.out.println("B grade");
        } else if (percent < 75 && percent >= 50) {
            System.out.println("C grade");
        } else if (percent  < 50 && percent >= 30) {
            System.out.println("D grade");
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}
