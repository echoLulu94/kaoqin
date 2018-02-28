package com.cxs.extension.sys.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cxs.extension.sys.service.api.DictItemService;

/**
 * 
 * @Description: 容器启动时初始化数据
 * 如果你发现你的实现类没有按照你的需求执行，
 * 请看一下实现类上是否添加了Spring管理的注解（@Component）。
 * 如果有多个实现类，而你需要他们按一定顺序执行的话，可以在实现类上加上@Order注解。
 * @Order(value=整数值)。SpringBoot会按照@Order中的value值从小到大依次执行。
 * @ClassName: InitApplicationRunner 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年6月10日 
 *
 */
@Component  
public class InitApplicationRunner implements ApplicationRunner {  

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
  
	@Autowired
	private DictItemService dictItemService;

//	@Autowired
//	private ActivityService activityService;
  
    @Override  
    public void run(ApplicationArguments args) throws Exception {  
    	logger.info("初始化字典项缓存！");
    	dictItemService.refreshDictCache();
//		activityService.updateToStart(Cache.DICT_ITEM_MAP.get("ACT_STATE-ACTING"));
//		activityService.updateToEnd(Cache.DICT_ITEM_MAP.get("ACT_STATE-ACTING"),Cache.DICT_ITEM_MAP.get("ACT_STATE-ACTEND"));
    }  
}  