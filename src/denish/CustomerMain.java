
package denish;

import denish.entity.Customer;
import denish.model.CustomerDAO;
import denish.model.CustomerDAOImpl;
import java.util.List;

public class CustomerMain {
    public static void main(String args[]){
        CustomerDAO dao = new CustomerDAOImpl();
        
        dao.addCustomer(new Customer(1,"denish","thummar","rjt"));
        dao.addCustomer(new Customer(2,"amit","kumar","lkn"));
        dao.addCustomer(new Customer(3,"vikas","solanki","mp"));
        dao.addCustomer(new Customer(4,"himanshu","patel","surat"));
        dao.addCustomer(new Customer(5,"raj","thummar","drj"));
        
        List<Customer> customers = dao.getAll();
        
        customers.forEach(c->System.out.println(c));
        
        System.out.println("Customer 1 detail");
        Customer cust = dao.getCustomer(1);
        System.out.println(cust);

        System.out.println("Customer 1 new address");
        cust.setAddress("Dhoraji");
        dao.updateCustomer(cust);

        System.out.println("Customer 1 deleted");
        cust = dao.getCustomer(1);
        System.out.println(cust);
        dao.deleteCustomer(1);

        customers = dao.getAll();
        customers.forEach(c->System.out.println(c));
    }
}
