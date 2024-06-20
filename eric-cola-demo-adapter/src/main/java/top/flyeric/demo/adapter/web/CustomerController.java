package top.flyeric.demo.adapter.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.flyeric.demo.client.api.CustomerServiceI;
import top.flyeric.demo.client.dto.command.CustomerAddCmd;
import top.flyeric.demo.client.dto.data.CustomerDTO;
import top.flyeric.demo.client.dto.query.CustomerListQuery;
import top.flyeric.framework.dto.response.MultiResponse;
import top.flyeric.framework.dto.response.PageResponse;
import top.flyeric.framework.dto.response.Response;

@RestController
public class CustomerController {

    private final CustomerServiceI customerService;

    public CustomerController(CustomerServiceI customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "Hello, welcome to world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomers(
            @RequestParam(required = false, value = "customerId") String customerId,
            @RequestParam(required = false, value = "companyName") String companyName) {
        CustomerListQuery customerListQry = new CustomerListQuery();
        customerListQry.setCustomerId(customerId);
        customerListQry.setCompanyName(companyName);
        return customerService.list(customerListQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd) {
        return customerService.addCustomer(customerAddCmd);
    }

    @GetMapping("/customer/page")
    public PageResponse<CustomerDTO> pageCustomers(
            @RequestParam(required = false, value = "customerId") String customerId,
            @RequestParam(required = false, value = "companyName") String companyName
    ) {
        CustomerListQuery customerListQry = new CustomerListQuery();
        customerListQry.setCustomerId(customerId);
        customerListQry.setCompanyName(companyName);
        return customerService.pageCustomers(customerListQry);
    }
}
