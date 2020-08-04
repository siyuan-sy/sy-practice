package com.sy.demo.hutool;

import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<Department> children = new ArrayList<>();

    public Department(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
    static List<Department> departmentList = new ArrayList<>();

    @PostConstruct
    private  void setList(){

    }

    public static void main(String[] args) {

        departmentList.add(new Department(2, "不死鸟", 1));
        departmentList.add(new Department(3, "艾斯", 1));
        departmentList.add(new Department(5, "路飞", 4));
        departmentList.add(new Department(6, "索隆", 5));
        departmentList.add(new Department(7, "娜美", 5));
        departmentList.add(new Department(8, "罗宾", 5));
        departmentList.add(new Department(11, "思源", 8));
        departmentList.add(new Department(9, "乌索普", 5));
        departmentList.add(new Department(10, "小丑", 100));//小丑的长官Id不存在，所以tree中没有它的信息
        List<Department> copyList = new ArrayList<>();
        List<Department> list = new ArrayList<>();

        copyList.add(new Department(11, "白胡子", null));
        copyList.add(new Department(4, "龙", null));

        System.out.println("departmentList.size() = " + departmentList.size());
        list.addAll(copyList);
        makeTree(copyList, list);

        System.out.println("-------------------------->");
    }

    private static void makeTree(List<Department> copyList, List<Department> list) {
        for (Department vo : copyList) {
            List<Department> departments = makeAll(vo.getId());
            if(departments.size() != 0){
                list.addAll(departments);
                makeTree(departments,list);
            }else {
                continue;
            }
        }

    }

    private static List<Department>  makeAll(Integer id) {
        List<Department> newList = new ArrayList<>();
        departmentList.stream().forEach(x->{
           if(x.getParentId() == id){
               newList.add(x);
           }
        });
        return  newList;
    }
}

