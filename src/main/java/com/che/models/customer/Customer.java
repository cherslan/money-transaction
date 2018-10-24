package com.che.models.customer;

import com.che.models.account.Account;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Customer")
@XmlType(name="Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 2769553457793990261L;

	@XmlElement(name="customer-number")
	private String customerNumber;

	@XmlElement(name="name")
	private String name;

	@XmlElement(name="last-name")
	private String lastName;

	@XmlElement(name="email")
	private String email;

	@XmlElement(name="address")
	private String address;

	@XmlElementWrapper(name="accounts")
	@XmlElementRef(name="accounts")
	private List<Account> accounts;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		if(accounts == null){
			accounts = new ArrayList<>();
		}
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override public String toString() {
		return "Customer{" +
				"customerNumber='" + customerNumber +
				", name='" + name +
				", lastName='" + lastName +
				", email='" + email +
				", address='" + address +
				", accounts=" + accounts +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(getCustomerNumber(), customer.getCustomerNumber()) &&
				Objects.equals(getName(), customer.getName()) &&
				Objects.equals(getLastName(), customer.getLastName()) &&
				Objects.equals(getEmail(), customer.getEmail()) &&
				Objects.equals(getAddress(), customer.getAddress());
	}

	@Override public int hashCode() {
		return Objects.hash(getCustomerNumber(), getName(), getLastName(), getEmail(), getAddress());
	}
}
