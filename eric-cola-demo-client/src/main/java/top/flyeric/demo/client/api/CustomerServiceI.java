package top.flyeric.demo.client.api;

import top.flyeric.demo.client.dto.command.CustomerAddCmd;
import top.flyeric.demo.client.dto.data.CustomerDTO;
import top.flyeric.demo.client.dto.query.CustomerListQuery;
import top.flyeric.framework.dto.response.MultiResponse;
import top.flyeric.framework.dto.response.PageResponse;
import top.flyeric.framework.dto.response.Response;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> list(CustomerListQuery customerListByNameQry);

    PageResponse<CustomerDTO> pageCustomers(CustomerListQuery customerListQry);
}
