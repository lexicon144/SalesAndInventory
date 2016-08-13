/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class dataForTableBuilding {
    
    public static void main(String [] args){
        
    }
    /**
     * This Function takes a RESULT SET inside and then
    returns a TableModel
    THIS tableModel is used to Create
    a GOOD LOOKING JTABLE
     * @param takeThisIn
     * @return
     * @throws SQLException 
     */
    public static DefaultTableModel tableModelMaker(ResultSet takeThisIn) throws SQLException {
        ResultSetMetaData metaData = takeThisIn.getMetaData();
        //hell yeah use vectors
        //since ARRAYS are OLD.. loljk
        //Vectors since they can "adapt" and "change" in size unlike Arrays
        //note
        //Vectors use the <> thing..
        Vector<String> nameOfColumn = new Vector<String>();
        
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            nameOfColumn.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        while (takeThisIn.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(takeThisIn.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, nameOfColumn);
    }
}
