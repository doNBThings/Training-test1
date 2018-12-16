package com.dothings.training.test1.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.dothings.training.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganpeikang
 * @since 2018-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_test_first")
public class TTestFirst extends BaseEntity<TTestFirst> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String value;
    @TableField("is_del")
    private Integer isDel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
