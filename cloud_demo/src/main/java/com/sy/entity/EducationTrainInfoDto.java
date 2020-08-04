package com.sy.entity;
import lombok.Data;

import java.util.List;

/**
 * @author siyuan
 * @create 2020/6/16
 */
@Data
public class EducationTrainInfoDto {
    /**
     * 教育培训信息
     */
    private EducationTrainInfo educationTrainInfo;

    /**
     * 文件路径
     */
    private List<EducationTrainFiles> files;

    /**
     * 培训人员信息
     */
    private List<EducationTrainPeople> educationTrainPeoples;

    /**
     * 批次id
     */
    private String batchId;

    public EducationTrainInfoDto(EducationTrainInfo educationTrainInfo, List<EducationTrainFiles> files, List<EducationTrainPeople> educationTrainPeoples) {
        this.educationTrainInfo = educationTrainInfo;
        this.files = files;
        this.educationTrainPeoples = educationTrainPeoples;
    }
}
