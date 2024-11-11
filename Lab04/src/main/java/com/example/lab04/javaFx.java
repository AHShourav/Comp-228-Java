package com.example.lab04;

//imports packages for gui
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//main class extends application
public class javaFx extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information Form");
        //window title

        //creates TextFields for user input
        TextField nameField = new TextField();
        TextField addressField = new TextField();
        TextField provinceField = new TextField();
        TextField cityField = new TextField();
        TextField postalCodeField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();

        // Layout for labels and text fields
        GridPane inputPane = new GridPane(); //creates grid layout
        inputPane.setHgap(10); //sets gap horizontally between columns
        inputPane.setVgap(10); //vertical gap
        inputPane.add(new Label("Name:"), 0, 0);
        inputPane.add(nameField, 1, 0);
        inputPane.add(new Label("Address:"), 0, 1);
        inputPane.add(addressField, 1, 1);
        inputPane.add(new Label("Province:"), 0, 3);
        inputPane.add(provinceField, 1, 3);
        inputPane.add(new Label("City:"), 0, 2);
        inputPane.add(cityField, 1, 2);
        inputPane.add(new Label("Postal Code:"), 0, 4);
        inputPane.add(postalCodeField, 1, 4);
        inputPane.add(new Label("Phone Number:"), 0, 5);
        inputPane.add(phoneField, 1, 5);
        inputPane.add(new Label("Email:"), 0, 6);
        inputPane.add(emailField, 1, 6);

        //Radio buttons for selecting programming language
        ToggleGroup majorGroup = new ToggleGroup(); //makes sure only one selection
        RadioButton csRadio = new RadioButton("Computer Science");
        RadioButton businessRadio = new RadioButton("Business");
        csRadio.setToggleGroup(majorGroup);
        businessRadio.setToggleGroup(majorGroup);

        //Horizontal box layout to arrange radio
        HBox majorSelectionBox = new HBox(10, new Label("Major:"), csRadio, businessRadio);

        // ComboBox for courses
        ComboBox<String> courseComboBox = new ComboBox<>();
        ListView<String> selectedCoursesList = new ListView<>();

        // Event Listener to update courses when course is selcted
        csRadio.setOnAction(e -> {
            courseComboBox.getItems().clear(); //clears prevoius options
            courseComboBox.getItems().addAll("Java", "C#", "Python");
        });
        businessRadio.setOnAction(e -> {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Economics", "Marketing", "Management");
        });

        // event listener prevents duplicate entries in the ListView
        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !selectedCoursesList.getItems().contains(selectedCourse)) {
                selectedCoursesList.getItems().add(selectedCourse);
            }
        });

        //checkBoxes for additional activities
        CheckBox studentCouncilCheckBox = new CheckBox("Student Council");
        CheckBox volunteerWorkCheckBox = new CheckBox("Volunteer Work");

        HBox activitiesBox = new HBox(10, studentCouncilCheckBox, volunteerWorkCheckBox);

        //textArea for displaying student information
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);




        // Button to display student information
        Button displayButton = new Button("Display");

        displayButton.setOnAction(e -> {
            StringBuilder studentInfo = new StringBuilder(); //creates strings
            studentInfo.append("Name: ").append(nameField.getText()).append("\n")
                    .append("Address: ").append(addressField.getText()).append("\n")
                    .append("City: ").append(cityField.getText()).append("\n")
                    .append("Province: ").append(provinceField.getText()).append("\n")
                    .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                    .append("Phone Number: ").append(phoneField.getText()).append("\n")
                    .append("Email: ").append(emailField.getText()).append("\n");

            RadioButton selectedMajor = (RadioButton) majorGroup.getSelectedToggle();
            if (selectedMajor != null) {
                studentInfo.append("Major: ").append(selectedMajor.getText()).append("\n");
            }

            studentInfo.append("Courses: ").append(selectedCoursesList.getItems()).append("\n");

            if (studentCouncilCheckBox.isSelected()) {
                studentInfo.append("Student Council Member\n");
            }
            if (volunteerWorkCheckBox.isSelected()) {
                studentInfo.append("Volunteer Work Participant\n");
            }

            displayArea.setText(studentInfo.toString());
        });

        //Layout sizing
        VBox mainLayout = new VBox(10, inputPane, majorSelectionBox, new Label("Select Course:"), courseComboBox, selectedCoursesList, activitiesBox, displayButton, displayArea);
        Scene scene = new Scene(mainLayout, 500, 600);

        //sets up the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

