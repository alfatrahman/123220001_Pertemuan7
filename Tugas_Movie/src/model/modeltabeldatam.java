/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HP
 */
public class modeltabeldatam extends AbstractTableModel{
    
    List<datam> dp;
    public modeltabeldatam(List<datam>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getAlur();
            case 2:
                return dp.get(row).getPenokohan();
            case 3:
                return dp.get(row).getAkting();
            case 4:
                return dp.get(row).getNilai();
            default:
                return null;
        }
    }
    
}
