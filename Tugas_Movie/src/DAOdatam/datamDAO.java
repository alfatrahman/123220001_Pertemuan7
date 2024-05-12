/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatam;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datamImplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class datamDAO implements datamImplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul,alur,penokohan,akting,nilai) VALUES (?,?,?,?,?);";
    final String update = "UPDATE movie set alur=?, penokohan=?,akting=?, nilai=? where judul=?; ";
    final String delete = "delete from movie where judul = ?";
    public datamDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datam p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            double rating = (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3;
            statement.setDouble(5, rating);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datam p) {
         PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            double rating = (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3;
            statement.setDouble(4, rating);
            statement.setString(5, p.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datam> getAll() {
        List<datam> dp = null;
        try{
            dp = new ArrayList<datam>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datam m = new datam();
                m.setJudul(rs.getString("judul"));
                m.setAlur(rs.getDouble("alur"));
                m.setPenokohan(rs.getDouble("penokohan"));
                m.setAkting(rs.getDouble("akting"));
                m.setNilai(rs.getDouble("nilai"));
                dp.add(m);
            }
        }catch(SQLException ex){
            Logger.getLogger(datamDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return dp;
    }
}
