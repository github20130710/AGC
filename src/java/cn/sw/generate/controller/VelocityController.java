package cn.sw.generate.controller;

import cn.sw.generate.service.VelocityService;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sophia.wang on 17/4/17.
 */
@Controller
@RequestMapping(value = "/createCode")
public class VelocityController {

    @Autowired
    private VelocityService service;

    // 获取要生成模块的数据模型
    @RequestMapping(value = "/getEntity", method= RequestMethod.GET)
    public @ResponseBody Object getEntity(@RequestParam String beanName) {

        return null;
    }

    // 生成
    @RequestMapping(value = "/generate", method= RequestMethod.GET)
    public @ResponseBody void generate() {
        try {
            service.generate("volume");
            System.out.println("success generate code ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
