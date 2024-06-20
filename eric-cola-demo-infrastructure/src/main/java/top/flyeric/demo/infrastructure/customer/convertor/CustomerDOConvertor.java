package top.flyeric.demo.infrastructure.customer.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import top.flyeric.demo.domain.customer.model.Customer;
import top.flyeric.demo.infrastructure.customer.dataobject.CustomerDO;

import java.util.stream.Collectors;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = Collectors.class)
public interface CustomerDOConvertor {

    CustomerDOConvertor CONVERTOR = getMapper(CustomerDOConvertor.class);

    Customer toDomain(CustomerDO customerDO);

}
