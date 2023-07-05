module battleship {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens battleship to javafx.fxml;

    exports battleship;
}
