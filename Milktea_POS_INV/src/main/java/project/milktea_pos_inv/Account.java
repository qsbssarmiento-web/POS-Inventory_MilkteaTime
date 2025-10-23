
package project.milktea_pos_inv;

public interface Account {  
    
    // Setters
    
    public void editUsername(String newUsername);
    public void editPassword(String newPassword);
    
    // Getters
    
    public String getUsername();
    public String getPassword();
}
