package top.flyeric.demo.domain.customer.repository;

import top.flyeric.demo.domain.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> queryByExample(String customerId, String companyName);
}
