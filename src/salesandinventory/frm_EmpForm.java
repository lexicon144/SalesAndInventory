/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

/**
 *
 * @author John
 */
public final class frm_EmpForm extends javax.swing.JFrame {
SalesAndInventory sai = new SalesAndInventory();

ResultSet rs = null;
PreparedStatement pStmt = null;

int userId = 0,tempUserID = 0;
String  fname = "",
        mname = "",
        lname = "",
        gender = "",
        birthday = "",
        birthplace = "",
        address = "",
        email = "",
        contactnum = "",
        username = "",
        password = "",
        searchThisID = "";
Boolean isAdmin = true;
    /**
     * Creates new form frm_EmpForm
     */


    public frm_EmpForm() {
        initComponents();
        //BUTTON GROUP        
        ButtonGroup userType = new ButtonGroup();
        userType.add(rdAdmin);
        userType.add(rdEmp);
        ButtonGroup userGender = new ButtonGroup();
        userGender.add(rdMale);
        userGender.add(rdFemale);
        //BUTTON GROUP ^^
        setResizable(false);
        
        RNGmaker();
    }
    
    public void RNGmaker(){
        Random randomGenerator = new Random();
        tempUserID = randomGenerator.nextInt(999999999);
        txtUserID.setText(Integer.toString(tempUserID));
        userId = 0;
    }
    public void clearTextBoxes(){
        txtFirstName.setText(null);
        txtMiddleName.setText(null);
        txtLastName.setText(null);
        txtBirthDate.setText(null);
        txtBirhtPlace.setText(null);
        txtAddress.setText(null);
        txtEmailAddress.setText(null);
        btnContactNumber.setText(null);
        txtUsername.setText(null);
        txtPassword.setText(null);
    }
    public void objectParser(){
        if (rdAdmin.isSelected()){
            isAdmin = true;            
        }
        else{
            isAdmin = false;
        }
        if (rdMale.isSelected()){
            gender = "M";
        }
        else{
            gender = "F";
        }
        fname = txtFirstName.getText();
        mname = txtMiddleName.getText();
        lname = txtLastName.getText();
        birthday = txtBirthDate.getText();
        birthplace = txtBirhtPlace.getText();
        address = txtAddress.getText();
        email = txtEmailAddress.getText();
        contactnum = btnContactNumber.getText();
        username = txtUsername.getText();
        password = txtPassword.getText();
    }
    public void transferDataToTextField(){
    switch (gender) {
        case "M":
            rdMale.setSelected(true);
            break;
        case "F":
            rdFemale.setSelected(true);
            break;
    }
        txtFirstName.setText(fname);
        txtMiddleName.setText(mname);
        txtLastName.setText(lname);
        txtAddress.setText(address);
        txtBirthDate.setText(birthday);
        txtBirhtPlace.setText(birthplace);
        txtEmailAddress.setText(email);
        btnContactNumber.setText(contactnum);
        txtUsername.setText(username);
        txtPassword.setText(password);
        txtUserID.setText(Integer.toString(userId));
        if (isAdmin == true){
        rdAdmin.setSelected(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsert = new javax.swing.JButton();
        btnUpdateUserInfo = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearchID = new javax.swing.JButton();
        txtUserID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdAdmin = new javax.swing.JRadioButton();
        rdEmp = new javax.swing.JRadioButton();
        txtPassword = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtBirthDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBirhtPlace = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnContactNumber = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        rdFemale = new javax.swing.JRadioButton();
        btnClearAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnInsert.setText("Register");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(40, 580, 130, 50);

        btnUpdateUserInfo.setText("Update User Info");
        btnUpdateUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateUserInfo);
        btnUpdateUserInfo.setBounds(180, 580, 160, 50);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(260, 640, 210, 50);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(420, 180, 0, 2);

        btnSearchID.setText("Search User ID");
        btnSearchID.setToolTipText("");
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchID);
        btnSearchID.setBounds(40, 640, 210, 50);

        txtUserID.setEditable(false);
        txtUserID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtUserID);
        txtUserID.setBounds(190, 100, 140, 30);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("employee registration");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(70, 10, 390, 60);

        rdAdmin.setText("Type: Admin");
        getContentPane().add(rdAdmin);
        rdAdmin.setBounds(190, 210, 120, 24);

        rdEmp.setText("Type: Employee");
        getContentPane().add(rdEmp);
        rdEmp.setBounds(190, 230, 120, 24);

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(260, 160, 120, 30);

        jLabel11.setText("Password");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(290, 140, 60, 16);

        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(150, 160, 110, 30);

