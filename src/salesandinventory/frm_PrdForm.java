 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author John
 */
public class frm_PrdForm extends javax.swing.JFrame {
SalesAndInventory sai = new SalesAndInventory();
dataForTableBuilding hatsune = new dataForTableBuilding();
RNG_Sama rngSama = new RNG_Sama();
//These will be variable declarations    
ResultSet rs;
    int prdID=0,tempPrdID=0,prdQuantity=0;
    boolean value = false;
    Double tempPrice;
    String prdName = "",
     prdDesc = "",
     prdManufacturer="",
     prdSupplier="",
     cmbValue="",
     searchThisID = "";
    
    Double prdTotalPrice=0.0, prdDiscountedPrice=0.0,prdOriginalPrice=0.0,tempStorage = 0.0,discount = 0.0;
//this will be the end of the variable declarations.... 
    /////////////////////////////////////////////////
    /**
     * Creates new form frm_PrdForm
     */
    public frm_PrdForm() {
        initComponents();
        tempPrdID = rngSama.RNGmaker();
        txtBarcode.setText(Integer.toString(rngSama.RNGmaker()));
        txtBarcode.setText(Integer.toString(tempPrdID));
        setResizable(false);
        btn_UpdatePrd.setVisible(SalesAndInventory.isAdminPresent);
        System.out.println("@ frm_PrdForm.java");
    }
    ///////////////////////
    //this VOID function
    //just generates a 
    //RANDOM NUMBER    
    //for the PRODUCT ID
    ///////////////////////
    /*
    private void rng(){
        Random randomGenerator = new Random();
        tempPrdID = randomGenerator.nextInt(999999999);
        txtBarcode.setText(Integer.toString(tempPrdID));
    }*/
    //this VOID function just clears the TEXTBOXES
    private void clearTextBoxes(){
        txtPrdDesc.setText(null);
        txtPrdName.setText(null);
        txtPrdManufacturer.setText(null);
        txtPrdOriginalPrice.setText(null);
        txtPrdTotalPrice.setText(null);
        txtPrdQuantity.setText(null);
        txtPrdSupplier.setText(null);
        txtPrdDIscountedPrice.setText(null);
    }
    
    //this FUNCTION will compute the price for the PRODUCT
    //especially when they need to compute for the...
    //TOTAL PRICE, ORIGINAL PRICE, DISCOUNT, and DISCOUNTED PRICE
    private void returnValue4TotalPrice(){
        DecimalFormat cmbFormat = new DecimalFormat("#.00");
        prdOriginalPrice = Double.parseDouble(txtPrdOriginalPrice.getText());
        prdQuantity = Integer.parseInt(txtPrdQuantity.getText());
        prdTotalPrice = (
                prdOriginalPrice * (double) prdQuantity
        );
        prdDiscountedPrice = prdOriginalPrice - (prdOriginalPrice * discount);
        txtPrdTotalPrice.setText(cmbFormat.format(prdTotalPrice));
        txtPrdDIscountedPrice.setText(cmbFormat.format(prdDiscountedPrice));
    }
    
    //this VOID funcition ill DUMP All TEXTFIELD DATA
    //into the set of OBJECTS
    private void objectParser(){
        prdID = Integer.parseInt(txtBarcode.getText());
        prdQuantity = Integer.parseInt(txtPrdQuantity.getText());
        prdName = txtPrdName.getText();
        prdDesc = txtPrdDesc.getText();
        prdManufacturer = txtPrdManufacturer.getText();
        prdSupplier = txtPrdSupplier.getText();
        prdTotalPrice = Double.parseDouble(txtPrdTotalPrice.getText());
        prdDiscountedPrice = Double.parseDouble(txtPrdDIscountedPrice.getText());
        prdOriginalPrice = Double.parseDouble(txtPrdOriginalPrice.getText());
    }
    
