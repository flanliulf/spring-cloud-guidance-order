package com.fancyliu.springcloud.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类描述:
 * 订单明细表实体类
 *
 * @author : Liu Fan
 * @date : 2019-06-11 09:35
 */
@Data
@TableName("order_detail")
public class OrderDetail {

    @TableId("detail_id")
    private String detailId;

    /**
     * 订单id.
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品id.
     */
    @TableField("product_id")
    private String productId;

    /**
     * 商品名称.
     */
    @TableField("product_name")
    private String productName;

    /**
     * 商品单价.
     */
    @TableField("product_price")
    private BigDecimal productPrice;

    /**
     * 商品数量.
     */
    @TableField("product_quantity")
    private Integer productQuantity;

    /**
     * 商品小图.
     */
    @TableField("product_icon")
    private String productIcon;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
