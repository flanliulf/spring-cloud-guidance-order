package com.fancyliu.springcloud.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类描述:
 * 订单主表实体类
 *
 * @author : Liu Fan
 * @date : 2019-06-11 09:35
 */
@Data
@TableName("order_master")
public class Order {

    /**
     * 订单id.
     */
    @TableId("order_id")
    private String orderId;

    /**
     * 买家名字.
     */
    @TableField("buyer_name")
    private String buyerName;

    /**
     * 买家手机号.
     */
    @TableField("buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址.
     */
    @TableField("buyer_address")
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    @TableField("buyer_openid")
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    @TableField("order_status")
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0未支付.
     */
    @TableField("pay_status")
    private Integer payStatus;

    /**
     * 创建时间.
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间.
     */
    @TableField("update_time")
    private Date updateTime;
}
