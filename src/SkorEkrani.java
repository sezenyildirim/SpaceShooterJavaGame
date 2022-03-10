
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;


public class SkorEkrani extends javax.swing.JDialog {
    DefaultTableModel model;
    Veritabanıİslemleri veritabanıİslemleri=new Veritabanıİslemleri();

   
    public SkorEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
        model=(DefaultTableModel)skor_tablosu.getModel();
        skorgoruntule();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        skor_tablosu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        oyunubaslatbutonu = new javax.swing.JButton();
        basitrad = new javax.swing.JRadioButton();
        ortarad = new javax.swing.JRadioButton();
        zorrad = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));

        skor_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "En Son Skor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(skor_tablosu);
        if (skor_tablosu.getColumnModel().getColumnCount() > 0) {
            skor_tablosu.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(186, 158, 180));

        oyunubaslatbutonu.setBackground(new java.awt.Color(133, 240, 143));
        oyunubaslatbutonu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oyunubaslatbutonu.setText("Oyunu Başlat");
        oyunubaslatbutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oyunubaslatbutonuActionPerformed(evt);
            }
        });

        basitrad.setText("Basit");
        basitrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basitradActionPerformed(evt);
            }
        });

        ortarad.setText("Orta");

        zorrad.setText("Zor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(oyunubaslatbutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ortarad)
                            .addComponent(basitrad)
                            .addComponent(zorrad))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basitrad)
                .addGap(18, 18, 18)
                .addComponent(ortarad)
                .addGap(18, 18, 18)
                .addComponent(zorrad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(oyunubaslatbutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oyunubaslatbutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oyunubaslatbutonuActionPerformed
        OyunEkrani ekran=new OyunEkrani("Uzay Oyunu");
        ekran.setResizable(false);//oynanacak ekranın boyutu değiştirilemesin
        ekran.setFocusable(false);//jframe'e odaklanmasın jpanele odaklansın
        ekran.setSize(800,600);//ekran boyutları
        ekran.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
       Oyun oyun=new Oyun();
        if (basitrad.isSelected()) {
            oyun.setAtesdirY(3);
            oyun.setTopdirX(4);
            
        }
        else if (ortarad.isSelected()) {
            oyun.setAtesdirY(10);
            oyun.setTopdirX(15);
            
        }
        else if (zorrad.isSelected()) {
            oyun.setAtesdirY(45);
            oyun.setTopdirX(25);
        }
        
        oyun.requestFocus();//klavyeden işlemleri almak için kullanırız
        oyun.addKeyListener(oyun);//keylistener bir interfacedir.Klavye işlemlerini anlamak için kullanılır.
        oyun.setFocusable(true);//odağı JPanel'e veririz.
        oyun.setFocusTraversalKeysEnabled(false);//klavye işlemlerini jpanelin anlaması için kullanılır.
        ekran.add(oyun);//Jpanel,jframe'e eklenir.
        this.setVisible(false);
        ekran.setVisible(true);
        
    }//GEN-LAST:event_oyunubaslatbutonuActionPerformed

    private void basitradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basitradActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basitradActionPerformed

    /**
     * @param args the command line arguments
     */
    public void skorgoruntule(){
        model.setRowCount(0);
        ArrayList<Skorlar> skorlar=new ArrayList<Skorlar>( );
        skorlar=veritabanıİslemleri.skorlarigetir();
        
        if(skorlar!=null){
            for(Skorlar skor:skorlar){
                Object[] eklenecek={skor.getSkorlar()};
                 model.addRow(eklenecek);
                
            }
        }
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SkorEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkorEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkorEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkorEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SkorEkrani dialog = new SkorEkrani(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton basitrad;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton ortarad;
    private javax.swing.JButton oyunubaslatbutonu;
    private javax.swing.JTable skor_tablosu;
    private javax.swing.JRadioButton zorrad;
    // End of variables declaration//GEN-END:variables
}
