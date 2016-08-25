package com.angle.dao;

import com.angle.model.MSModule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public interface IMsModuleDAO extends CrudRepository<MSModule,Integer> {

    @Query("select t from MSModule t")
    List<MSModule> getList();

}
