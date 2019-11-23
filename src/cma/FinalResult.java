
package cma;
 
import java.io.*;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class FinalResult extends javax.swing.JFrame {

   
    public String match_name,match_result,team1,team2;
    public int score1,wickets1,score2,wickets2,difference_score,difference_wickets;
    Statement stmt=null;
    
    public FinalResult() {
        initComponents();      
        calculation();   
    }
    
    
    public void database() throws ClassNotFoundException{
        
            try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String CMA = "jdbc:derby://localhost:1527/CMA";
            Connection DBconn = DriverManager.getConnection(CMA, "cma","cma");
            
              stmt = DBconn.createStatement();
              
              stmt.executeUpdate("INSERT INTO MATCHES (match_name,team1_name,team2_name,team1_score,team2_score,team1_sixes,team2_sixes,team1_fours,team2_fours,team1_wickets,team2_wickets,match_result) VALUES('"+this.match_name+"','"+this.team1+"','"+this.team2+"','"+this.score1+"','"+this.score2+"','"+SixesTeam1.final_sixes1+"','"+SixesTeam2.final_sixes2+"','"+FoursTeam1.final_fours1+"','"+FoursTeam2.final_fours2+"','"+this.wickets1+"','"+this.wickets2+"','"+this.match_result+"')");
           
              JOptionPane.showMessageDialog(null,"Updated to Database Successfully!");
            }
         catch(SQLException err)
            {
                System.out.println(err.getMessage()); 
            } 

                
    }

    
    public void calculation(){
        
        team1=(MainForm.Team1);
        team2=(MainForm.Team2);
        score1=(ScoreTeam1.final_score1);
        score2=(ScoreTeam2.final_score2);
        wickets1=(ScoreTeam1.final_wicket1);
        wickets2=(ScoreTeam2.final_wicket1);
        
        match_name=team1+" vs "+team2;
        
        
        jLabel2.setText(team1);
        jLabel3.setText(team2);
        jLabel6.setText(score1+" / "+wickets1);
        jLabel7.setText(score2+" / "+wickets2);
        
        if(score1>score2)
        {
            difference_score=score1-score2;
            match_result=team1+" HAVE WON THE MATCH BY "+difference_score+" RUNS!";
            jLabel4.setText(match_result);
        }
      
        else if(score1==score2)
        {
            match_result="THE MATCH IS TIED!";
            jLabel4.setText(match_result);
        }
        else
        {
            difference_wickets=10-wickets2;
            match_result=team2+" HAVE WON THE MATCH WITH "+difference_wickets+" WICKETS IN HAND!";
            jLabel4.setText(match_result);
              
        }
        
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FINAL RESULT");

        jLabel2.setText("TEAM NAME 1");

        jLabel3.setText("TEAM NAME 2");

        jLabel4.setText("TEAM NAME 1 HAS WON THE MATCH WITH _ WICKETS");

        jLabel6.setText("SCORE/WICKETS");

        jLabel7.setText("SCORE/WICKETS");

        jButton1.setText("UPDATE TO DATABASE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(333, 333, 333))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(279, 279, 279))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(216, 216, 216))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
                database();
                }
                catch(ClassNotFoundException err)
                {
                    System.out.println(err);
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(FinalResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalResult().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
