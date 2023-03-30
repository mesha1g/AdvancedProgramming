package JavaOrgExample.Three.JDBC;

import java.time.LocalDate;
import java.time.Period;

public class Customer implements Comparable<Customer>{
    private Integer customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String phone;
    private String address;
    private String city;
    //2 char
    private String state;
    private int points;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length()>50){
            firstName = firstName.substring(0, 50);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(state.length()!=2){
            System.err.println("Wrong state field value. Value length must equal to 2 chars");
            return;
        }
        this.state = state;
    }

    public Integer getAge(){
        LocalDate now = LocalDate.now();
        Period period = birthdate.until(now);
        return period.getYears();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", points=" + points +
                '}';
    }

    public int compareByAge(Customer anotherCustomer){
        return birthdate.compareTo(anotherCustomer.getBirthdate());
    }

    /**
     *  Customer c1 = new Customer();
     *  Customer c2 = new Customer();
     *  int result = c1.compareTo(c2);
     *  result -> 0      c1 je jednak c2
     *  result -> -1     c1 je manji od c2
     *  result -> 1      c1 veći od c2
     * @param anotherCustomer the object to be compared.
     * @return resultOfComparing
     */
    @Override
    public int compareTo(Customer anotherCustomer) {
        return customerId.compareTo(anotherCustomer.getCustomerId());
    }

    // OrderItem orderItem1 = new OrderItem() -> PK   order_id, product_id
    // OrderItem orderItem2 = new OrderItem() -> PK   order_id, product_id
    /**
     * int result = orderItem1.compareTo(orderItem2);
     *   {
     *       int result = orderId.compareTo(anotherOrderItem.getOrderId());
     *       if(result == 0){
     *           result = productId.compareTo(anotherOrderItem.getProductId());
     *       }
     *       return result;
     *   }
     */
}
