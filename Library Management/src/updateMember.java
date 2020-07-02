
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chamo
 */


public class updateMember 
{
    private int ID;
    private String fName;
    private String lName;
    private int tel;
    private String email;
    private String city;
    private String username;
    private String password;
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getUsername() {
        return username;
    }
     public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void updateMember()
    {
      try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");  
            
            Statement stmt=con.createStatement();  
            
            String querry = "UPDATE `users` SET `fName`=?,`lName`=?,`City`=?,`tel`=?,`email`=?,`username`=?,`password`=? WHERE USER_ID =?"; 
            
            
            
            PreparedStatement st = con.prepareStatement(querry);
            
            
            st.setString(1,fName);
            st.setString(2, lName);
            st.setString(3, city);
            st.setInt(4,tel);
            st.setString(5, email);
            st.setString(6,username);
            st.setString(7,password);
            st.setInt(8,ID);
            
            
            int rowsUpdated = st.executeUpdate(); 
                if (rowsUpdated == 1) 
                {
                    JOptionPane.showMessageDialog(null,"Member Updated");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"OOPS! Something gone wrong");
                }
            
    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }

}
