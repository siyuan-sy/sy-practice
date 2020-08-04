package com.sy;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.sy.pojo.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class DemoApplicationTest {


    /**
     * clone 克隆
     */
    @Test
    public void testClone() {
        //浅克隆
        User user = new User("siyuan", 22, null);
        List<Rol> rols = new ArrayList<>();
        rols.add(new Rol("dalao"));
        rols.add(new Rol("dadiao"));
        user.setRol(rols);
        Object clone = user.clone();
        System.out.println("clone = " + clone);

        //深度克隆 ObjectUtil.cloneByStream(obj)
        User byStream = ObjectUtil.cloneByStream(user);
        System.out.println("byStream = " + byStream);
    }

    /**
     * 类型转换 Convert
     */
    @Test
    public void testConvert() {
        int a = 1;
//aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println("aStr = " + aStr);
        long[] b = {1, 2, 3, 4, 5};
//bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println("bStr = " + bStr);

        String[] c = {"1", "2", "3", "4"};
//结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        System.out.println("intArray = " + intArray);
        long[] d = {1, 2, 3, 4, 5};
//结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println("intArray2 = " + intArray2);
        String e = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println("value = " + value);
//转换集合
        List<?> list = Convert.toList(c);
        System.out.println("list = " + list);
//自定义转换
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
//此处做为示例自定义String转换，因为Hutool中已经提供String转换，请尽量不要替换
//替换可能引发关联转换异常（例如覆盖String转换会影响全局）
        converterRegistry.putCustom(String.class, CustomConverter.class);
        int f = 454553;
        String result = converterRegistry.convert(String.class, f);
        Assert.assertEquals("Custom: 454553", result);
        System.out.println("result = " + result);
    }


    /**
     * 时间日期 DateUtil
     */
    @Test
    public void testDateUtil() {
        //当前时间
        Date date = DateUtil.date();
        System.out.println("date = " + date);
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("date2 = " + date2);
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("date3 = " + date3);
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("now = " + now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println("today = " + today);


    }

    @Test
    public void testFormatDateUtil() {

        //格式化输出
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println("date = " + date);

//结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println("format = " + format);
//常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);
        System.out.println("formatDate = " + formatDate);
//结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println("formatDateTime = " + formatDateTime);
//结果：00:00:00
        String formatTime = DateUtil.formatTime(date);
        System.out.println("formatTime = " + formatTime);
    }

    /**
     * 农历日期-ChineseDate
     */
    @Test
    public void testChineseDate() {
        ChineseDate date = new ChineseDate(DateUtil.parseDate("2020-01-25"));
// 一月
        date.getChineseMonth();
// 正月
        date.getChineseMonthName();
// 初一
        date.getChineseDay();
// 庚子
        date.getCyclical();
// 鼠
        date.getChineseZodiac();
// 春节
        date.getFestivals();
// 庚子鼠年 正月初一
        date.toString();

    }

    /**
     * 树结构工具-TreeUtil
     */
    @Test
    public void testTreeUtil() {
        // 构建node列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();

        nodeList.add(new TreeNode<>("1", "0", "系统管理", 5));
        nodeList.add(new TreeNode<>("11", "1", "用户管理", 222222));
        nodeList.add(new TreeNode<>("111", "11", "用户添加", 0));
        nodeList.add(new TreeNode<>("2", "0", "店铺管理", 1));
        nodeList.add(new TreeNode<>("21", "2", "商品管理", 44));
        nodeList.add(new TreeNode<>("221", "2", "商品管理2", 2));

        // 0表示最顶层的id是0
        List<Tree<String>> treeList = TreeUtil.build(nodeList, "0");
        System.out.println("treeList = " + treeList);
    }

    /**
     * BeanUtil.fillBeanWithMap 使用Map填充bean
     */
    @Test
    public void testfillBeanWithMap() {
        HashMap<String, Object> map = CollUtil.newHashMap();
        map.put("name", "Joe");
        map.put("age", 12);
        map.put("openId", "DFDFSDFWERWER");

        SubPerson person = BeanUtil.fillBeanWithMap(map, new SubPerson(), false);
        System.out.println("person = " + person);
    }

    /**
     * BeanUtil.mapToBean
     */
    @Test
    public void testMapToBean() {
        HashMap<String, Object> map = CollUtil.newHashMap();
        map.put("a_name", "Joe");
        map.put("b_age", 12);
// 设置别名，用于对应bean的字段名
        HashMap<String, String> mapping = CollUtil.newHashMap();
        mapping.put("a_name", "name");
        mapping.put("b_age", "age");
        Person person = BeanUtil.mapToBean(map, Person.class, CopyOptions.create().setFieldMapping(mapping));
        System.out.println("person = " + person);
    }

    @Test
    public void test_mapToBeanIgnoreCase() {
        HashMap<String, Object> map = CollUtil.newHashMap();
        map.put("name", "Joe");
        map.put("age", 12);
        Person person = BeanUtil.mapToBean(map, Person.class, false);
        System.out.println("person = " + person);
    }

    /**
     * DynaBean是使用反射机制动态操作JavaBean的一个封装类
     */
    @Test
    public void test_DynaBean() {
//我们也可以通过反射构造对象
        DynaBean bean2 = DynaBean.create(User.class);
        User user = new User();
        DynaBean bean = DynaBean.create(user);
        bean.set("name", "李华");
        bean.set("age", 12);
        String name = bean.get("name");//输出“李华”
        System.out.println("name = " + name);

        //执行指定方法
        Object invoke = bean.invoke("testMethod");
        Assert.assertEquals("test for 李华", invoke);
    }


}