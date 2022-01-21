package service;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Machine;
import connexion.Connexion;
import dao.IDao;
import responses.MachineStatusCountResponse;
import responses.MachinesCount;
import responses.PricePerSalleResponse;

public class MachineService implements IDao<Machine> {
	SalleService salleService = new SalleService();

    @Override
    public boolean create(Machine o) {
        String sql = "insert into machine values (null, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new java.sql.Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getSalle().getId());
            ps.setString(5, o.getStatus());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(Machine o) {
        String sql = "delete from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
    }
    
    public List<PricePerSalleResponse> pricePerSalle() {
    	List<PricePerSalleResponse> results = new ArrayList<PricePerSalleResponse>();

        String sql = "SELECT salle.code,sum(machine.prix) as 'sum' from machine INNER JOIN salle ON machine.idSalle = salle.id GROUP BY salle.code ";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new PricePerSalleResponse(rs.getString("code"), rs.getDouble("sum")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return results;
    }
    
    public List<MachineStatusCountResponse> statusCount() {
    	List<MachineStatusCountResponse> results = new ArrayList<MachineStatusCountResponse>();

        String sql = "select count(machine.reference) as 'count',machine.status FROM machine GROUP BY machine.status;";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new MachineStatusCountResponse(rs.getString("status"), rs.getInt("count")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return results;
    }
    
    public List<MachinesCount> machinesCount() {
    	List<MachinesCount> results = new ArrayList<MachinesCount>();

        String sql = "select count(machine.id) as 'count',salle.code from machine INNER JOIN salle ON machine.idSalle = salle.id group by salle.code ";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new MachinesCount(rs.getString("code"), rs.getInt("count")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return results;
    }
    
    
    public boolean updateStatus(Machine o) {

        String sql = "update machine set status = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getStatus());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }    
    
    @Override
    public boolean update(Machine o) {

        String sql = "update machine set reference  = ? ,dateAchat = ? , prix = ?, idSalle = ?,status = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new java.sql.Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getSalle().getId());
            ps.setString(5, o.getStatus());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public Machine findById(int id) {
        String sql = "select * from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),salleService.findById(rs.getInt("idSalle")),rs.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Machine> findAll() {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),salleService.findById(rs.getInt("idSalle")),rs.getString("status")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findAll(int id) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where idSalle = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),salleService.findById(rs.getInt("idSalle")),rs.getString("status")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findAll(Date d1,Date d2){
    	List<Machine> machines = new ArrayList<Machine>();
    	
    	String sql = "Select * from machine WHERE machine.dateAchat BETWEEN ? AND ? ";
    	
    	
    	try {
    		PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
    		ps.setDate(1, new java.sql.Date(d1.getTime()));
    		ps.setDate(2, new java.sql.Date(d2.getTime()));
    		ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),salleService.findById(rs.getInt("idSalle")),rs.getString("status")));
            }
    		
    	}catch(SQLException e) {
    		System.out.println("findAll " + e.getMessage());
    	}
    	return machines;
    }
    
    
    public List<Machine> findMachineByReference(String ref) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where reference =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, ref);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),salleService.findById(rs.getInt("idSalle")),rs.getString("status")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<String> findReference() {
        List<String> references = new ArrayList<String>();
        String sql = "select distinct(reference) as ref from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                references.add(rs.getString("ref"));
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return references;
    }

}

