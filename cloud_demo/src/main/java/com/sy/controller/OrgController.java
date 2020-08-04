package com.sy.controller;

import com.alibaba.excel.EasyExcel;
import com.sy.common.Message;
import com.sy.common.ReturnCode;
import com.sy.common.redis.service.RedisService;
import com.sy.common.log.annotation.Log;
import com.sy.config.EducationTrainTempListener;
import com.sy.entity.EducationTrainTemp;
import com.sy.mapper.NationwideDictMapper;
import com.sy.mapper.OrgNatureCopyMapper;
import com.sy.service.EducationTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private NationwideDictMapper nationwideDictMapper;
    @Autowired
    private OrgNatureCopyMapper orgNatureCopyMapper;
    @Autowired
    private TestController controller;
    @Autowired
    private RedisService redisService;
    @Resource
    private EducationTrainInfoService educationTrainInfoService;

    private static ThreadLocal threadLocal = new ThreadLocal();
    /**
     * 导入人员表
     */
    @PostMapping("/importExcel")
    public Message importExcel(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(file.getInputStream(), EducationTrainTemp.class, new EducationTrainTempListener()).sheet().doRead();
        return new Message().ok(ReturnCode.SUCCESS)
                .addData("success", redisService.getCacheObject("SUCESS_COUNT"))
                .addData("fail", redisService.getCacheObject("FAIL_COUNT"));
    }

    /**
     * 导入成功后,1确定,2取消
     */
    @PostMapping("/importSuccess")
    public Message importSuccess(@RequestParam(value = "type", required = false) Integer type) throws Exception {
        List<EducationTrainTemp> list =  educationTrainInfoService.importSuccess(type);
        return new Message().ok(ReturnCode.SUCCESS).addData("list",list);
    }

    /**
     * 测试log注解
     */
    @Log(title = "siyuan")
    @PostMapping("/log")
    public void updateOrg(@RequestParam("log") String log) {
        Object o = threadLocal.get();
        System.out.println("o = " + o);
        Object siyuan = redisService.getCacheObject("siyuan");
        System.out.println("siyuan = " + siyuan);
    }

    /**
     * 更新所有的组织信息
     */
    @PostMapping("/updateOrg")
    public void updateOrg() {
        threadLocal.set("siyuan");
        String str = "大源";
        Object o = threadLocal.get();
        System.out.println("o = " + o);
        redisService.setCacheObject("siyuan",str);
        //拿到全部组织
        /*List<QudjEntiy> qudjEntiys = controller.loadzzjgTree();
        qudjEntiys.stream().forEach(vo -> {
            //  controller.getDzzList();
        });*/
    }
}
