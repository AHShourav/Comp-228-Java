package ui; //defines the package

import javax.swing.*; //imports swing components for the ui
import java.awt.*; //imports layout tools

public class MainMenu extends JFrame { //defines the MainMenu class, which extends JFrame to create a window

    public MainMenu() {
        setTitle("Main Menu"); //sets the window title
        setSize(400, 300); //sets the window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the app when the window is closed
        setLayout(new GridLayout(5, 1, 10, 10)); //arranges components in a grid with 5 rows, 1 column, and spacing

        //buttons for navigating to different forms
        JButton btnPlayerForm = new JButton("Add Player");
        JButton btnGameForm = new JButton("Add Game");
        JButton btnPlayerAndGameForm = new JButton("Add Player and Game Relation");
        JButton btnUpdatePlayerForm = new JButton("Update Player");
        JButton btnPlayerGameReportForm = new JButton("View Player-Game Report");

        //adds buttons to the window
        add(btnPlayerForm);
        add(btnGameForm);
        add(btnPlayerAndGameForm);
        add(btnUpdatePlayerForm);
        add(btnPlayerGameReportForm);

        //defines actions when buttons are clicked
        btnPlayerForm.addActionListener(e -> openPlayerForm()); //opens player form
        btnGameForm.addActionListener(e -> openGameForm()); //opens game form
        btnPlayerAndGameForm.addActionListener(e -> openPlayerAndGameForm()); //opens player and game relation form
        btnUpdatePlayerForm.addActionListener(e -> openUpdatePlayerForm()); //opens update player form
        btnPlayerGameReportForm.addActionListener(e -> openPlayerGameReportForm()); //opens player-game report form

        setVisible(true); //makes the window visible
    }

    //method to open player form
    private void openPlayerForm() {
        new PlayerForm();
    }

    //method to open game form
    private void openGameForm() {
        new GameForm();
    }

    //method to open player and game relation form
    private void openPlayerAndGameForm() {
        new PlayerAndGameForm();
    }

    //method to open update player form
    private void openUpdatePlayerForm() {
        new PlayerUpdateForm();
    }

    //method to open player-game report form
    private void openPlayerGameReportForm() {
        new PlayerGameReportForm();
    }

    public static void main(String[] args) {
        new MainMenu(); //starts the application by showing the main menu
    }
}
