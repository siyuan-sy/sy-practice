package com.sy.service;



import com.sy.entity.EducationTrainInfo;
import com.sy.entity.EducationTrainTemp;

import java.util.List;

/**
 * 教育培训信息(EducationTrainInfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 13:57:05
 */
public interface EducationTrainInfoService {



    /**
     *  导入成功提示按钮
     * @param type  1确定,查询出保存数据  0取消,清除临时表数据
     * @return
     */
    List<EducationTrainTemp> importSuccess(Integer type);
}