import java.awt.*;

public class AutoClicker {

    private Robot robot;
    // delay between clicks in ms
    private int delay;

    public AutoClicker() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        delay = 300;
    }

    public void clickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(100);
            robot.mouseRelease(button);
            robot.delay(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDelay (int ms) {
        this.delay = ms;
    }
}
