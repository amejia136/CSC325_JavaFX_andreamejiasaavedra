package com.example.csc325_javafxassignment_andreamejiasaavedra;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

public class HelloController {
    @FXML
    TextField textFirstName;
    @FXML
    TextField textLastName;
    @FXML
    TextField textDepartment;
    @FXML
    TextField textMajor;
    @FXML
    TextField textEmail;
    @FXML
    TextField textImageURL;
    @FXML
    TableView<Person> tableView;
    @FXML
    TableColumn<Person, Integer> columnID;
    @FXML
    TableColumn<Person, String> columnFirstName;
    @FXML
    TableColumn<Person, String> columnLastName;
    @FXML
    TableColumn<Person, String> columnDepartment;
    @FXML
    TableColumn<Person, String> columnMajor;
    @FXML
    Button buttonClear;
    @FXML
    Button buttonAdd;
    @FXML
    Button buttonDelete;
    @FXML
    Button buttonEdit;
    @FXML
    private ObservableList<Person> observableList;
    @FXML
    private Region region;
    @FXML
    private MenuBar menuBar;
    @FXML
    private BorderPane borderPane;
    Person person;

    public HelloController() {
    }

    public void initialize() {
        this.tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.textFirstName.setText(newValue.getFirstName());
                this.textLastName.setText(newValue.getLastName());
                this.textDepartment.setText(newValue.getDepartmentName());
                this.textMajor.setText(newValue.getMajorName());
                this.textEmail.setText(newValue.getEmailName());
            }

        });
        this.region.setOnMouseClicked(this::handleClickOutsideTableView);
    }

    private void handleClickOutsideTableView(MouseEvent mouseEvent) {
        if (!this.tableView.isHover()) {
            this.textFirstName.clear();
            this.textLastName.clear();
            this.textDepartment.clear();
            this.textMajor.clear();
            this.textEmail.clear();
            this.textImageURL.clear();
        }

    }

    public void themeNormalMenuItem() {
        this.menuBar.setStyle("-fx-background-color:  #994800;");
        this.borderPane.setStyle("-fx-background-color:  #B87F31;");
        this.buttonClear.setStyle("-fx-background-color:   #B87F31;");
        this.buttonAdd.setStyle("-fx-background-color:   #B87F31;");
        this.buttonDelete.setStyle("-fx-background-color:   #B87F31;");
        this.buttonEdit.setStyle("-fx-background-color:   #B87F31;");
    }

    public void themeRedMenuItem() {
        this.menuBar.setStyle("-fx-background-color: #990000;");
        this.borderPane.setStyle("-fx-background-color:  #b83131;");
        this.buttonClear.setStyle("-fx-background-color:   #b83131;");
        this.buttonAdd.setStyle("-fx-background-color:   #b83131;");
        this.buttonDelete.setStyle("-fx-background-color:   #b83131;");
        this.buttonEdit.setStyle("-fx-background-color:   #b83131;");
    }

    public void themeBlueMenuItem() {
        this.menuBar.setStyle("-fx-background-color: #003099;");
        this.borderPane.setStyle("-fx-background-color:  #314cb8");
        this.buttonClear.setStyle("-fx-background-color:   #314cb8;");
        this.buttonAdd.setStyle("-fx-background-color:   #314cb8;");
        this.buttonDelete.setStyle("-fx-background-color:   #314cb8;");
        this.buttonEdit.setStyle("-fx-background-color:   #314cb8;");
    }

    public void addButtonClick() {
        this.columnID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.columnFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.columnLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.columnDepartment.setCellValueFactory(new PropertyValueFactory("departmentName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("majorName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("emailName"));

        Random random = new Random();
        int ID = random.nextInt(1000);
        String firstName = this.textFirstName.getText();
        String lastName = this.textLastName.getText();
        String department = this.textDepartment.getText();
        String major = this.textMajor.getText();
        String email = this.textEmail.getText();

        this.person = new Person(ID, firstName, lastName, department, major, email);
        this.observableList = this.tableView.getItems();
        this.observableList.add(this.person);
    }

    public void deleteButtonClick() {
        this.columnID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.columnFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.columnLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.columnDepartment.setCellValueFactory(new PropertyValueFactory("departmentName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("majorName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("emailName"));
        this.observableList = this.tableView.getItems();

        Person selectedPerson = (Person) this.tableView.getSelectionModel().getSelectedItem();
        this.tableView.getItems().removeAll(new Person[]{(Person) this.tableView.getSelectionModel().getSelectedItem()});

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Person Deleted");
        alert.setHeaderText("Removed Person");
        alert.setContentText(selectedPerson.getID() + ", " + selectedPerson.getFirstName() + ", " + selectedPerson.getLastName());
        alert.showAndWait();
    }

    public void editButtonClick() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Edit Button");
        alert.setHeaderText("Editing Person...");
        alert.setContentText("To edit the following person, please adjust the information in text fields");
        alert.showAndWait();

        this.columnID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.columnFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.columnLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.columnDepartment.setCellValueFactory(new PropertyValueFactory("departmentName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("majorName"));
        this.columnMajor.setCellValueFactory(new PropertyValueFactory("emailName"));
        this.observableList = this.tableView.getItems();

        Person selectedPerson = (Person) this.tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            this.textFirstName.setText(selectedPerson.getFirstName());
            this.textLastName.setText(selectedPerson.getLastName());
            this.textDepartment.setText(selectedPerson.getDepartmentName());
            this.textMajor.setText(selectedPerson.getMajorName());
            this.textEmail.setText(selectedPerson.getEmailName());
            selectedPerson.setFirstName(this.textFirstName.getText());
            selectedPerson.setLastName(this.textLastName.getText());
            selectedPerson.setDepartmentName(this.textDepartment.getText());
            selectedPerson.setMajorName(this.textMajor.getText());
            selectedPerson.setEmailName(this.textEmail.getText());
        } else {
            System.out.println("No person selected for editing...");
        }

    }

    public void clearButtonClick() {
        this.observableList = this.tableView.getItems();
        this.observableList.clear();
        this.observableList = this.tableView.getItems();
        this.observableList.clear();
    }
}
