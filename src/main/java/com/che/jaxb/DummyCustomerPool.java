package com.che.jaxb;

import com.che.models.customer.Customer;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="customers")
@XmlType(name="DummyCustomerPool")
@XmlAccessorType(XmlAccessType.FIELD)
public class DummyCustomerPool {

	@XmlElement(name="customer")
	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getCustomers() {
		if(customers == null){
			customers = new ArrayList<>();
		}
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override public String toString() {
		return "DummyCustomerPool{" +
				"customers=" + customers +
				'}';
	}
}
