
import Project.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author tk801
 */
public class ExaminationPage1 extends javax.swing.JFrame {
    String Name;
    String University_Roll_No;
    public String questionID="1";
    public String answer;
    public int min=0;
    public int sec=0;
    public int marks=0; 
    
    
     public void answerCheck()
    {
     String studentAnswer="";
     if(jRadioButton1.isSelected())
     {
         studentAnswer=jRadioButton1.getText();
     }
     
     else if(jRadioButton2.isSelected())
     {
         studentAnswer=jRadioButton2.getText();
     }
     else if(jRadioButton3.isSelected())
     {
         studentAnswer=jRadioButton3.getText();
     }
     else
     {
         studentAnswer=jRadioButton4.getText();   
     }
     if(studentAnswer.equals(answer))
     {
         marks=marks+1;
         String marks1=String.valueOf(marks);
     }
   
     //question number change
       int questionID1= Integer.parseInt(questionID);
         questionID1=questionID1+1;
         questionID=String.valueOf(questionID1);  
     
     //for clear radiobuttons
     jRadioButton1.setSelected(false);
     jRadioButton2.setSelected(false);
     jRadioButton3.setSelected(false);
     jRadioButton4.setSelected(false);
     
     //Last question hide next button
     if(questionID.equals("10"))
     {
         jButton1.setVisible(false);
     }
      
    }
     public void question()
    {
    try{
           Connection con=ConnectionProvider.getcon();
           Statement st=con.createStatement
        (ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
          ResultSet rsq=st.executeQuery("select * from Question where id='"+questionID+"'");
           while(rsq.next())
           {
               jLabel12.setText(rsq.getString(1));
               jLabel13.setText(rsq.getString(2));
               jRadioButton1.setText(rsq.getString(3));
               jRadioButton2.setText(rsq.getString(4));
               jRadioButton3.setText(rsq.getString(5));
               jRadioButton4.setText(rsq.getString(6));
               answer=rsq.getString(7);
               
               
           }
       }
       catch(Exception e)
       {
          JOptionPane.showMessageDialog(null, e);
       }
    }
     
     public void submit()
    {
    String University_Roll_No=jLabel4.getText();
    answerCheck();
    try
    {
      Connection con=ConnectionProvider.getcon();
      Statement st=con.createStatement();
      st.executeUpdate("update student set marks='"+marks+"' where University_Roll_No='"+University_Roll_No+"'");
      String marks1=String.valueOf(marks);
      JOptionPane.showMessageDialog(null, marks1);
    }
    
    catch(Exception e)
    {
     JOptionPane.showMessageDialog(null, e);
    }
    }
     
    
      

    /**
     * Creates new form ExaminationPage1
     */
    Timer time; 
    public ExaminationPage1(String Name, String University_Roll_No) {
        initComponents();
         
        
         try
        {
            Connection con=ConnectionProvider.getcon();
            Statement st=con.createStatement
            (ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery("select Name, University_Roll_No from student where Name='"+Name+"' and University_Roll_No='"+University_Roll_No+"'");
            if(rs.first())
            {
               jLabel2.setText(rs.getString(1));
               jLabel4.setText(rs.getString(2));
            }
            
            ResultSet rsq=st.executeQuery("select * from question where id='"+questionID+"'");
            while(rsq.next())
            {
                jLabel12.setText(rsq.getString(1));
                jLabel13.setText(rsq.getString(2));
                jRadioButton1.setText(rsq.getString(3));
                jRadioButton2.setText(rsq.getString(4));
                jRadioButton3.setText(rsq.getString(5));
                jRadioButton4.setText(rsq.getString(6));
                answer=rsq.getString(7);
            }
            
        }
            
            
                
            
        catch(Exception e)
        {
           
            JOptionPane.showMessageDialog(null, e);

        }
    
     //timer
        
        setLocationRelativeTo(this);
        time=new Timer(1000,new ActionListener(){
           
           public void actionPerformed(ActionEvent e)
       {
           jLabel8.setText(String.valueOf(sec));
           jLabel7.setText(String.valueOf(min));
           if(sec==60)
       {
           sec=0;
           min++;
           if(min==10){
               time.stop();
               answerCheck();
               submit();
           }
           
       }
         sec++;  
       }
           
       });
        time.start();

    }
     
     
      public ExaminationPage1() {
        initComponents();
       
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 1471, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setText("Question demo?");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 50, 966, 50));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, 200, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 208, 200, -1));

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 278, 200, -1));

        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 348, 200, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("NEXT");
        jButton1.setMaximumSize(new java.awt.Dimension(150, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(150, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 506, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setText("PREVIOUS");
        jButton2.setMaximumSize(new java.awt.Dimension(150, 35));
        jButton2.setMinimumSize(new java.awt.Dimension(150, 35));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 506, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.setMaximumSize(new java.awt.Dimension(150, 35));
        jButton3.setMinimumSize(new java.awt.Dimension(150, 35));
        jButton3.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 506, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, 990, 550));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("Total Questions:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 190, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setText("Question Number:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 150, 190, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("10");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 102, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("00");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 102, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, -1, 550));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Online Exam B.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 108));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 13, 350, 45));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel4.setText("123456789012");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 75, 350, 45));

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel3.setText("Time Duration:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 13, 192, 45));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel5.setText("Timer:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 75, 192, 45));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel6.setText("10 Minutes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1021, 13, 118, 45));

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("00");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1021, 74, 50, 47));

        jLabel8.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("00");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1089, 73, 50, 48));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EXamPageBackGround.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton1.isSelected())
        {
          jRadioButton2.setSelected(false); 
          jRadioButton3.setSelected(false); 
          jRadioButton4.setSelected(false); 
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton2.isSelected())
        {
          jRadioButton1.setSelected(false); 
          jRadioButton3.setSelected(false); 
          jRadioButton4.setSelected(false); 
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton3.isSelected())
        {
          jRadioButton2.setSelected(false); 
          jRadioButton1.setSelected(false); 
          jRadioButton4.setSelected(false); 
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton4.isSelected())
        {
          jRadioButton2.setSelected(false); 
          jRadioButton3.setSelected(false); 
          jRadioButton1.setSelected(false); 
          
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String questionID1=jLabel12.getText();
      int questionID2;
        questionID2 = Integer.parseInt(questionID1);
     questionID2=questionID2+1;
     questionID1=String.valueOf(questionID2);
     
     try{
           Connection con=ConnectionProvider.getcon();
           Statement st=con.createStatement
        (ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
          ResultSet rsq=st.executeQuery("select * from Question where id='"+questionID1+"'");
           while(rsq.next())
           {
               jLabel12.setText(rsq.getString(1));
               jLabel13.setText(rsq.getString(2));
               jRadioButton1.setText(rsq.getString(3));
               jRadioButton2.setText(rsq.getString(4));
               jRadioButton3.setText(rsq.getString(5));
               jRadioButton4.setText(rsq.getString(6));
               answer=rsq.getString(7);
               
               
               
               
           }
       }
       catch(Exception e)
       {
          JOptionPane.showMessageDialog(null, e);
       }
     answerCheck();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       String questionID1=jLabel12.getText();
      int questionID2;
        questionID2 = Integer.parseInt(questionID1);
     questionID2=questionID2-1;
     questionID1=String.valueOf(questionID2);
     
     try{
           Connection con=ConnectionProvider.getcon();
           Statement st=con.createStatement
        (ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
          ResultSet rsq=st.executeQuery("select * from Question where id='"+questionID1+"'");
           while(rsq.next())
           {
               jLabel12.setText(rsq.getString(1));
               jLabel13.setText(rsq.getString(2));
               jRadioButton1.setText(rsq.getString(3));
               jRadioButton2.setText(rsq.getString(4));
               jRadioButton3.setText(rsq.getString(5));
               jRadioButton4.setText(rsq.getString(6));
               answer=rsq.getString(7);
               
               
               
               
           }
       }
       catch(Exception e)
       {
          JOptionPane.showMessageDialog(null, e);
       }
     answerCheck();
     jButton2.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         int a=JOptionPane.showConfirmDialog(null, "Do You Really Want To Submit","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            submit();
             System.exit(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ExaminationPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExaminationPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExaminationPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExaminationPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExaminationPage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
