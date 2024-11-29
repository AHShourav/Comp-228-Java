package ui;

import utils.DatabaseConnection; //imports database connection
import javax.swing.*; //imports Swing components
import javax.swing.table.DefaultTableModel; //for table models
import java.awt.*; //for layouts
import java.sql.*; //for database operations

public class PlayerGameReportForm extends JFrame {
    private JTable reportTable; //table to display data
    private JComboBox<Integer> playerIdComboBox; //dropdown for player IDs
    private JButton btnLoadReport; //button to load the report

    public PlayerGameReportForm() {
        setTitle("Player-Game Report"); //set window title
        setSize(600, 400); // set size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close behavior
        setLayout(new BorderLayout()); //layout manager

        //top panel with dropdown and button
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Select Player ID:"));
        playerIdComboBox = new JComboBox<>();
        btnLoadReport = new JButton("Load Report");
        topPanel.add(playerIdComboBox);
        topPanel.add(btnLoadReport);
        add(topPanel, BorderLayout.NORTH);

        //table for displaying the report
        reportTable = new JTable();
        add(new JScrollPane(reportTable), BorderLayout.CENTER);

        loadPlayerIds(); //load player IDs into dropdown
        btnLoadReport.addActionListener(e -> loadReport()); //set button action

        setVisible(true); //show window
    }

    private void loadPlayerIds() {
        //query to get player IDs
        String query = "SELECT player_id FROM \"Al_Helal_Shourav_player\"";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                playerIdComboBox.addItem(rs.getInt("player_id")); // add IDs to dropdown
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading Player IDs: " + e.getMessage());
        }
    }

    private void loadReport() {
        //query to fetch player-game details
        String query = """
                SELECT p.first_name, p.last_name, g.game_title, pg.playing_date, pg.score
                FROM "Al_Helal_Shourav_player" p
                JOIN "AH_Shourav_player_and_game" pg ON p.player_id = pg.player_id
                JOIN "Al_Helal_Shourav_game" g ON g.game_id = pg.game_id
                WHERE p.player_id = ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, (int) playerIdComboBox.getSelectedItem());
            ResultSet rs = pstmt.executeQuery();

            //set up table columns
            DefaultTableModel tableModel = new DefaultTableModel(
                    new String[]{"First Name", "Last Name", "Game Title", "Playing Date", "Score"}, 0);

            //add rows to the table
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("game_title"), rs.getDate("playing_date").toString(),
                        rs.getInt("score")
                });
            }
            reportTable.setModel(tableModel); //set table data
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading report: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new PlayerGameReportForm(); //start the application
    }
}
