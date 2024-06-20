package top.flyeric.demo.client.dto.data;

import lombok.Getter;

@Getter
public enum ErrorCode {
    CUSTOMER_COMPANY_NAME_CONFLICT("CUSTOMER_COMPANY_NAME_CONFLICT", "客户公司名冲突");

    private final String errCode;
    private final String errDesc;

    ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

}
