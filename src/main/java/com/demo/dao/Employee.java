package com.demo.dao;


import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * The Employee object data access object. Represents a record in the database.
 */
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String emailAddress;
    private Long phoneNumber;
    private String positionCategory;
    // TODO use a specific date time format
    private Date dateHired = new Date();
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipCode;
    private boolean active;
    private boolean deleted = false;

    /**
     * Make a copy of an employee with a factory method. - Public Static Factory pattern.
     * @param e - the employee to copy
     * @return - the copy of employee e.
     */
    public static Employee copy(Employee e){
        return new Employee()
        .setFirstName("Copy of " +e.firstName)
        .setLastName(e.lastName)
        .setMiddleInitial(e.middleInitial)
        .setEmailAddress(e.emailAddress)
        .setPhoneNumber(e.phoneNumber)
        .setPositionCategory(e.positionCategory)
        .setDateHired(e.dateHired)
        .setAddress1(e.address1)
        .setAddress2(e.address2)
        .setCity(e.city)
        .setState(e.state)
        .setZipCode(e.zipCode)
        .setActive(e.active)
        .setDeleted(e.deleted);
    }

    /**
     * Standard equals comparison.
     * @param o - the employee object to compare.
     * @return - true if they are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (zipCode != employee.zipCode) return false;
        if (active != employee.active) return false;
        if (deleted != employee.deleted) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (middleInitial != null ? !middleInitial.equals(employee.middleInitial) : employee.middleInitial != null)
            return false;
        if (emailAddress != null ? !emailAddress.equals(employee.emailAddress) : employee.emailAddress != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (positionCategory != null ? !positionCategory.equals(employee.positionCategory) : employee.positionCategory != null)
            return false;
        if (dateHired != null ? !dateHired.equals(employee.dateHired) : employee.dateHired != null) return false;
        if (address1 != null ? !address1.equals(employee.address1) : employee.address1 != null) return false;
        if (address2 != null ? !address2.equals(employee.address2) : employee.address2 != null) return false;
        if (city != null ? !city.equals(employee.city) : employee.city != null) return false;
        return state != null ? state.equals(employee.state) : employee.state == null;
    }

    /**
     * Standard hashCode computation.
     * @return - the hashCode for this Employee.
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleInitial != null ? middleInitial.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (positionCategory != null ? positionCategory.hashCode() : 0);
        result = 31 * result + (dateHired != null ? dateHired.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + zipCode;
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Employee setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getId() {
        return id;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public Employee setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Employee setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public Employee setPositionCategory(String positionCategory) {
        this.positionCategory = positionCategory;
        return this;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Employee setDateHired(Date dateHired) {
        this.dateHired = dateHired;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public Employee setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Employee setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Employee setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Employee setState(String state) {
        this.state = state;
        return this;
    }

    public int getZipCode() {
        return zipCode;
    }

    public Employee setZipCode(int zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Employee setActive(boolean active) {
        this.active = active;
        return this;
    }

}