module com.example.gameOfTheEclipsedSun {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gameoftheeclipsedsun to javafx.fxml;
    exports org.example.gameoftheeclipsedsun;
    exports org.example.gameoftheeclipsedsun.controller;
    opens org.example.gameoftheeclipsedsun.controller to javafx.fxml;
    exports org.example.gameoftheeclipsedsun.model;
    opens org.example.gameoftheeclipsedsun.model to javafx.fxml;
    exports org.example.gameoftheeclipsedsun.view;
    opens org.example.gameoftheeclipsedsun.view to javafx.fxml;
    exports org.example.gameoftheeclipsedsun.view.guide;
    opens org.example.gameoftheeclipsedsun.view.guide to javafx.fxml;
}