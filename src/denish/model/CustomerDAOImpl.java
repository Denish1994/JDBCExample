
package denish.model;

import denish.entity.Customer;
import denish.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean addCustomer(Customer cust) {
        try(Connection con = DBUtil.getConnection();
                PreparedStatement st = con.prepareStatement("insert into customer values(?,?,?,?)");){
                st.setInt(1,cust.getCustID());
                st.setString(2, cust.getFirstName());
                st.setString(3,cust.getLastName());
                st.setString(4,cust.getAddress());
                
                
                int flag = st.executeUpdate();
                con.commit();
                if(flag>0)
                    return true;
                          
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer cust) {
        try(Connection con = DBUtil.getConnection();
                PreparedStatement st = con.prepareStatement("update customer set firstName=?,lastName=?,address=? where custID=?");){
                
                st.setString(1, cust.getFirstName());
                st.setString(2,cust.getLastName());
                st.setString(3,cust.getAddress());
                st.setInt(4,cust.getCustID());
                
                int flag = st.executeUpdate();
                con.commit();
                
                if(flag>0)
                    return true;
                          
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int custID) {
        try(Connection con = DBUtil.getConnection();
                PreparedStatement st = con.prepareStatement("delete from customer where custID=?");){
                
                st.setInt(1,custID);
                
                int flag = st.executeUpdate();
                con.commit();
                if(flag>0)
                    return true;
                          
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Customer getCustomer(int custID) {
        Customer cust = null;
        try(Connection con = DBUtil.getConnection();
                PreparedStatement st = con.prepareStatement("select * from customer where custID=?");){
                
                st.setInt(1,custID);
                
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    cust = new Customer();
                    cust.setCustID(rs.getInt("custID"));
                    cust.setFirstName(rs.getString("firstName"));
                    cust.setLastName(rs.getString("lastName"));
                    cust.setAddress(rs.getString("address"));
                }
                          
        }
        catch(Exception e){
            System.out.println(e);
        }
        return cust;

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList();
        Customer cust = new Customer();
        try(Connection con = DBUtil.getConnection();
                Statement st = con.createStatement();){
                
                ResultSet rs = st.executeQuery("select * from customer");
                while(rs.next()){
                    cust = new Customer();
                    cust.setCustID(rs.getInt("custID"));
                    cust.setFirstName(rs.getString("firstName"));
                    cust.setLastName(rs.getString("lastName"));
                    cust.setAddress(rs.getString("address"));
                    customers.add(cust);
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return customers;

    }
    
}
