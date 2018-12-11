package com.dothings.training.test1.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.dothings.training.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganpeikang
 * @since 2018-12-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_test_first")
public class TTestFirst extends BaseEntity<TTestFirst> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String value;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
