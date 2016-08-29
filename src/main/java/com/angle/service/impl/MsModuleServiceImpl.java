package com.angle.service.impl;

import com.angle.mapper.IMsModuleMapper;
import com.angle.model.MSModule;
import com.angle.service.IMsModuleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@Service("msModuleService")
public class MsModuleServiceImpl implements IMsModuleService {

    @Autowired
    private IMsModuleMapper IMsModuleMapper;

    @Override
    public List<MSModule> getList(Integer pageIndex,Integer pageSize) {
        if(pageIndex==null){
            pageIndex=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageIndex,pageSize);
        return IMsModuleMapper.getList();
    }
}
