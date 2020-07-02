/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chamo
 * 
 * 
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Book 
{
    private int ISBN;
    private String Name;
    private String Author;
    private int Year;
    private int Quantity;
    private int Edition;
    private String Category;
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }


    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getEdition() {
        return Edition;
    }

    public void setEdition(int Edition) {
        this.Edition = Edition;
    }
    
    
    
    public void addBooks()
    {
        try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");  
            
            Statement stmt=con.createStatement();  
            
            String querry = "INSERT INTO `books`(`ISBN`, `Name`, `Author`, `Year`, `Quantity`, `Edition`, `Category`) VALUES (?,?,?,?,?,?,?)";
            
            
            
            PreparedStatement st = con.prepareStatement(querry);
            
            st.setInt(1,ISBN);
            st.setString(2, Name);
            st.setString(3, Author);
            st.setInt(4,Year);
            st.setInt(5, Quantity);
            st.setInt(6,Edition);
            st.setString(7,Category);
            
            
            int rowsUpdated = st.executeUpdate(); 
                if (rowsUpdated == 1) 
                {
                    JOptionPane.showMessageDialog(null,"Book Added Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error Occured!");
                }
            
    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error Occured!");
            System.out.println(e);
        }  
}  
    
}
