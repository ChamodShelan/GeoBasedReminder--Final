
import java.sql.*;
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
public class Members 
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
    
    public void addMember()
    {
      try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");  
            
            Statement stmt=con.createStatement();  
            
            String querry = "INSERT INTO `users`(`USER_ID`,`fName`, `lName`, `City`, `tel`, `email`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?)"; 
            
            
            
            PreparedStatement st = con.prepareStatement(querry);
            
            st.setInt(1,ID);
            st.setString(2,fName);
            st.setString(3, lName);
            st.setString(4, city);
            st.setInt(5,tel);
            st.setString(6, email);
            st.setString(7,username);
            st.setString(8,password);
            
            
            int rowsUpdated = st.executeUpdate(); 
                if (rowsUpdated == 1) 
                {
                    JOptionPane.showMessageDialog(null,"Member Registered");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"USER ALREADY REGISTERED OR INVALID NIC");
                }
            
    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }

    

   

    

}
