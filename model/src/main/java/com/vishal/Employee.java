package com.vishal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private int phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name="employee_id",
            referencedColumnName = "employeeId"
    )
    private List<Department> department;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="employee_asset_map",
//            joinColumns = @JoinColumn(name="employee",referencedColumnName = "employeeId"),
//            inverseJoinColumns = @JoinColumn(name="asset",referencedColumnName = "assetId")
//    )
  //  private List<Asset> assets;

    public List<Department> getDepartment() {
        return department;
    }


    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Asset> getAssets() {
//        return assets;
//    }
//
//    public void setAssets(List<Asset> assets) {
//        this.assets = assets;
//    }
}
