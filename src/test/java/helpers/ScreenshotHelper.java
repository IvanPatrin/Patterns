package helpers;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static WebDriver screen;
    private static int counter = 0;

    public static void init(WebDriver driver) {
        screen = driver;
    }

    public static void makeScreenshot() {
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(screen);
            counter++;
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screenshot-" + counter + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavaScriptHelper.scrollTo(0,0);
    }
}
