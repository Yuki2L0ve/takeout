package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);

    /**
     * 根据订单号和用户id查询订单
     * @param orderNumber
     * @param userId
     */
    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据订单号查询订单id
     * @param orderNumber
     * @return
     */
    @Select("select * from orders where number = #{orderNumber}")
    Long getOrderIdByNumber(String orderNumber);

    /**
     * 为替代微信支付成功后的数据库订单状态更新，多定义一个方法进行修改
     * @param orderStatus
     * @param orderPaidStatus
     * @param checkoutTime
     */
    @Update("update orders set status = #{orderStatus}, pay_status = #{orderPaidStatus}, " +
            "checkout_time = #{checkoutTime} where id = #{orderId}")
    void updateStatus(Integer orderStatus, Integer orderPaidStatus, LocalDateTime checkoutTime, Long orderId);
}
