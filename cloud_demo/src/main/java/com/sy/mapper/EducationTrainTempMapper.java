package com.sy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sy.entity.EducationTrainTemp;
import com.sy.pojo.Temp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 培训人员临时信息(EducationTrainTemp)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 13:57:07
 */
public interface EducationTrainTempMapper extends BaseMapper<EducationTrainTemp> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EducationTrainTemp queryById(Long id);

    List<Temp> tempList();

    Temp tempinsert(@Param("param1") String params1,@Param("param2")String params2);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EducationTrainTemp> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param educationTrainTemp 实例对象
     * @return 对象列表
     */
    List<EducationTrainTemp> queryAll(EducationTrainTemp educationTrainTemp);

    /**
     * 新增数据
     *
     * @param educationTrainTemp 实例对象
     * @return 影响行数
     */
    int insert(EducationTrainTemp educationTrainTemp);

    /**
     * 修改数据
     *
     * @param educationTrainTemp 实例对象
     * @return 影响行数
     */
    int update(EducationTrainTemp educationTrainTemp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    void batchInsert(@Param("list") List<EducationTrainTemp> list);
}