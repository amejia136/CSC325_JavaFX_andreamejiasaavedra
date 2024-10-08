module com.example.csc325_javafxassignment_andreamejiasaavedra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc325_javafxassignment_andreamejiasaavedra to javafx.fxml;
    exports com.example.csc325_javafxassignment_andreamejiasaavedra;
}