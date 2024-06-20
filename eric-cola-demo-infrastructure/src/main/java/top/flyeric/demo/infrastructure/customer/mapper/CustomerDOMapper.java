package top.flyeric.demo.infrastructure.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.flyeric.demo.infrastructure.customer.dataobject.CustomerDO;
import top.flyeric.demo.infrastructure.customer.dataobject.CustomerDOExample;

import java.util.List;

@Mapper
public interface CustomerDOMapper {
    long countByExample(CustomerDOExample example);

    int deleteByExample(CustomerDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerDO row);

    int insertSelective(CustomerDO row);

    List<CustomerDO> selectByExample1(CustomerDOExample example);

    CustomerDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CustomerDO row, @Param("example") CustomerDOExample example);

    int updateByExample(@Param("row") CustomerDO row, @Param("example") CustomerDOExample example);

    int updateByPrimaryKeySelective(CustomerDO row);

    int updateByPrimaryKey(CustomerDO row);
}