import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Veritabanıİslemleri {
  
    private Connection conn=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null; 
   
    
    public ArrayList<Skorlar> skorlarigetir(){
        ArrayList<Skorlar> cikti=new ArrayList<Skorlar>();
        
        try {
            statement = conn.createStatement();
            String sorgu="SELECT skorlar from uyeler where mail=\""+GirisEkrani.mail_alani.getText()+"\"";
                  //where mail=\""+GirisEkrani.mail_alani.getText()+"\"";
                 //SELECT skor1,skor2,skor3 from skorlar join uyeler on skorlar.uye_id=uyeler.uye_id where mail=\""+GirisEkrani.mail_alani.getText()+"\"";
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                
              
                int skorlar=rs.getInt("skorlar");
              
               
                 
                cikti.add(new Skorlar(skorlar));
            } 
            return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Veritabanıİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public void uyeEkle(String uyemail,String uyesifre){
       
        String sorgu="Insert Into uyeler (mail,sifre,skorlar) Values (?,?,0)";
        try {
            preparedStatement =conn.prepareStatement(sorgu);
            preparedStatement.setString(1,uyemail);
            preparedStatement.setString(2, uyesifre);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veritabanıİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
 
    //mail=\""+GirisEkrani.mail_alani.getText()+"\""
    
     public void skorEkle(Integer harcanan_ates){
       
        String sorgu="update uyeler set skorlar = ?  where mail=\""+GirisEkrani.mail_alani.getText()+"\" ";
        try {
            preparedStatement =conn.prepareStatement(sorgu);
             preparedStatement.setInt(1,harcanan_ates);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veritabanıİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    
    
    public boolean girisyap(String uyemail,String uyesifre){
        String sorgu = "Select * From uyeler where mail=? and sifre=?";
       
        try {
            preparedStatement=conn.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, uyemail);
            preparedStatement.setString(2, uyesifre);
            
            ResultSet rs=preparedStatement.executeQuery();
           /* while(rs.next()){
                id=rs.getInt("uye_id");
            }*/
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Veritabanıİslemleri.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        } 
        
       
    }
    
    
    public Veritabanıİslemleri(){
         String url="jdbc:mysql://"+Baglanti.host+":"+Baglanti.port+"/"+Baglanti.db_ismi;
        try {
                
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) { 
            
           System.out.println("Driver bulunamadı");
        } 
        try {
                conn=DriverManager.getConnection(url,Baglanti.uyemail,Baglanti.uyesifre);
                System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız");
        }
              
    } 
    
   
}
