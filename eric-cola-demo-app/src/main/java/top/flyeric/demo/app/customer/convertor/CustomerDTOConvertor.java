package top.flyeric.demo.app.customer.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import top.flyeric.demo.client.dto.data.CustomerDTO;
import top.flyeric.demo.domain.customer.model.Customer;

import java.util.stream.Collectors;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = Collectors.class)
public interface CustomerDTOConvertor {

    CustomerDTOConvertor CONVERTOR = getMapper(CustomerDTOConvertor.class);

    CustomerDTO toDTO(Customer customer);

}
