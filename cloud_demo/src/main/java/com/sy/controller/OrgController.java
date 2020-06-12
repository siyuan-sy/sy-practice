package com.sy.controller;

import com.sy.common.redis.service.RedisService;
import com.sy.common.log.annotation.Log;
import com.sy.mapper.NationwideDictMapper;
import com.sy.mapper.OrgNatureCopyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    private static ThreadLocal threadLocal = new ThreadLocal();

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
