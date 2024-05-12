/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author HP
 */
public interface datamImplement {
    public void insert(datam p);
    public void update(datam p);
    public void delete(String judul);
    public List<datam> getAll();    
    
}
