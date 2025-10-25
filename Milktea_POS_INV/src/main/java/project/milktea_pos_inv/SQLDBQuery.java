package project.milktea_pos_inv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDBQuery {

    // Database credentials
    
    /* using infinityfree cloud server hosting:
    
    private static final String URL = "jdbc:mysql://sql113.infinityfree.com/if0_40250482_milkteatime";
    private static final String USER = "if0_40250482";
    private static final String PASSWORD = "grp9milktea";
    
    */
    
    /* using localhost
    
    private static final String URL = "jdbc:mysql://localhost/milkteatime";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // */
    
    //* using aiven hosting
    
    private static final String URL = "jdbc:mysql://milkteatime-milkteatime.f.aivencloud.com:11810/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "";
    
    // */
    
    // Connection and SQL objects
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // Constructor – connect to database
    public SQLDBQuery() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(SQLDBQuery.class.getName()).log(Level.SEVERE, "MySQL JDBC Driver not found!", e);
        } catch (SQLException ex) {
            Logger.getLogger(SQLDBQuery.class.getName()).log(Level.SEVERE, "Database connection failed!", ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Inner class for account queries
    public class AccountQuery {

        private static final String TABLE_NAME = "accounts";
        private static final String ID_COL = "id";
        private static final String USERNAME_COL = "username";
        private static final String PASSWORD_COL = "password";
        private static final String TYPE_COL = "type";

        private final Connection connection;

        // Pass the connection from outer class
        public AccountQuery(Connection connection) {
            this.connection = connection;
        }
        
        public SystemAccount getAccount() {
            
            return new SystemAccount();
        }

        // Search for an account by type and username
        public boolean searchAccount(String user, String username) {
            String query = "SELECT " + USERNAME_COL + " FROM " + TABLE_NAME
                    + " WHERE " + USERNAME_COL + " = ? AND " + TYPE_COL + " = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, user);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    }
                }

            } catch (SQLException e) {
                Logger.getLogger(AccountQuery.class.getName()).log(Level.SEVERE, "Error searching account", e);
            }
            return false;
        }

        // Verify full account (username, password, type)
        public boolean verifyAccount(String user, String username, String password) {
            String query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + USERNAME_COL + " = ? AND " + TYPE_COL + " = ? AND " + PASSWORD_COL + " = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, user);
                preparedStatement.setString(3, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    }
                }

            } catch (SQLException e) {
                Logger.getLogger(AccountQuery.class.getName()).log(Level.SEVERE, "Error verifying account", e);
            }
            return false;
        }
    }
    
    public class InventoryQueries {
        
        private Connection connection;
        
        public InventoryQueries(Connection connection) {
            this.connection = connection;
        }
        
        
    }
}
