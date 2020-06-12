package com.sy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sy.entity.NationwideDict;
import com.sy.entity.OrgNatureCopy;
import com.sy.mapper.NationwideDictMapper;
import com.sy.mapper.OrgNatureCopyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class demo {

    @Autowired
    private NationwideDictMapper nationwideDictMapper;
    @Autowired
    private OrgNatureCopyMapper orgNatureCopyMapper;
    
    @Test
    public void test1(){
        List<NationwideDict> nationwideDicts = nationwideDictMapper.selectList(new QueryWrapper<NationwideDict>().eq("PID",201));
        nationwideDicts.stream().forEach(vo->{
            OrgNatureCopy name = orgNatureCopyMapper.selectOne(new QueryWrapper<OrgNatureCopy>().eq("name", vo.getCaption()));
            if(name != null){
                System.out.println("name = " + name);
                vo.setName(name.getName());
                vo.setValue(name.getId().toString());
                nationwideDictMapper.updateById(vo);
            }
        });

    }
}
