package com.angle.service.impl;

import com.angle.mapper.IMsModuleMapper;
import com.angle.model.MSModule;
import com.angle.service.IMsModuleService;
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
    public List<MSModule> getList() {
        return IMsModuleMapper.getList();
    }
}
