
package project.milktea_pos_inv;

public class SystemAccount implements Account {
    String accounttype;
    String username;
    String password;

    public SystemAccount(/*String username, String password*/) {
        /*this.username = username;
        this.password = password;*/
    }
    
    public void editUsername(String newUsername) {
        username = newUsername;
    }
    
    public void editPassword(String newPassword) {
        password = newPassword;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
