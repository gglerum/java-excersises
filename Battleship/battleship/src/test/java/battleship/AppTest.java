package battleship;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
class AppTest {
    @BeforeAll
    static void setup() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(App.class);
        FxToolkit.showStage();
    }

    @Test
    void appHasLaunchedWithUi(FxRobot robot) {
        Assertions.assertThat(robot.lookup("#statusLabel").queryLabeled()).hasText("Battleship");
        Assertions.assertThat(robot.lookup("#buttonGuess").queryButton()).isVisible();
        Assertions.assertThat(robot.lookup("#inputGuess").queryTextInputControl()).isVisible();
    }

    @Test
    @Disabled("Working on new GUI")
    void guessWhereBoatIs(FxRobot robot) {
        robot.clickOn("#inputGuess").write("A1");
        robot.clickOn("#buttonGuess");
        Assertions.assertThat(robot.lookup("#statusLabel").queryLabeled()).hasText("Hit!");
    }

    // @Test
    // void startsWithPrimaryView(FxRobot robot) {
    // Assertions.assertThat(robot.lookup("#primaryButton").queryButton()).hasText("Switch
    // to Secondary View");
    // }

    // @Test
    // void buttonSwitchesViewToSecondary(FxRobot robot) {
    // robot.clickOn("#primaryButton");
    // Assertions.assertThat(robot.lookup("#secondaryButton").queryButton()).hasText("Switch
    // to Primary View");
    // }

    // @Test
    // void buttonSwitchesViewToPrimary(FxRobot robot) {
    // robot.clickOn("#secondaryButton");
    // Assertions.assertThat(robot.lookup("#primaryButton").queryButton()).hasText("Switch
    // to Secondary View");
    // }

}
