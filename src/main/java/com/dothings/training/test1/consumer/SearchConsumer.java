package com.dothings.training.test1.consumer;

import com.dothings.training.test1.config.EsCouBean;
import com.dothings.training.utils.result.RestResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "TRAINING-SEARCH")
public interface SearchConsumer {
    @RequestMapping(value = "search/api/search/save", method = RequestMethod.POST)
    RestResp<EsCouBean> loadmessage(@RequestParam(value = "bean")String bean);
}
