package com.angle.service;

import com.angle.model.MSModule;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public interface IMsModuleService {
    List<MSModule> getList(Integer pageIndex,Integer pageSize);
}
