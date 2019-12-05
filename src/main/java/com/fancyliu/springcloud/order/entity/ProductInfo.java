package com.fancyliu.springcloud.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("product_info")
public class ProductInfo implements Serializable {

    @TableId("product_id")
    private String productId;

    /**
     * 名字.
     */
    @TableField("product_name")
    private String productName;

    /**
     * 单价.
     */
    @TableField("product_price")
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    @TableField("product_stock")
    private Integer productStock;

    /**
     * 描述.
     */
    @TableField("product_description")
    private String productDescription;

    /**
     * 小图.
     */
    @TableField("product_icon")
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     */
    @TableField("product_status")
    private Integer productStatus;

    /**
     * 类目编号.
     */
    @TableField("category_type")
    private Integer categoryType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
