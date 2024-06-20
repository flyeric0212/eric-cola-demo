package top.flyeric.demo.infrastructure.customer.dataobject;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerDO {
    private Long id;

    private String customerId;

    private String memberId;

    private String globalId;

    private String companyName;

    private Long registeredCapital;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private LocalDateTime deleteTime;

    private Boolean deleted;
}