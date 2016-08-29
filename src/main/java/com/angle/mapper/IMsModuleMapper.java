package com.angle.mapper;

import com.angle.model.MSModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
@Mapper
public interface IMsModuleMapper {

    @Select("select * from tbl_ms_module")
    List<MSModule> getList();

}
