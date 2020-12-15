import jdk.internal.util.xml.impl.Input;

import java.awt.event.InputEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----AutoClicker by Drumev----");

            System.out.println("Enter the number of desired clicks: ");
            int clicks = scanner.nextInt();

            System.out.println("Enter delay between clicks in milliseconds: ");
            int delay = scanner.nextInt();
            System.out.println();

            System.out.println("Program will start in 3 seconds.");

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            AutoClicker clicker = new AutoClicker();
            clicker.setDelay(delay);

            for (int i = 0; i < clicks; i++) {
                clicker.clickMouse(InputEvent.BUTTON1_MASK);
            }
            System.out.println("AutoClicker complete.");
            System.out.println();
            System.out.println("Do you want to use it again?");
    }
}
