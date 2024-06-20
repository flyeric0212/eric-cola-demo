package top.flyeric.demo.app.customer.executor;

import org.springframework.stereotype.Component;
import top.flyeric.demo.client.dto.command.CustomerAddCmd;
import top.flyeric.demo.client.dto.data.ErrorCode;
import top.flyeric.framework.dto.response.Response;
import top.flyeric.framework.exception.BizException;

@Component
public class CustomerCmdExecutor {

    public Response execute(CustomerAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
        if (cmd.getCustomerDTO().getCompanyName().equals("ConflictCompanyName")) {
            throw new BizException(ErrorCode.CUSTOMER_COMPANY_NAME_CONFLICT.getErrCode(), "公司名冲突");
        }

        return Response.buildSuccess();
    }

}
