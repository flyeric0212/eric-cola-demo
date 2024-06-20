package top.flyeric.demo.infrastructure.customer.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import top.flyeric.demo.domain.customer.model.Customer;
import top.flyeric.demo.domain.customer.repository.CustomerRepository;
import top.flyeric.demo.infrastructure.customer.convertor.CustomerDOConvertor;
import top.flyeric.demo.infrastructure.customer.dataobject.CustomerDO;
import top.flyeric.demo.infrastructure.customer.dataobject.CustomerDOExample;
import top.flyeric.demo.infrastructure.customer.mapper.CustomerDOMapper;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerDOMapper customerMapper;

    public CustomerRepositoryImpl(CustomerDOMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public List<Customer> queryByExample(String customerId, String companyName) {
        CustomerDOExample customerDOExample = new CustomerDOExample();
        if (StringUtils.isNoneBlank(customerId)) {
            customerDOExample.or().andCustomerIdEqualTo(customerId);
        }
        if (StringUtils.isNoneBlank(companyName)) {
            customerDOExample.or().andCompanyNameLike("%" + companyName + "%");
        }
        List<CustomerDO> customerDOList = customerMapper.selectByExample1(customerDOExample);
        return customerDOList.stream().map(CustomerDOConvertor.CONVERTOR::toDomain).collect(Collectors.toList());
    }
}
