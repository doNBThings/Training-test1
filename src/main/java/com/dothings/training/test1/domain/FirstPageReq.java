package com.dothings.training.test1.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import com.dothings.training.domain.PageReq;
@ApiModel("first分页请求")
@Data
public class FirstPageReq<T> extends PageReq<T>{

	@ApiModelProperty("名称 ")
	private String name;
	@ApiModelProperty("值")
	private String value;
	
	@Override
	public Map<String, Object> getQueryParams() {
		Map<String, Object> map=new HashMap<String, Object>();
		if(StringUtils.isNotBlank(name)){
			map.put("name", "%"+name+"%");
		}
		return map;
	}

}