        jLabel10.setText("Username");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(180, 140, 70, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 340, 70, 16);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("First Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 280, 100, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Middle Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 310, 80, 16);

        txtMiddleName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMiddleName);
        txtMiddleName.setBounds(170, 300, 200, 30);

        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtFirstName);
        txtFirstName.setBounds(170, 270, 200, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 370, 50, 16);

        txtAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtAddress);
        txtAddress.setBounds(170, 360, 200, 30);

        txtBirthDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBirthDate);
        txtBirthDate.setBounds(170, 390, 200, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Birthdate");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 400, 60, 16);

        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtLastName);
        txtLastName.setBounds(170, 330, 200, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Birth Place");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 460, 70, 16);

        txtBirhtPlace.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBirhtPlace);
        txtBirhtPlace.setBounds(170, 450, 200, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Contact Number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 430, 100, 16);

        btnContactNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(btnContactNumber);
        btnContactNumber.setBounds(170, 420, 200, 30);

        txtEmailAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEmailAddress);
        txtEmailAddress.setBounds(170, 480, 200, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email Address");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 490, 90, 16);

        rdMale.setText("Male");
        getContentPane().add(rdMale);
        rdMale.setBounds(170, 520, 51, 24);

        jLabel9.setText("Gender");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 520, 41, 16);

        rdFemale.setText("Female");
        getContentPane().add(rdFemale);
        rdFemale.setBounds(230, 520, 67, 24);

        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearAll);
        btnClearAll.setBounds(350, 580, 120, 50);

        setSize(new java.awt.Dimension(534, 764));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        objectParser();
        sai.sql = "INSERT INTO `user_reg`(`Username`, `Password`, `isAdmin`, `user_id`, `user_FirstName`, `user_MiddleName`, `user_LastName`, `user_Address`, `user_Email`, `user_Gender`, `user_Birthdate`, `user_BirthPlace`, `user_ContactNumber`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sandv","root","iamgroot");
            
                pStmt = con.prepareStatement(sai.sql);
                pStmt.setString (1, username);
                pStmt.setString (2, password);
                pStmt.setBoolean (3, isAdmin);
                pStmt.setInt (4, userId);
                pStmt.setString (5, fname);
                pStmt.setString (6, mname);
                pStmt.setString (7, lname);
                pStmt.setString (8, address);
                pStmt.setString (9, email);
                pStmt.setString (10, gender);
                pStmt.setString (11, birthday);
                pStmt.setString (12, birthplace);
                pStmt.setString (13, contactnum);
                pStmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registration Success!!");
                 
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        clearTextBoxes();
        
        txtUserID.setText(Integer.toString(userId));
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserInfoActionPerformed
        // TODO add your handling code here:
        
        objectParser();
        sai.sql = "UPDATE user_reg SET Username = ?,Password = ?,isAdmin = ?,user_FirstName = ?,user_MiddleName = ?, user_LastName = ?, user_Address = ?,user_Email = ?,user_Gender = ?,user_Birthdate = ?,user_BirthPlace = ?,user_ContactNumber = ? WHERE user_id = ?";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sandv","root","iamgroot")) {
                
                objectParser();
                
                pStmt = con.prepareStatement(sai.sql);
                pStmt.setString (1, username);
                pStmt.setString (2, password);
                pStmt.setBoolean (3, isAdmin);
                pStmt.setString (4, fname);
                pStmt.setString (5, mname);
                pStmt.setString (6, lname);
                pStmt.setString (7, address);
                pStmt.setString (8, email);
                pStmt.setString (9, gender);
                pStmt.setString (10, birthday);
                pStmt.setString (11, birthplace);
                pStmt.setString (12, contactnum);
                pStmt.setInt (13, userId);
                pStmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registration Success!!");
                con.close();
            }         
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        clearTextBoxes();
    }//GEN-LAST:event_btnUpdateUserInfoActionPerformed

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        // TODO add your handling code here:
        //Need to do more arguments here
        searchThisID =  JOptionPane.showInputDialog("Type in the ID you are looking for... ");
        if (searchThisID != null){ //START OF NO NULL INPUT!
            try{
                tempUserID = Integer.parseInt(searchThisID);
            sai.sql = "SELECT * FROM user_reg WHERE user_id = '" + tempUserID + "'";
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sandv","root","iamgroot")) {
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(sai.sql);
                
                if(rs.next()){//IF USER EXISTS!!
                JOptionPane.showMessageDialog(null,"The userID " + tempUserID + " Exists");
                username = rs.getString("Username");
                password =rs.getString("Password");
                fname = rs.getString("user_FirstName");
                mname = rs.getString("user_MiddleName");
                lname = rs.getString("user_LastName");
                birthday = rs.getString("user_Birthdate");
                birthplace = rs.getString("user_BirthPlace");
                address = rs.getString("user_Address");
                email = rs.getString("user_Email");
                contactnum = rs.getString("user_ContactNumber");
                userId = rs.getInt("user_id");
                isAdmin = rs.getBoolean("isAdmin");
                gender = rs.getString("user_Gender");
               
                transferDataToTextField();
                
                con.close();
                }
                else{//IF USER ID DOESNT EXIST
                    JOptionPane.showMessageDialog(null, "This user doesnt Exist!!");
                }
            }         
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }//END OF NO NULL
        else{
            JOptionPane.showMessageDialog(null,"Srsly nigga?");
        }
        //up to here
       
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        frm_mainmenu openThis = new frm_mainmenu();
        openThis.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        RNGmaker();
        clearTextBoxes();
    }//GEN-LAST:event_btnClearAllActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_EmpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_EmpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JTextField btnContactNumber;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JButton btnUpdateUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdAdmin;
    private javax.swing.JRadioButton rdEmp;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirhtPlace;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private boolean isNumeric(String searchThisID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
