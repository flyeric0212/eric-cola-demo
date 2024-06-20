package top.flyeric.demo.client.dto.command;

import lombok.Data;
import top.flyeric.demo.client.dto.data.CustomerDTO;

@Data
public class CustomerAddCmd {

    private CustomerDTO customerDTO;

}
