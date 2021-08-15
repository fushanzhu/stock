package com.stock.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("base_info")
public class StockEntity {
//    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;

    @TableField("stock_code")
    private String stockCode;

    @TableField("stock_name")
    private String stockName;

}
