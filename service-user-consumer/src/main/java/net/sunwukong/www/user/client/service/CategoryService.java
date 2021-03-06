package net.sunwukong.www.user.client.service;

import net.sunwukong.www.api.entity.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 说明:目录服务接口
 *
 * @author Mick
 * CreateDate 2018/6/22/022 22:00
 * Email ：ideacoding@163.com
 * Version 1.0
 **/
@FeignClient(value = "user-server-1")
@RequestMapping(value = "/category")
public interface CategoryService {

    /**
     * 获取服务目录列表
     * @return
     */
    @RequestMapping(value = "/getcategorylist",method = RequestMethod.POST)
    ResponseData getCategoryList();
}
