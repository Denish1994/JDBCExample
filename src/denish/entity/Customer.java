
package denish.entity;

public class Customer {
    private int custID;
    private String firstName;
    private String lastName;
    private String address;
    
    public Customer(){
        
    }

    public Customer(int custID, String firstName, String lastName, String address) {
        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String toString(){
        return (custID+":"+firstName+":"+lastName+":"+address);
    }
    
}
