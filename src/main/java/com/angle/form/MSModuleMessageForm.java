package com.angle.form;

import javax.validation.constraints.Digits;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class MSModuleMessageForm implements Serializable {


    public interface GetModuleList{}
    @Digits(integer = 32, fraction = 0, groups = {GetModuleList.class})
    private Integer pageIndex;
    @Digits(integer = 32, fraction = 0, groups = {GetModuleList.class})
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
