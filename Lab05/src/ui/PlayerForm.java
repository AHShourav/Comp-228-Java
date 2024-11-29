package ui;

import utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerForm extends JFrame {
    //declare input fields and button
    private JTextField txtPlayerId, txtFirstName, txtLastName, txtAddress, txtPostalCode, txtProvince, txtPhoneNumber;
    private JButton btnInsertPlayer;

    //constructor for setting up UI
    public PlayerForm() {
        setTitle("Player Form"); //set window title
        setSize(400, 300); //set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application on exit
        setLayout(new GridLayout(8, 2, 5, 5)); //use table-like grid layout

        //create form labels
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

        //initialize button
        btnInsertPlayer = new JButton("Insert Player");

        //add labels and fields to window
        add(lblPlayerId); add(txtPlayerId);
        add(lblFirstName); add(txtFirstName);
        add(lblLastName); add(txtLastName);
        add(lblAddress); add(txtAddress);
        add(lblPostalCode); add(txtPostalCode);
        add(lblProvince); add(txtProvince);
        add(lblPhoneNumber); add(txtPhoneNumber);
        add(new JLabel()); add(btnInsertPlayer); //add blank space and button

        //add event handler for button click
        btnInsertPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPlayer(); //call method to insert player
            }
        });

        setVisible(true); //show window
    }

    //method to insert player into database
    private void insertPlayer() {
        String query = """
                INSERT INTO "Al_Helal_Shourav_player" 
                (player_id, first_name, last_name, address, postal_code, province, phone_number) 
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection(); //get database connection
             PreparedStatement pstmt = conn.prepareStatement(query)) { //prepare query

            //set query values from input fields
            pstmt.setInt(1, Integer.parseInt(txtPlayerId.getText()));
            pstmt.setString(2, txtFirstName.getText());
            pstmt.setString(3, txtLastName.getText());
            pstmt.setString(4, txtAddress.getText());
            pstmt.setString(5, txtPostalCode.getText());
            pstmt.setString(6, txtProvince.getText());
            pstmt.setString(7, txtPhoneNumber.getText());

            pstmt.executeUpdate(); //execute insert query
            JOptionPane.showMessageDialog(this, "Player added successfully!"); // show success message

        } catch (SQLException e) {
            e.printStackTrace(); //print detailed error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); // show error message
        }
    }

    public static void main(String[] args) {
        new PlayerForm(); //create and show the form
    }
}
