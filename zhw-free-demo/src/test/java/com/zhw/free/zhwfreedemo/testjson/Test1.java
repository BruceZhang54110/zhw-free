package com.zhw.free.zhwfreedemo.testjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {

      /*  JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "aaa");
        jsonObject.put("code", "123");
        TestBean testBean = JSONObject.toJavaObject(jsonObject, TestBean.class);
        System.out.println(testBean);*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "aaa");
        jsonObject.put("code", "123");

        JSONObject a = new JSONObject();
        a.put("id", 1);
        a.put("name", "属性a");
        JSONArray array = new JSONArray();
        array.add(a);
        jsonObject.put("listBean", array);

        TestBean<A> result = jsonObject.toJavaObject(new TypeReference<TestBean<A>>() {});
        System.out.println(result);
        System.out.println(result.getListBean().get(0).getName());

    }
}

class TestBean<T> {
    private String name;
    private String code;
    List<T> listBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<T> getListBean() {
        return listBean;
    }

    public void setListBean(List<T> listBean) {
        this.listBean = listBean;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", listBean=" + listBean +
                '}';
    }
}

class A {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
