package com.angle.controller;

import com.angle.model.MSModule;
import com.angle.service.IMsModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@RestController
@RequestMapping("/module")
public class MsModuleController {
    private static  final Logger logger = LoggerFactory.getLogger(MsModuleController.class);

    @Autowired
    private IMsModuleService msModuleService;
    @RequestMapping("/moduleList")
    public List<MSModule> getMSModuleList(){
        logger.info("getMSModuleList()...");
        return  msModuleService.getList();
    }

}
