/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;


/**
 *
 * @author John
 */
public final class frm_EmpForm extends javax.swing.JFrame {
SalesAndInventory sai = new SalesAndInventory();
RNG_Sama rngSama = new RNG_Sama();

ResultSet rs = null;
String sql;

//these are the new datatypes...
public String PASSWORD = "password",
        USER_EMPLOYEENAME = "",
        USER_ROLE = "",
        USER_ADDRESS = "",
        USER_EMAIL = "",
        USER_GENDER = "",
        USER_BIRTHDATE = "";
    
    public int EMPLOYEE_ID = 0,
            USER_AGE = 0,
            USER_CONTACTNUMBER = 0;
    public double USER_RATE = 0.0;
    
    public boolean ISADMIN = false,
            ISOLD = false;

    /**
     * Creates new form frm_EmpForm
     */

    ///////////////////////////////////////////////////////////////////////////////////
    public frm_EmpForm() {
        initComponents();
        //BUTTON GROUP        
        ButtonGroup userGender = new ButtonGroup();
        userGender.add(rdMale);
        userGender.add(rdFemale);
        //BUTTON GROUP ^^
        setResizable(false);
        EMPLOYEE_ID = rngSama.RNGmaker();
        txtEmpId.setText(Integer.toString(rngSama.RNGmaker()));
        btnUpdateUserInfo.setVisible(SalesAndInventory.isAdminPresent);
        System.out.println("@ frm_EmpForm.java");
        
    }
    
    ///////////////////////////////////////////
    //this function GENERATES a RANDOM NUMBER//
    ///////////////////////////////////////////
    /*
    protected void RNGmaker(){
        Random randomGenerator = new Random();
        EMPLOYEE_ID = randomGenerator.nextInt(999999999);
        txtEmpId.setText(Integer.toString(EMPLOYEE_ID));
    }*/
    
    ///////////////////////////////////////////////////////////////////
    //THIS FUNCTION just clears the textbox.. this is a void function//
    ///////////////////////////////////////////////////////////////////
    protected void clearTextBoxes(){
        txtEmployeeName.setText(null);
        txtAge.setText(null);
        txtRate.setText(null);
        txtAddress.setText(null);
        txtEmailAddress.setText(null);
        txtContactNumber.setText(null);
        EMPLOYEE_ID = rngSama.RNGmaker();
        txtEmpId.setText(Integer.toString(rngSama.RNGmaker()));
    }
    
    /////////////////////////////////////////////
    //The object parser will get all text FROM //
    //the Fields of Input                      //
    /////////////////////////////////////////////
    protected void objectParser(){
        this.EMPLOYEE_ID = Integer.parseInt(txtEmpId.getText());
        this.USER_EMPLOYEENAME = txtEmployeeName.getText();
        this.USER_ROLE = (String)txtPosition.getSelectedItem();
        this.USER_RATE = Double.parseDouble(txtRate.getText());
        this.USER_ADDRESS = txtAddress.getText();
        this.USER_AGE = Integer.parseInt(txtAge.getText());
        
        this.USER_CONTACTNUMBER = Integer.parseInt(txtContactNumber.getText());
        this.USER_EMAIL = txtEmailAddress.getText();
        if (rdMale.isSelected() == true){
            this.USER_GENDER = "M";
        }else{
            this.USER_GENDER = "F";
        }
        this.USER_ROLE = (String) txtPosition.getSelectedItem();
    }
    
    ////////////////////////////////////////
    //this function DUMPS all the data    //
    //from the objects into the TEXTFIELDS//
    ////////////////////////////////////////
    protected void transferDataToTextField(){
        this.txtEmpId.setText(Integer.toString(this.EMPLOYEE_ID));
        this.txtEmployeeName.setText(this.USER_EMPLOYEENAME);
        this.txtPosition.setSelectedItem(this.USER_ROLE);
        this.txtRate.setText(Double.toString(this.USER_RATE));
        this.txtAddress.setText(this.USER_ADDRESS);
        this.txtAge.setText(Integer.toString(this.USER_AGE));
        this.txtContactNumber.setText(Integer.toString(this.USER_CONTACTNUMBER));
        this.txtEmailAddress.setText(this.USER_EMAIL);
        
        switch (this.USER_GENDER){
        case "M":
            this.rdMale.setSelected(true);
            break;
        case "F":
            this.rdFemale.setSelected(true);
            break;
        }
        this.txtPosition.setSelectedItem(this.USER_ROLE);
    }
    /////////////////////////////////
    //these following functions    //
    //will detect if there are     //
    //STRANGE inputs in the fields //
    /////////////////////////////////
    //TYPE EMAIL
    protected boolean typeEmail(){
        System.out.println("Called typeEmail()");
        
        return (txtEmailAddress.getText()).matches(SalesAndInventory.EMAIL_REGEX);
    }
    //TYPE NUMERIC
    protected boolean typeNumeric(){
        System.out.println("Called typeNumeric()");
        try
        {
            Integer.parseInt(txtContactNumber.getText());
            System.out.println("typeNumeric() = true");
            return true;
        }
        catch (NumberFormatException ex)
        {
            System.out.println("typeNumeric() = false");
            return false;
        }
    }
    
