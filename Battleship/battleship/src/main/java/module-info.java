module battleship {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens battleship.controllers to javafx.fxml;

    exports battleship;
    exports battleship.models;
    exports battleship.controllers;
}
