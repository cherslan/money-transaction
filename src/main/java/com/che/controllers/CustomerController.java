package com.che.controllers;

import com.che.exceptions.NoSuchCustomerException;
import com.che.jaxb.DummyCustomerPool;
import com.che.models.account.Account;
import com.che.models.customer.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {

	private static final String            dummyPoolFileName = "DummyCustomerPool.xml";
	private static       DummyCustomerPool dummyCustomerPool = new DummyCustomerPool();

	private static List<Customer> customers = new ArrayList<>();

	private CustomerController() {
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static Customer getCustomer(String custNo) throws NoSuchCustomerException {
		Customer customer = customers.stream()
				.filter(filter -> filter.getCustomerNumber().equals(custNo))
				.findFirst().orElse(null);
		if (customer == null) {
			throw new NoSuchCustomerException();
		}

		return customer;
	}

	public static void loadStaticData() throws JAXBException {
		try {

			File dummyPool = new File(dummyPoolFileName);
			if (!dummyPool.exists()) {
				for (int i = 0; i < 11; i++) {
					Customer customer = new Customer();
					customer.setCustomerNumber("CustomerNumber-" + i);
					customer.setName("CustomerName-" + i);
					customer.setLastName("CustomerLastName-" + i);
					customer.setEmail(customer.getName() + customer.getLastName() + "@.web.com");
					customer.setAddress("CustomerAddress" + i);

					for (int j = 0; j < 2; j++) {
						Account account = new Account();
						account.setTitle((j % 2 == 0 ? "Saving" : "Loan"));
						account.setAccountNumber("Acct-" + customer.getCustomerNumber() + "-" + j);
						account.setBalance(j * 100);
						account.setCurrency("USD");
						account.setIbanNumber("HU-" + (i * j) + account.getAccountNumber());
						account.setCustomerNumber(customer.getCustomerNumber());

						customer.getAccounts().add(account);
					}

					customers.add(customer);
				}

				saveDummyCustomers();
			} else {
				customers = getDummyCustomers().getCustomers();
			}
		} catch (Throwable t) {
			System.out.println("Unexpected error while creating dummy pool: " + t.getMessage());
			t.printStackTrace();
		}
	}

	private static DummyCustomerPool getDummyCustomers() throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(DummyCustomerPool.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (DummyCustomerPool) unmarshaller.unmarshal(new File(dummyPoolFileName));
		} catch (Throwable t) {
			System.out.println("Unexpected error while reading customers: " + t.getMessage());
			t.printStackTrace();
			throw t;
		}
	}

	public static void saveDummyCustomers() throws JAXBException {
		try {
			dummyCustomerPool.setCustomers(customers);
			JAXBContext jc = JAXBContext.newInstance(DummyCustomerPool.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(dummyCustomerPool, new File(dummyPoolFileName));
		} catch (Throwable t) {
			System.out.println("Unexpected error while reading customers: " + t.getMessage());
			t.printStackTrace();
			throw t;
		}
	}
}