    //This BOOLEAN function WILL GET ALL OF THE TEXTFIELDS
    //then put them into an OBJECT array (which you could see here)
    //...is an ARRAY of TEXTFIELDS;
    private boolean checkTextFields(){
        JTextField fields[]= new JTextField[7];
        fields[0] = txtBarcode;
        fields[1] = txtPrdDesc;
        fields[2] = txtPrdName;
        fields[3] = txtPrdManufacturer;
        fields[4] = txtPrdOriginalPrice;
        fields[5] = txtPrdTotalPrice;
        fields[6] = txtPrdDIscountedPrice;
        
        for(int i = 0; i < fields.length ;++i) {
            if(fields[i].getText().isEmpty()){
                System.out.println("FIELD["+i+"] NULL!!!");
                value = true;
            }
        }
        System.out.println("checkTextFields() = " + value);
        //IF VALUE is FALSE, Then FIELDS are not EMPTY
        //IF VALUE is TRUE, Then FIELDS are EMPTY
        return value;
    }
    //This Function DUMPS data FROM the objects INTO the TEXTFIELDS
    private void transferData2TextField(){
        txtBarcode.setText(Integer.toString(prdID));
        txtPrdQuantity.setText(Integer.toString(prdQuantity));
        txtPrdName.setText(prdName);
        txtPrdDesc.setText(prdDesc);
        txtPrdManufacturer.setText(prdManufacturer);
        txtPrdSupplier.setText(prdSupplier);
        txtPrdTotalPrice.setText(Double.toString(prdTotalPrice));
        txtPrdDIscountedPrice.setText(Double.toString(prdDiscountedPrice));
        txtPrdOriginalPrice.setText(Double.toString(prdOriginalPrice));
        if(discount == 0.05)
            cmbDiscountPrice.setSelectedItem("5%");
        else if(discount == 0.1)
            cmbDiscountPrice.setSelectedItem("10%");
        else if(discount == 0.25)
            cmbDiscountPrice.setSelectedItem("25%");
        else{
            System.out.println("Threw discount exception");
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

        browse_Manufacturer = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Manufacturer = new javax.swing.JTable();
        btnUseThisManufacturer = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        browse_Supplier = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_supplier = new javax.swing.JTable();
        btnUseThisSupplier = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnRegisterPRD = new javax.swing.JButton();
        btn_UpdatePrd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtBarcode = new javax.swing.JTextField();
        txtPrdName = new javax.swing.JTextField();
        txtPrdManufacturer = new javax.swing.JTextField();
        txtPrdDesc = new javax.swing.JTextField();
        txtPrdSupplier = new javax.swing.JTextField();
        txtPrdQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrdOriginalPrice = new javax.swing.JTextField();
        txtPrdTotalPrice = new javax.swing.JTextField();
        txtPrdDIscountedPrice = new javax.swing.JTextField();
        cmbDiscountPrice = new javax.swing.JComboBox();
        btnClearAll = new javax.swing.JButton();
        btnSearchID = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBrowseManufacturer = new javax.swing.JButton();
        btnBrowseSupplier = new javax.swing.JButton();

        browse_Manufacturer.setAlwaysOnTop(true);
        browse_Manufacturer.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        browse_Manufacturer.setMinimumSize(new java.awt.Dimension(468, 399));
        browse_Manufacturer.setResizable(false);
        browse_Manufacturer.setType(java.awt.Window.Type.POPUP);
        browse_Manufacturer.getContentPane().setLayout(null);

        table_Manufacturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Manufacturer ID", "Manufacturer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_Manufacturer);

        browse_Manufacturer.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 80, 350, 210);

