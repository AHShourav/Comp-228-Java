package ui; //defines the package

import utils.DatabaseConnection; //imports the database connection utility
import javax.swing.*; //imports swing components for the user interface
import java.awt.*; //imports layout management tools
import java.awt.event.ActionEvent; //imports classes for handling button clicks
import java.awt.event.ActionListener; //imports interface for button click handling
import java.sql.Connection; //used for connecting to the database
import java.sql.PreparedStatement; //used for precompiled SQL queries
import java.sql.SQLException; //handles SQL errors
import java.text.ParseException; //handles date parsing errors
import java.text.SimpleDateFormat; //used for date formatting

public class PlayerAndGameForm extends JFrame {

    //fields for inputting data
    private JTextField txtPlayerGameId, txtPlayerId, txtGameId, txtPlayingDate, txtScore;
    private JButton btnInsertPlayerGame; //button to insert data into the database

    public PlayerAndGameForm() {
        setTitle("Player and Game Form"); //sets the window title
        setSize(400, 300); //sets the window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the app when the window is closed
        setLayout(new GridLayout(6, 2, 5, 5)); //arranges components in a 6x2 grid with spacing

        //labels for each input field
        JLabel lblPlayerGameId = new JLabel("Player-Game ID:");
        JLabel lblPlayerId = new JLabel("Player ID:");
        JLabel lblGameId = new JLabel("Game ID:");
        JLabel lblPlayingDate = new JLabel("Playing Date (yyyy-MM-dd):");
        JLabel lblScore = new JLabel("Score:");

        //text fields for user input
        txtPlayerGameId = new JTextField();
        txtPlayerId = new JTextField();
        txtGameId = new JTextField();
        txtPlayingDate = new JTextField();
        txtScore = new JTextField();

        btnInsertPlayerGame = new JButton("Insert"); //button to insert data

        //adding labels and fields to the layout
        add(lblPlayerGameId); add(txtPlayerGameId);
        add(lblPlayerId); add(txtPlayerId);
        add(lblGameId); add(txtGameId);
        add(lblPlayingDate); add(txtPlayingDate);
        add(lblScore); add(txtScore);
        add(new JLabel()); add(btnInsertPlayerGame); //empty space before the button

        //defines what happens when the insert button is clicked
        btnInsertPlayerGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPlayerGame(); //calls the method to insert data
            }
        });

        setVisible(true); //makes the window visible
    }

    private void insertPlayerGame() {
        //sql query to insert data into the player-game relationship table
        String query = "INSERT INTO \"AH_Shourav_player_and_game\" (player_game_id, player_id, game_id, playing_date, score) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); //gets database connection
             PreparedStatement pstmt = conn.prepareStatement(query)) { //prepares the SQL query

            //sets values in the query from user input
            pstmt.setInt(1, Integer.parseInt(txtPlayerGameId.getText())); //player-game ID
            pstmt.setInt(2, Integer.parseInt(txtPlayerId.getText()));
            pstmt.setInt(3, Integer.parseInt(txtGameId.getText()));
            pstmt.setDate(4, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(txtPlayingDate.getText()).getTime())); //playing date
            pstmt.setInt(5, Integer.parseInt(txtScore.getText())); //score

            pstmt.executeUpdate(); //executes the query
            JOptionPane.showMessageDialog(this, "Player-Game relationship added successfully!"); //shows success message

        } catch (SQLException | ParseException e) { //handles errors
            e.printStackTrace(); //prints error details
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); //shows error message to the user
        }
    }

    public static void main(String[] args) {
        new PlayerAndGameForm(); //starts the application
    }
}
