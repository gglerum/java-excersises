package battleship;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class AppTest {
    private static Stage stage;
    private static App app;

    @BeforeAll
    static void setup() throws Exception {
        stage = FxToolkit.registerPrimaryStage();
        app = (App) FxToolkit.setupApplication(App.class);
        FxToolkit.showStage();
    }

    @Test
    void startsWithPrimaryView(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#primaryButton").queryButton()).hasText("Switch to Secondary View");
    }

    @Test
    void buttonSwitchesViewToSecondary(FxRobot robot) {
        robot.clickOn("#primaryButton");
        Assertions.assertThat(robot.lookup("#secondaryButton").queryButton()).hasText("Switch to Primary View");
    }

    @Test
    void buttonSwitchesViewToPrimary(FxRobot robot) {
        robot.clickOn("#secondaryButton");
        Assertions.assertThat(robot.lookup("#primaryButton").queryButton()).hasText("Switch to Secondary View");
    }
}
