package com.angle.controller;

import com.angle.exception.ApplicationException;
import com.angle.form.MSModuleMessageForm;
import com.angle.model.MSModule;
import com.angle.service.IMsModuleService;
import com.angle.utils.ValidateUtils;
import com.angle.view.MessageViewBase;
import com.angle.view.MultiValuesMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@RestController
@RequestMapping("/module")
public class MsModuleController extends  MessageControllerBase{
    private static  final Logger logger = LoggerFactory.getLogger(MsModuleController.class);

    @Autowired
    private IMsModuleService msModuleService;
    @RequestMapping("/moduleList")
    public @ResponseBody Object getMSModuleList(MSModuleMessageForm form) throws ApplicationException {
        logger.info("getMSModuleList()...");
        ValidateUtils.validate(form,MSModuleMessageForm.GetModuleList.class);
        MultiValuesMessage<Object> msg = new MultiValuesMessage<Object>();
        msg.getBody().put("list",  msModuleService.getList(form.getPageIndex(),form.getPageSize()));
        return  msg;
    }

}
