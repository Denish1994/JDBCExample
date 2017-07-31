
package denish.model;

import denish.entity.Customer;
import java.util.List;

public interface CustomerDAO {
    public boolean addCustomer(Customer cust);
    public boolean updateCustomer(Customer cust);
    public boolean deleteCustomer(int custID);
    public Customer getCustomer(int custID);
    public List<Customer> getAll();
}
