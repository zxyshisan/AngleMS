package com.angle.mapper;

import com.angle.model.MSModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@Mapper
public interface IMsModuleMapper {

    @Select("SELECT module_id as moduleId, module_name as moduleName, " +
            "module_url as moduleUrl, parent_id as parentId, level, " +
            "if_leaf as ifLeaf,status, sort_order as sortOrder, " +
            "create_time as createTime FROM public.tbl_ms_module")
    List<MSModule> getList();

}
