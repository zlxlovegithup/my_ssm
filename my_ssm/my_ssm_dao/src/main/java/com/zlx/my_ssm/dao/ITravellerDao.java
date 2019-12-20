package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 旅客的持久层接口
 */
public interface ITravellerDao {
    /**
     * 根据订单id查询到旅客id,然后根据旅客ID查询到对应的旅客信息
     * @param orderId
     * @return
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findTravellersById(String orderId) throws Exception;
}
