package com.sy;

/**
 * @author siyuan
 * @version V1.0
 * @Package com.sy
 * @date 2020/9/4 11:11
 * @Copyright © 2016-2017 奥琦玮信息科技（北京）有限公司
 */
public class CGLibTest {
    public String method(String str) {   // 目标方法
        System.out.println(str);
        return "CGLibTest.method()ssssssssss:" + str;
    }

    public String timeOver(String str) {   // 目标方法
        System.out.println(str);
        return "CGLibTest.timeOver():" + str;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        // 生成CBLibTest的代理对象
        CGLibTest proxyImp = (CGLibTest)
                proxy.getProxy(CGLibTest.class);
        // 调用代理对象的method()方法
        String result = proxyImp.method("test");
        String siyuan = proxyImp.timeOver("siyuan");
        System.out.println(result);        System.out.println("siyuan = " + siyuan);


        // ----------------
        // 输出如下：
        // 前置代理
        // test
        // 后置代理
        // CGLibTest.method():test
    }
}
