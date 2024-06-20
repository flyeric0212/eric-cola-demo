package top.flyeric.demo.app.customer.executor.query;

import org.springframework.stereotype.Component;
import top.flyeric.demo.app.customer.convertor.CustomerDTOConvertor;
import top.flyeric.demo.client.dto.data.CustomerDTO;
import top.flyeric.demo.client.dto.query.CustomerListQuery;
import top.flyeric.demo.domain.customer.model.Customer;
import top.flyeric.demo.domain.customer.repository.CustomerRepository;
import top.flyeric.framework.db.mybatis.page.IPageQuery;
import top.flyeric.framework.dto.response.MultiResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerQueryExecutor implements IPageQuery {

    private final CustomerRepository customerRepository;

    public CustomerQueryExecutor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public MultiResponse<CustomerDTO> listCustomers(CustomerListQuery cmd) {
        List<Customer> customers = customerRepository.queryByExample(cmd.getCustomerId(), cmd.getCompanyName());

        List<CustomerDTO> customerDTOList = customers.stream()
                .map(CustomerDTOConvertor.CONVERTOR::toDTO)
                .collect(Collectors.toList());

        return MultiResponse.of(customerDTOList);
    }


}
