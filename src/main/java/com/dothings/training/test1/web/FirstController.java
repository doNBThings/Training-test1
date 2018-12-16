package com.dothings.training.test1.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dothings.training.domain.ListResp;
import com.dothings.training.domain.PageResp;
import com.dothings.training.domain.Status;
import com.dothings.training.test1.domain.FirstPageReq;
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
public class FirstController {
	@Autowired
	private ITTestFirstService firstService;
	@ApiOperation("根据id查询")
	@GetMapping("{id}")
	public TTestFirst selectById(@ApiParam("主键")@PathVariable String id){
		TTestFirst testFirst = firstService.selectById(id);
//		int a = 5/0;
		return testFirst;
	}
	
	@ApiOperation("查询所有")
	@GetMapping("all")
	public ListResp selectAll(){
		ListResp listResp=new ListResp();
		Wrapper<TTestFirst> wrapper=new EntityWrapper(new TTestFirst().setIsDel(0));
		 List<TTestFirst> list = firstService.selectList(wrapper);
		 listResp.setValues(list);
		return listResp;
	}
	
	@ApiOperation("分页查询")
	@GetMapping("page")
	public PageResp selectPage(@RequestBody FirstPageReq<TTestFirst> pageReq){
//		Wrapper<TTestFirst> wrapper=new EntityWrapper(new TTestFirst().setIsDel(0));
		//Page<TTestFirst> page1=new Page<>(1, 10);
		//Map<String, Object> condition=new HashMap<>();
//		condition.put("name", "qq");
//		page.setCondition(condition);
		Page<TTestFirst> page = firstService.selectPage(pageReq.getPage());
		PageResp pageResp=new PageResp(page);
		return pageResp;
	}
	
	@ApiOperation("增加表数据")
	@PostMapping("")
	public Status insert(@RequestBody TTestFirst testFirst){
		firstService.insert(testFirst);
		return new Status();
	}
	@ApiOperation("删除表数据")
	@DeleteMapping("{id}")
	public Status delete(@ApiParam("主键")@PathVariable String id){
		firstService.updateById(new TTestFirst().setId(id).setIsDel(1));
		return new Status();
	}

	@ApiOperation("修改表数据")
	@PutMapping("")
	public Status update(@RequestBody TTestFirst testFirst){
		firstService.updateById(testFirst);
		return new Status();
	}
}

