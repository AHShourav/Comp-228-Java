package ui;

import utils.DatabaseConnection; //imports the database connection utility

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameForm extends JFrame { //defines the GameForm class, extending JFrame to create a window
    private JTextField txtGameId, txtGameTitle; //fields for inputting game id and title
    private JButton btnInsertGame; //button to add a game

    public GameForm() {
        setTitle("Game Form"); //sets the window title
        setSize(300, 200); //sets the window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the app when the window is closed
        setLayout(new GridLayout(3, 2, 5, 5)); //arranges components in a 3x2 grid

        JLabel lblGameId = new JLabel("Game ID:"); //label for game id
        JLabel lblGameTitle = new JLabel("Game Title:"); //label for game title

        txtGameId = new JTextField(); //text field for game id input
        txtGameTitle = new JTextField(); //text field for game title input

        btnInsertGame = new JButton("Insert Game"); //button for adding a game

        add(lblGameId); add(txtGameId);
        add(lblGameTitle); add(txtGameTitle);
        add(new JLabel()); add(btnInsertGame);

        btnInsertGame.addActionListener(new ActionListener() { //defines action when the button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                insertGame(); //calls the method to insert a game
            }
        });

        setVisible(true); //makes the window visible
    }

    private void insertGame() {
        String query = "INSERT INTO \"Al_Helal_Shourav_game\" (game_id, game_title) VALUES (?, ?)"; //sql query to insert game data
        try (Connection conn = DatabaseConnection.getConnection(); //connects to the database
             PreparedStatement pstmt = conn.prepareStatement(query)) { //prepares the query

            pstmt.setInt(1, Integer.parseInt(txtGameId.getText())); //sets the game id from the text field
            pstmt.setString(2, txtGameTitle.getText()); //sets the game title from the text field

            pstmt.executeUpdate(); //executes the query
            JOptionPane.showMessageDialog(this, "Game added successfully!"); //shows success message

        } catch (SQLException e) { //catches database errors
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); //shows error message
        }
    }

    public static void main(String[] args) {
        new GameForm(); //starts the application by opening the game form
    }
}
