
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


class Ates{
private int x;
private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}

public class Oyun extends JPanel implements KeyListener,ActionListener{//KeyListener tuşlara bastığımzda gerekli
    //olacak metodları kullanmamızı sağlayan interface
    //actionperformed metodunu kullanmak için actionlistener interfaceni impleme ederiz
     Veritabanıİslemleri veritabanıİslemleri=new Veritabanıİslemleri();
    Timer timer=new Timer(5,this);
    private int gecen_sure=0;
    public int harcanan_ates=0;
    private BufferedImage image;
    private ArrayList<Ates> atesler=new ArrayList<Ates>();//atesleri tutmak için kullanırız.Tek bir ateş olmasın.
    
    private int atesdirY=0;//atesin y kordinatına ekleriz
    private int topX=0;//topu x=0 noktasında başlatır.
    private int topdirX=0;//bu değeri topx'e ekleriz.
    private int uzayGemisiX=0;//uzaygemisini x=0 noktasından başlatır.
    private int dirUzayX=30;//sola ya da sağa basıldığında uzaygemisi 20 birim hareket eder

    public int getAtesdirY() {
        return atesdirY;
    }

    public void setAtesdirY(int atesdirY) {
        this.atesdirY = atesdirY;
    }

    public int getTopdirX() {
        return topdirX;
    }

    public void setTopdirX(int topdirX) {
        this.topdirX = topdirX;
    }

    public int getDirUzayX() {
        return dirUzayX;
    }

    public void setDirUzayX(int dirUzayX) {
        this.dirUzayX = dirUzayX;
    }
    
    
    
    public boolean kontrolEt(){
        for(Ates ates:atesler){
            if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(topX,0,20,20))){
                return true;
            }
        } 
        return false;
    }

    public Oyun() {
        try {
            
            image=ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png"))); 
        } 
        
        catch (IOException ex) 
        {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.BLACK);//oyun arkaplanını siyah yapar.
        
        
        
        timer.start();
        
  
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        gecen_sure+=5;
        g.setColor(Color.red);
        g.fillOval(topX, 0, 20, 20);//topu çizeriz
        g.drawImage(image,uzayGemisiX,490,image.getWidth()/10,image.getHeight()/10,this );//490 y eksenindeki değeri
        //genişliği ve yüksekliği 10'a bölerek uzaygemisi resminin ekrana uygun boyutta olmasını sağlarız
        //this jpanel üzerinde oluşacağını belirtir
       
        for(Ates ates:atesler){//(foreach döngüsü)program yavaşlamasın diye çıkan ateşleri sileriz
            if(ates.getY()<0){
                atesler.remove(ates);
            }
        }
        g.setColor(Color.BLUE);
        for (Ates ates:atesler){
            g.fillRect(ates.getX(), ates.getY(), 10, 20);
        } 
        if(kontrolEt()){
            timer.stop();
            String message = "Kazandınız...\n " + 
                    "Harcanan ateş: " + harcanan_ates +" "+
                    "Geçen süre:" + gecen_sure / 1000.0; 
            veritabanıİslemleri.skorEkle(harcanan_ates);
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }
    }

    @Override
    public void repaint() {//otomatik olarak painti çalıştırır
        super.repaint(); 
    }
    

    

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c=e.getKeyCode();
        if(c==KeyEvent.VK_LEFT){
            if(uzayGemisiX<=0){
                uzayGemisiX=0;
            } 
            else{
                uzayGemisiX-=dirUzayX;
            }
            
        } 
        else if(c==KeyEvent.VK_RIGHT){
           if (uzayGemisiX>=750){
               
               uzayGemisiX=750;
           }
           else{
               
               uzayGemisiX+=dirUzayX;
           }
            
        } 
        else if(c==KeyEvent.VK_CONTROL){
            atesler.add(new Ates(uzayGemisiX+15,470));
            harcanan_ates++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(Ates ates:atesler){
            ates.setY(ates.getY()- atesdirY);
        }
        
        topX+=topdirX;
        if(topX >= 750){
            topdirX=-topdirX;
            
        } 
        if(topX <= 0){
            topdirX=-topdirX;
            
        } 
        repaint();
       
    }
    
}