    protected boolean checkTextFields(){
        System.out.println("Called checkTextFields()");
        boolean value = false;
        JTextField fields[]= new JTextField[6];
        fields[0] = txtEmployeeName;
        fields[1] = txtRate;
        fields[2] = txtAddress;
        fields[3] = txtAge;
        fields[4] = txtContactNumber;
        fields[5] = txtEmailAddress;
        for(int i = 0; i < fields.length ;++i) {
            if(fields[i].getText().isEmpty()){
                System.out.println("FIELD["+i+"] NULL!!!");
                value = true;
                break;
            }
        }
        System.out.println("checkTextFields() = " + value);
        /*
        IF VALUE is FALSE, Then FIELDS are not EMPTY
        IF VALUE is TRUE, Then FIELDS are EMPTY
        */
        return value;
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
        btnSearchID = new javax.swing.JButton();
        txtEmpId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        rdFemale = new javax.swing.JRadioButton();
        btnClearAll = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnInsert.setText("Register");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(10, 600, 210, 50);

        btnUpdateUserInfo.setText("Update User (ADMIN)");
        btnUpdateUserInfo.setToolTipText("This button updates the SEARCHED user");
        btnUpdateUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateUserInfo);
        btnUpdateUserInfo.setBounds(130, 540, 200, 50);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(230, 660, 210, 50);

