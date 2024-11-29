package ui;

import utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerUpdateForm extends JFrame {

    //text fields for player details
    private JTextField txtPlayerId, txtFirstName, txtLastName, txtAddress, txtPostalCode, txtProvince, txtPhoneNumber;
    private JButton btnUpdatePlayer; //button to update the player

    public PlayerUpdateForm() {
        setTitle("Update Player Form"); //set window title
        setSize(400, 300); //set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define close behavior
        setLayout(new GridLayout(8, 2, 5, 5)); //layout with 8 rows, 2 columns, and spacing

        //labels for the input fields
        JLabel lblPlayerId = new JLabel("Player ID:");
        JLabel lblFirstName = new JLabel("First Name:");
        JLabel lblLastName = new JLabel("Last Name:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblPostalCode = new JLabel("Postal Code:");
        JLabel lblProvince = new JLabel("Province:");
        JLabel lblPhoneNumber = new JLabel("Phone Number:");

        //initialize input fields
        txtPlayerId = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtAddress = new JTextField();
        txtPostalCode = new JTextField();
        txtProvince = new JTextField();
        txtPhoneNumber = new JTextField();

        btnUpdatePlayer = new JButton("Update Player"); //button to trigger the update

        //add labels and fields to the layout
        add(lblPlayerId); add(txtPlayerId);
        add(lblFirstName); add(txtFirstName);
        add(lblLastName); add(txtLastName);
        add(lblAddress); add(txtAddress);
        add(lblPostalCode); add(txtPostalCode);
        add(lblProvince); add(txtProvince);
        add(lblPhoneNumber); add(txtPhoneNumber);
        add(new JLabel()); add(btnUpdatePlayer); //empty space before the button

        //add an action listener to the button
        btnUpdatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlayer(); //call the method to update the player
            }
        });

        setVisible(true); //show the window
    }

    private void updatePlayer() {
        //sql query to update the player record
        String query = """
                UPDATE "Al_Helal_Shourav_player"
                SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ?
                WHERE player_id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection(); //connect to database
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            //set query parameters from input fields
            pstmt.setString(1, txtFirstName.getText());
            pstmt.setString(2, txtLastName.getText());
            pstmt.setString(3, txtAddress.getText());
            pstmt.setString(4, txtPostalCode.getText());
            pstmt.setString(5, txtProvince.getText());
            pstmt.setString(6, txtPhoneNumber.getText());
            pstmt.setInt(7, Integer.parseInt(txtPlayerId.getText())); //convert player ID to integer

            //execute the update
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Player updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Player ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); //print error details
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); //show error to the user
        }
    }

    public static void main(String[] args) {
        new PlayerUpdateForm(); //start the application
    }
}
