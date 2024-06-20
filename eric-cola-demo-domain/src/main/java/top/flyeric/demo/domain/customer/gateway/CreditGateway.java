package top.flyeric.demo.domain.customer.gateway;

import top.flyeric.demo.domain.customer.model.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