        btnSearchID.setText("Search User ID");
        btnSearchID.setToolTipText("");
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchID);
        btnSearchID.setBounds(10, 660, 210, 50);

        txtEmpId.setEditable(false);
        txtEmpId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEmpId);
        txtEmpId.setBounds(140, 100, 200, 30);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("employee registration");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 10, 390, 60);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Employee Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 210, 100, 20);

        txtEmployeeName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEmployeeName);
        txtEmployeeName.setBounds(140, 200, 200, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 330, 50, 16);

        txtAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtAddress);
        txtAddress.setBounds(140, 320, 200, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Contact Number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 390, 100, 16);

        txtContactNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtContactNumber);
        txtContactNumber.setBounds(140, 380, 200, 30);

        txtEmailAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEmailAddress);
        txtEmailAddress.setBounds(140, 410, 200, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email Address");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 420, 90, 16);

        rdMale.setText("Male");
        getContentPane().add(rdMale);
        rdMale.setBounds(170, 460, 60, 25);

        jLabel9.setText("Gender");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(90, 460, 80, 16);

        rdFemale.setText("Female");
        getContentPane().add(rdFemale);
        rdFemale.setBounds(230, 460, 100, 25);

        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearAll);
        btnClearAll.setBounds(230, 600, 210, 50);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("EMPLOYEE ID");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(180, 80, 110, 16);

        txtAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtAge);
        txtAge.setBounds(140, 350, 200, 30);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Age");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(80, 360, 48, 16);

        txtPosition.setMaximumRowCount(3);
        txtPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier" }));
        txtPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPositionActionPerformed(evt);
            }
        });
        getContentPane().add(txtPosition);
        txtPosition.setBounds(140, 230, 200, 30);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Position");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(80, 240, 48, 16);

        txtRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtRate);
        txtRate.setBounds(140, 260, 200, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Rate");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 270, 41, 16);

        setSize(new java.awt.Dimension(469, 769));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        //////////////////////////////////////////////
        //THIS IS THE INSERTION OF THE SQL STRING   //
        //INTO THE DATABASE                         //
        //////////////////////////////////////////////
        typeNumeric();
        if (checkTextFields() == false && typeNumeric() == true && typeEmail()== true ){
            objectParser();
            sql = "INSERT INTO `user_reg`(`employee_id`, `password`, `isAdmin`,`isOld`, `user_EmployeeName`, `user_Role`, `user_Rate`, `user_Address`, `user_Age`, `user_ContactNumber`, `user_Email`, `user_Gender`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pStmt = sai.chainSmokersConnection().prepareStatement(sql);
                //NEED TO MODIFY THIS THING AGAIN!!
                pStmt.setInt (1, EMPLOYEE_ID);
                pStmt.setString (2, PASSWORD);
                pStmt.setBoolean (3, ISADMIN);
                pStmt.setBoolean (4, ISOLD);
                pStmt.setString (5, USER_EMPLOYEENAME);
                pStmt.setString (6, USER_ROLE);
                pStmt.setDouble (7, USER_RATE);
                pStmt.setString (8, USER_ADDRESS);
                pStmt.setInt (9, USER_AGE);
                pStmt.setInt (10, USER_CONTACTNUMBER);
                pStmt.setString (11, USER_EMAIL);
                pStmt.setString (12, USER_GENDER);
                pStmt.execute();
                
                JOptionPane.showMessageDialog(null,"Successfull registration for USER: "+Integer.toString(EMPLOYEE_ID));
                pStmt.close();
                sai.chainSmokersConnection().close();
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        //this clears the textboxes..... obviously
        clearTextBoxes();
        
        txtEmpId.setText(Integer.toString(EMPLOYEE_ID));
        }//END of IF segment
        else{
           JOptionPane.showMessageDialog(null, "One or more of the fields don't have a correct input...\nPlease re-check ALL the fields and ensure that they have the correct input...");
        }
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserInfoActionPerformed
        ///////////////////////////////////////////////////////////////////////
        //THIS CODE HERE IS FOR UPDATING THE DATABASE WITH THE NEW USERINFO  //
        //THE CURRENT PROBLEMS ARE THE UNRELIBILITY OF THE SQL CONNECTION... //
        ///////////////////////////////////////////////////////////////////////
        objectParser();
        if (checkTextFields() == false && typeNumeric() == true && typeEmail()== true){
        sql = "UPDATE user_reg SET password = ?, user_EmployeeName = ?, user_Role = ?, user_Rate = ?, user_Address = ?, user_Age = ?, user_ContactNumber = ?, user_Email = ?, user_Gender = ? WHERE employee_Id = ?";
        try{
            objectParser();
            PreparedStatement pStmt;
            pStmt = sai.chainSmokersConnection().prepareStatement(sql);
            pStmt.setString (1, PASSWORD);
            pStmt.setString (2, USER_EMPLOYEENAME);
            pStmt.setString (3, USER_ROLE);
            pStmt.setDouble (4, USER_RATE);
            pStmt.setString (5, USER_ADDRESS);
            pStmt.setDouble (6, USER_AGE);
            pStmt.setInt (7, USER_CONTACTNUMBER);
            pStmt.setString (8, USER_EMAIL);
            pStmt.setString (9, USER_GENDER);
            pStmt.setString (10, USER_EMAIL);
            pStmt.setString (11, USER_GENDER);
            pStmt.setInt (12, EMPLOYEE_ID);
            pStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Success for USER: "+EMPLOYEE_ID);
            sai.chainSmokersConnection().close();
            pStmt.close();
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        clearTextBoxes();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please fill up all the fields correctly... \n\ndo it for the puppy --> (^・x・^)");
        }
    }//GEN-LAST:event_btnUpdateUserInfoActionPerformed

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
    try {
        String anotherString =  JOptionPane.showInputDialog("Type in the ID / NAME you are looking for... ");
        
        if (anotherString != null){
            sql = "SELECT * FROM user_reg WHERE (employee_Id = '"+anotherString+"') OR (user_EmployeeName = '"+anotherString+"')";
            Statement stmt = sai.chainSmokersConnection().createStatement();
            ResultSet qqrs = stmt.executeQuery(sql);
            while(qqrs.next()){
                txtEmpId.setText(qqrs.getString("employee_Id"));
                txtEmployeeName.setText(qqrs.getString("user_EmployeeName"));
                txtRate.setText(Double.toString(qqrs.getDouble("user_Rate")));
                txtAddress.setText(qqrs.getString("user_Address"));
                txtAge.setText(Integer.toString(qqrs.getInt("user_Age")));
                txtContactNumber.setText(Integer.toString(qqrs.getInt("user_ContactNumber")));
                txtEmailAddress.setText(qqrs.getString("user_Email"));
                txtPosition.setSelectedItem(qqrs.getString("user_Role"));
                switch (qqrs.getString("user_Gender")){
                    case "M":
                        this.rdMale.setSelected(true);
                        break;
                    case "F":
                        this.rdFemale.setSelected(true);
                        break;
                }
            }
            qqrs.close();
            stmt.close();
            sai.chainSmokersConnection().close();
        }else{
            JOptionPane.showMessageDialog(null, rs);
            JOptionPane.showMessageDialog(null, "Please enter non-NULL data");
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(frm_EmpForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        frm_mainmenu openThis = new frm_mainmenu();
        openThis.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        clearTextBoxes();
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void txtPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionActionPerformed

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
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JButton btnUpdateUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtEmpId;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JComboBox<String> txtPosition;
    private javax.swing.JTextField txtRate;
    // End of variables declaration//GEN-END:variables

    private boolean isNumeric(String searchThisID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
