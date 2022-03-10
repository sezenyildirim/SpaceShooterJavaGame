
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Baglanti {
    public static final String uyemail="root";
    public static final String uyesifre="";
    public static final String db_ismi="uzayoyunu";
    public static final String host="localhost";
    public static final int port=3306;
    private Connection conn=null;
    public Baglanti(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi;
        try {
                
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) { 
            
           System.out.println("Driver bulunamadı");
        } 
        try {
                conn=DriverManager.getConnection(url,uyemail,uyesifre);
                System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız");
        }
              
    } 
    public static void main(String[] args) {
        Baglanti baglanti=new Baglanti();
    }
}
