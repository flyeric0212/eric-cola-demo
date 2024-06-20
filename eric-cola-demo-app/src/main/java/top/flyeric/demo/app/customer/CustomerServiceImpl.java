package top.flyeric.demo.app.customer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.flyeric.demo.app.customer.executor.CustomerCmdExecutor;
import top.flyeric.demo.app.customer.executor.query.CustomerQueryExecutor;
import top.flyeric.demo.client.api.CustomerServiceI;
import top.flyeric.demo.client.dto.command.CustomerAddCmd;
import top.flyeric.demo.client.dto.data.CustomerDTO;
import top.flyeric.demo.client.dto.query.CustomerListQuery;
import top.flyeric.framework.dto.response.MultiResponse;
import top.flyeric.framework.dto.response.PageResponse;
import top.flyeric.framework.dto.response.Response;
import top.flyeric.framework.logging.cathlog.CatchAndLog;

@Service("customerServiceImpl")
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerCmdExecutor customerCmdExecutor;

    @Resource
    private CustomerQueryExecutor customerQueryExecutor;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerCmdExecutor.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> list(CustomerListQuery customerListQry) {
        return customerQueryExecutor.listCustomers(customerListQry);
    }

    @Override
    public PageResponse<CustomerDTO> pageCustomers(CustomerListQuery customerListQry) {
        return customerQueryExecutor.doPageQuery(1, 10, () -> customerQueryExecutor.listCustomers(customerListQry));
    }

}