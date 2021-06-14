
import java.awt.Color;
import java.awt.Graphics;

public class DrawLine extends javax.swing.JFrame {

    
    public DrawLine() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("X =");

        jLabel2.setText("Y = ");

        jButton1.setText("Zīmēt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

                Graphics G = jPanel1.getGraphics();
                G.setColor(Color.red);
                G.drawLine(jPanel1.getWidth()/2, 0, jPanel1.getWidth()/2, jPanel1.getHeight());
                G.drawLine(0, jPanel1.getHeight()/2, jPanel1.getWidth(), jPanel1.getHeight()/2);
                G.setColor(Color.black);
                
                int xsp = jPanel1.getWidth()/2;
                int ysp = jPanel1.getHeight()/2;
                int xg, yg;
                xg = Integer.parseInt(jTextField1.getText());
                yg = Integer.parseInt(jTextField2.getText());
                int dx = Math.abs(xg - xsp);
                int dy = Math.abs(yg - ysp);
                
                int xs, ys;
                
                if(xsp < xg) xs = 1;
                else xs = -1;
                if(ysp < yg) ys = 1;
                else ys = -1;
                
                if(dx > dy)
                {
                int p = 2*dy - dx;
                while (xsp != xg)
                     {
                         if (p > 0){ xsp = xsp + xs; ysp = ysp + ys; G.drawRect(xsp , ysp, 0, 0); p = p + 2* dy - 2*dx;}
                         else {xsp = xsp + xs; G.drawRect(xsp, ysp, 0, 0); p = p + 2*dy;}
                     }
                }
 
                else 
                {
                int p = 2*dx - dy;
                while (ysp != yg)
                     {
                         if (p > 0){ xsp = xsp + xs; ysp = ysp + ys; G.drawRect(xsp , ysp, 0, 0); p = p + 2* dx - 2*dy;}
                         else {ysp = ysp + ys; G.drawRect(xsp, ysp, 0, 0); p = p + 2*dx;}
                     }
                }
                G.dispose();
                              
    }//GEN-LAST:event_jButton1ActionPerformed
    int Xs, Ys,  i = 0;
    int Xg, Yg;
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
       
            if (i == 0)
        {
            Xs = evt.getX();
            Ys = evt.getY();
            i = 1;
        }
        else 
        {
         Xg = evt.getX();
         Yg = evt.getY();
         
         Graphics g = jPanel1.getGraphics();
         
         g.drawLine(Xs, Ys, Xg, Yg); // Brezenhema algoritms iepriekš jau pareizi darbojas, tāpēc te tiek pielietots saīsinātais(iebūvētais) taisnes zīmēšanas veids
         
         i = 0;       
         
         g.dispose();
        }
    }//GEN-LAST:event_jPanel1MouseClicked

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawLine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
