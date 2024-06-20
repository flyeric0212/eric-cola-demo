package top.flyeric.demo.client.dto.query;

import lombok.Data;
import top.flyeric.framework.dto.query.QueryDTO;

@Data
public class CustomerListQuery extends QueryDTO {
    private String customerId;
    private String companyName;
}
