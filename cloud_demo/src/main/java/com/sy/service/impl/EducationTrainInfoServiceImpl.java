package com.sy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sy.common.ReturnCode;
import com.sy.entity.EducationTrainFiles;
import com.sy.entity.EducationTrainInfo;
import com.sy.entity.EducationTrainPeople;
import com.sy.entity.EducationTrainTemp;
import com.sy.mapper.EducationTrainTempMapper;
import com.sy.service.EducationTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 教育培训信息(EducationTrainInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 13:57:05
 */
@Service("educationTrainInfoService")
public class EducationTrainInfoServiceImpl implements EducationTrainInfoService {
    @Autowired
    private EducationTrainTempMapper educationTrainTempMapper;


    /**
     *  导入成功提示按钮
     * @param type  1确定,查询出保存数据  0取消,清除临时表数据
     * @return
     */
    @Override
    public List<EducationTrainTemp> importSuccess(Integer type) {
        List<EducationTrainTemp> educationTrainTemps = new ArrayList<>();
        if(type ==1){   //查询临时表数据
            educationTrainTemps  = educationTrainTempMapper.selectList(null);
        }
        if(type == 0){
            educationTrainTempMapper.delete(null);
        }
        return educationTrainTemps;
    }



}