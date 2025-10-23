package project.milktea_pos_inv;

import java.util.regex.Pattern;

public class AccountManager {

    String username;
    String password;

    SystemAccount[] accounts;
    
    SystemAccount currentAccount;
    
    SQLDBQuery sqldb;
    SQLDBQuery.AccountQuery accountQuery;
    
    public AccountManager() {
        sqldb = new SQLDBQuery();
        accountQuery = sqldb.new AccountQuery(sqldb.getConnection());
    }

    public Boolean accountExists(String user, String username) {
        return accountQuery.searchAccount(user, username);
    }
    
    public Boolean accountVerified(String user, String username, String password) {
        return accountQuery.verifyAccount(user, username, password);
    }
    
    public SystemAccount useAccount() {
        return new SystemAccount();
    }
    
    public Boolean checkUsernamePattern(String username) {
        String usernamePattern = "^[A-Za-z0-9_]{4,20}$";
        return Pattern.matches(usernamePattern, username);
    }
    
    public Boolean checkPasswordPattern(String password) {
        String passwordPattern =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/]).{8,16}$";
        return Pattern.matches(passwordPattern, password);
    }

    public void addAccount() {
        
    }

}