        btnUseThisManufacturer.setText("Use This!!");
        btnUseThisManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseThisManufacturerActionPerformed(evt);
            }
        });
        browse_Manufacturer.getContentPane().add(btnUseThisManufacturer);
        btnUseThisManufacturer.setBounds(150, 320, 140, 40);

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel13.setText("Browse Manufacturers...");
        browse_Manufacturer.getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 10, 430, 50);

        browse_Supplier.setAlwaysOnTop(true);
        browse_Supplier.setMinimumSize(new java.awt.Dimension(421, 351));
        browse_Supplier.setResizable(false);
        browse_Supplier.setType(java.awt.Window.Type.POPUP);
        browse_Supplier.getContentPane().setLayout(null);

        table_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_supplier);

        browse_Supplier.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 360, 160);

        btnUseThisSupplier.setText("Use This Supplier");
        btnUseThisSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseThisSupplierActionPerformed(evt);
            }
        });
        browse_Supplier.getContentPane().add(btnUseThisSupplier);
        btnUseThisSupplier.setBounds(120, 280, 180, 50);

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel12.setText("Browse Suppliers...");
        browse_Supplier.getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 20, 340, 52);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnRegisterPRD.setText("Register Product");
        btnRegisterPRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterPRDActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegisterPRD);
        btnRegisterPRD.setBounds(10, 540, 130, 50);

        btn_UpdatePrd.setText("Update Product");
        btn_UpdatePrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdatePrdActionPerformed(evt);
            }
        });
        getContentPane().add(btn_UpdatePrd);
        btn_UpdatePrd.setBounds(150, 540, 130, 50);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(220, 600, 200, 50);

        txtBarcode.setEditable(false);
        txtBarcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBarcode);
        txtBarcode.setBounds(200, 60, 170, 30);

        txtPrdName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdName);
        txtPrdName.setBounds(200, 110, 170, 30);

        txtPrdManufacturer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrdManufacturer.setToolTipText("");
        getContentPane().add(txtPrdManufacturer);
        txtPrdManufacturer.setBounds(200, 170, 170, 30);

        txtPrdDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdDesc);
        txtPrdDesc.setBounds(200, 140, 170, 30);

        txtPrdSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdSupplier);
        txtPrdSupplier.setBounds(200, 240, 170, 30);

        txtPrdQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdQuantity);
        txtPrdQuantity.setBounds(200, 310, 170, 30);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("product registration");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 0, 350, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Barcode");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 50, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Product Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 120, 80, 16);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Product Description");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 150, 110, 16);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Product Manufacturer");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 180, 130, 16);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Product Supplier");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 250, 100, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Quantity");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(100, 320, 80, 16);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Original Price");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(110, 350, 80, 16);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total Price");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 380, 80, 16);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Discount");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(140, 410, 50, 16);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Discounted Price");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(90, 440, 100, 20);

        txtPrdOriginalPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdOriginalPrice);
        txtPrdOriginalPrice.setBounds(200, 340, 170, 30);

        txtPrdTotalPrice.setEditable(false);
        txtPrdTotalPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdTotalPrice);
        txtPrdTotalPrice.setBounds(200, 370, 170, 30);

        txtPrdDIscountedPrice.setEditable(false);
        txtPrdDIscountedPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrdDIscountedPrice);
        txtPrdDIscountedPrice.setBounds(200, 430, 170, 30);

        cmbDiscountPrice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "5%", "10%", "25%" }));
        getContentPane().add(cmbDiscountPrice);
        cmbDiscountPrice.setBounds(200, 400, 170, 30);

        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearAll);
        btnClearAll.setBounds(290, 540, 130, 50);

        btnSearchID.setText("Search Product");
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchID);
        btnSearchID.setBounds(10, 600, 200, 50);

        jButton1.setText("Compute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 470, 170, 25);

        btnBrowseManufacturer.setText("Browse Manufactures");
        btnBrowseManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseManufacturerActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowseManufacturer);
        btnBrowseManufacturer.setBounds(200, 200, 170, 25);

        btnBrowseSupplier.setText("Browse Suppliers");
        btnBrowseSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowseSupplier);
        btnBrowseSupplier.setBounds(200, 270, 170, 25);

        setSize(new java.awt.Dimension(451, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterPRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterPRDActionPerformed
        // TODO add your handling code here:
        
        if (checkTextFields() == false){ //IF THE INPUT ISNT NULL
            
        sai.sql = "INSERT INTO `prod_reg`(`prdId`, `prdName`, `prdDesc`, `prdManufacturer`, `prdSupplier`, `prdQuantity`, `prdPrice`, `prdTotalPrice`, `prdDiscount`, `prdDiscountedPrice`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            
            //SET DATA FOR THE OBJECTS
            objectParser();
            //END OF SETTING THE DATA
            /*
            aT This part we will try to find out if we could detect a duplicate
            */
            sai.pStmt = sai.chainSmokersConnection().prepareStatement(sai.sql);  //THis is the PREPARED STATEMENT we will be using
                /*
                SAI is the OBJECT for the instance of the SalesAndInventory Class
                */                
                sai.pStmt.setInt (1, prdID);
                sai.pStmt.setString (2, prdName);
                sai.pStmt.setString (3, prdDesc);
                sai.pStmt.setString (4, prdManufacturer);
                sai.pStmt.setString (5, prdSupplier);
                sai.pStmt.setInt (6, prdQuantity);
                sai.pStmt.setDouble (7, prdOriginalPrice);
                sai.pStmt.setDouble (8, prdTotalPrice);
                sai.pStmt.setDouble (9, discount);
                sai.pStmt.setDouble (10, prdDiscountedPrice);
                sai.pStmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registration Success!!");
                 
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        clearTextBoxes();
        rngSama.RNGmaker();
        }
        else{
        JOptionPane.showMessageDialog(null, "One or more of the fields don't have a correct input...\nPlease re-check ALL the fields and ensure that they have the correct input...");
        }
    }//GEN-LAST:event_btnRegisterPRDActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        frm_mainmenu openMe = new frm_mainmenu();
        openMe.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // TODO add your handling code here:
        clearTextBoxes();
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cmbValue = cmbDiscountPrice.getSelectedItem().toString();
        switch(cmbValue){
            case "5%":
                discount = 0.05;
                returnValue4TotalPrice();
                break;
            case "10%":
                discount = 0.10;
                returnValue4TotalPrice();
                break;
            case "25%":
                discount = 0.25;
                returnValue4TotalPrice();
                break;
            case "SELECT":
            default:
                JOptionPane.showMessageDialog(null,"Select a value.... please...\ndo it for the puppy --> (^・x・^)");
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_UpdatePrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdatePrdActionPerformed
        // TODO add your handling code here:
        /*
        THIS IS FOR UPDATING A NEW RECORD....
        */
        if (checkTextFields() != false){
            objectParser();
            sai.sql = "UPDATE prod_reg SET prdName = ?, prdDesc = ?, prdManufacturer = ?, prdSupplier = ?, prdQuantity = ?, prdPrice = ?, prdTotalPrice = ?, prdDiscount = ?, prdDiscountedPrice = ? WHERE prdId = ?";
        try{
            objectParser();
            sai.pStmt  = sai.chainSmokersConnection().prepareStatement(sai.sql);
            sai.pStmt.setString (1, prdName);
            sai.pStmt.setString (2, prdDesc);
            sai.pStmt.setString (3, prdManufacturer);
            sai.pStmt.setString (4, prdSupplier);
            sai.pStmt.setInt (5, prdQuantity);
            sai.pStmt.setDouble (6, prdOriginalPrice);
            sai.pStmt.setDouble (7, prdTotalPrice);
            sai.pStmt.setDouble (8, discount);
            sai.pStmt.setDouble (9, prdDiscountedPrice);
            sai.pStmt.setInt (10, prdID);
            sai.pStmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registration Success!!");
            sai.chainSmokersConnection().close();
        }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this, e.getMessage());}
        }else{
            JOptionPane.showMessageDialog(null,"Please fill up all the fields correctly... \n\ndo it for the puppy --> (^・x・^)");
        }
        
        
    }//GEN-LAST:event_btn_UpdatePrdActionPerformed

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        // TODO add your handling code here:
        searchThisID = JOptionPane.showInputDialog("Enter the Product ID that you want to modify: \nNote: This is the same as the Barcode of the Product. ");
        
        if (searchThisID != null){
            try{//1st TRY statement
            sai.sql = "SELECT * FROM prod_reg WHERE prdId = '"+searchThisID+"'";
            
                Statement stmt = sai.chainSmokersConnection().createStatement();
                rs = stmt.executeQuery(sai.sql);
                
                if(rs.next()){//IF USER EXISTS!!
                JOptionPane.showMessageDialog(null,"The Product ID / BARCODE " + searchThisID + " Exists");
                /*
                NEED TO GET THE DATA AND THROW TO THE OBJECT VARIABLES
                */
                prdID = rs.getInt("prdId");
                prdName =rs.getString("prdName");
                prdDesc = rs.getString("prdDesc");
                prdManufacturer = rs.getString("prdManufacturer");
                prdSupplier = rs.getString("prdSupplier");
                prdQuantity = rs.getInt("prdQuantity");
                prdOriginalPrice = rs.getDouble("prdPrice");
                prdTotalPrice = rs.getDouble("prdTotalPrice");
                discount = rs.getDouble("prdDiscount");
                prdDiscountedPrice = rs.getDouble("prdDiscountedPrice");
                
                transferData2TextField();
                
                sai.chainSmokersConnection().close();
                }//IF USER EXISTS END!!!
                else{
                    JOptionPane.showMessageDialog(null, "This product doesnt Exist!!");
                }//end of the BIG IF ELSE statement
            }//END OF FIRST TRY STATEMENT
            catch(ClassNotFoundException | SQLException | HeadlessException e){//start of catch phrase
                JOptionPane.showMessageDialog(this, e.getMessage());
            }//end of catch phrase
            
        }
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void btnBrowseSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseSupplierActionPerformed
        // TODO add your handling code here:
        try {
            sai.sql = "SELECT supplier_id, supplier_name FROM supplier_list";
            Statement stmt = sai.chainSmokersConnection().createStatement();
            ResultSet qqrs = stmt.executeQuery(sai.sql);
            
            table_supplier.setModel(hatsune.tableModelMaker(qqrs));
            
            browse_Supplier.setLocationRelativeTo(null);
            browse_Supplier.setPreferredSize(new Dimension(421, 351));
            browse_Supplier.setResizable(false);
            browse_Supplier.setVisible(true);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBrowseSupplierActionPerformed

    private void btnBrowseManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseManufacturerActionPerformed
        // TODO add your handling code here:
        try {
            sai.sql = "SELECT manufacturer_id, manufacturer_name FROM manufacturer_list";
            Statement stmt = sai.chainSmokersConnection().createStatement();
            ResultSet qqrs = stmt.executeQuery(sai.sql);
            
            table_Manufacturer.setModel(hatsune.tableModelMaker(qqrs));
            browse_Manufacturer.setLocationRelativeTo(null);
            browse_Manufacturer.setPreferredSize(new Dimension(400, 275));
            browse_Manufacturer.setResizable(false);
            browse_Manufacturer.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBrowseManufacturerActionPerformed

    private void btnUseThisManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseThisManufacturerActionPerformed
        // TODO add your handling code here:
        final int row = table_Manufacturer.getSelectedRow();
        Object iLikeNachos = table_Manufacturer.getValueAt(row, 1);
        txtPrdManufacturer.setText(String.valueOf(iLikeNachos));
        this.browse_Manufacturer.dispose();
    }//GEN-LAST:event_btnUseThisManufacturerActionPerformed

    private void btnUseThisSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseThisSupplierActionPerformed
        // TODO add your handling code here:
        final int row = table_supplier.getSelectedRow();
        Object iLikeNachos = table_supplier.getValueAt(row, 1);
        txtPrdSupplier.setText(String.valueOf(iLikeNachos));
        this.browse_Supplier.dispose();
    }//GEN-LAST:event_btnUseThisSupplierActionPerformed

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
            java.util.logging.Logger.getLogger(frm_PrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_PrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_PrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_PrdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_PrdForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame browse_Manufacturer;
    private javax.swing.JFrame browse_Supplier;
    private javax.swing.JButton btnBrowseManufacturer;
    private javax.swing.JButton btnBrowseSupplier;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnRegisterPRD;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JButton btnUseThisManufacturer;
    private javax.swing.JButton btnUseThisSupplier;
    private javax.swing.JButton btn_UpdatePrd;
    private javax.swing.JComboBox cmbDiscountPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Manufacturer;
    private javax.swing.JTable table_supplier;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtPrdDIscountedPrice;
    private javax.swing.JTextField txtPrdDesc;
    private javax.swing.JTextField txtPrdManufacturer;
    private javax.swing.JTextField txtPrdName;
    private javax.swing.JTextField txtPrdOriginalPrice;
    private javax.swing.JTextField txtPrdQuantity;
    private javax.swing.JTextField txtPrdSupplier;
    private javax.swing.JTextField txtPrdTotalPrice;
    // End of variables declaration//GEN-END:variables
}
