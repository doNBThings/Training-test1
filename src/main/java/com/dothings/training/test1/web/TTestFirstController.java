package com.dothings.training.test1.web;


import com.dothings.training.test1.consumer.SearchConsumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dothings.training.domain.Status;
import com.dothings.training.test1.entity.TTestFirst;
import com.dothings.training.test1.service.ITTestFirstService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganpeikang
 * @since 2018-12-12
 */
@Api(description="第一个请求")
@RestController
@RequestMapping("/first")
public class TTestFirstController {
	@Autowired
	private ITTestFirstService firstService;
	@Autowired
	SearchConsumer searchConsumer;
	@ApiOperation("根据id查询")
	@GetMapping("{id}")
	public void selectById(@ApiParam("id")@PathVariable Integer id){
//		TTestFirst testFirst = firstService.selectById(id);
////		int a = 5/0;
//		return testFirst;
		searchConsumer.loadmessage("{ \t\"id\": \"5\", \t\"cource\": \"语文\", \t\"title\": \"渣渣辉\" }");

	}
	@PostMapping("/")
	public Status insert(TTestFirst testFirst){
		Status status=null;
		boolean b = firstService.insert(testFirst);
		if(b){
			status=new Status();
		}else{
			status=new Status(500,"写入数据失败");
		}
		return status;
	}

}

